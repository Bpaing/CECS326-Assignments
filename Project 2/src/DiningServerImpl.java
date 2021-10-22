/**
 * DiningServer.java
 *
 * This class contains the methods called by the  philosophers.
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
            'synchronized' keyword so a fork can only be picked up by one thread at a time

            ReentrantLock
            A re-entrant lock lets you write a method M that puts a lock on resource A and then call M recursively or
            from code that already holds a lock on A.

            With a non re-entrant lock, you would need 2 versions of M, one that locks and one that doesn't, and
            additional logic to call the right one.

*/
public class DiningServerImpl implements DiningServer
{
    private final Lock lock;
    private final Condition condition;
    private boolean[] forks;
    private static DiningServerImpl oneOnly = null;

    public DiningServerImpl()
    {
        lock = new ReentrantLock();
        condition = lock.newCondition();
        forks = new boolean[5];
        for (int i = 0; i < forks.length; i++)
            forks[i] = true;
    }

    public static DiningServerImpl getInstance()
    {
        if (oneOnly == null)
            oneOnly = new DiningServerImpl();
        return oneOnly;
    }

    @Override
    public void takeForks(int philNumber)
    {
        lock.lock();
        try {
            //thread waits while forks are unavailable
            while (!forks[philNumber - 1] || !forks[philNumber % forks.length]) {
                condition.await();
		        System.out.print( Thread.currentThread().getName() + " is awaiting...\n");
            }
            //forks are available for taking
            forks[philNumber - 1] = false;              //take left fork
            System.out.printf("%s picked up fork %d\n", Thread.currentThread().getName(), philNumber - 1);
            forks[philNumber % forks.length] = false;   //take right fork
            System.out.printf("%s picked up fork %d\n", Thread.currentThread().getName(), philNumber % forks.length);

        }   catch(InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public void returnForks(int philNumber)
    {
        lock.lock();

        forks[philNumber - 1] = true;                       //release left fork
        System.out.printf("%s put down fork %d\n", Thread.currentThread().getName(), philNumber - 1);
        forks[philNumber % forks.length] = true;    //release right fork
        System.out.printf("%s put down fork %d\n", Thread.currentThread().getName(), philNumber % forks.length);

        condition.signal();

        lock.unlock();
    }
}
