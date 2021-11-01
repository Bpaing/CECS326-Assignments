import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SingleLaneRoad
{
    private final Lock lock;
    private final Condition condition;
    private boolean road;
    private static SingleLaneRoad single = null;

    public SingleLaneRoad()
    {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        road = true;
    }

    public static SingleLaneRoad getInstance()
    {
        if (single == null)
            single = new SingleLaneRoad();
        return single;
    }

    public void takeRoad()
    {
        lock.lock();
        try {
            //thread waits while road is occupied
            while (!road) {
                condition.await();
                System.out.print( Thread.currentThread().getName() + " is awaiting...\n");
            }
            road = false;   //enter the road
            System.out.printf("A person from %s has taken the road.\n", Thread.currentThread().getName());
        }   catch(InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void exitRoad()
    {
        lock.lock();

        road = true;        //exit the road
        System.out.printf("A person from %s has exited the road.\n", Thread.currentThread().getName());
        condition.signal();

        lock.unlock();
    }

    public void eatDonut() throws InterruptedException
    {
        lock.lock();
        Thread.sleep((int) ((Math.random() * 2000) + 1000));
        lock.unlock();
    }
}
