/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */

public class Philosopher implements Runnable
{
    private DiningServerImpl dining;
    private int num;

    public Philosopher(int n)
    {
        dining = dining.getInstance();
        num = n;
    }


    public int getNum() { return num; }

    public void thinkEat(String str) throws InterruptedException
    {
        System.out.println(str);
        Thread.sleep((int) ((Math.random() * 2000) + 1000));
    }

    /*
            "Runnable interface is the primary template for any object that is intended to be executed by a thread.
            It defines a single method run(), which is meant to contain the code that is executed by the thread."
     */
    @Override
    public void run() {
        int roundsLeft = 1;
        while (roundsLeft > 0)
        {
            try {
                //think
                thinkEat(Thread.currentThread().getName() + " is thinking");

                //pick up forks
                dining.takeForks(num);

                //eat
                thinkEat(Thread.currentThread().getName() + " is eating");

                //put down
                dining.returnForks(num);

		//think
                thinkEat(Thread.currentThread().getName() + " is thinking again");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            roundsLeft--;
        }
    }
}
