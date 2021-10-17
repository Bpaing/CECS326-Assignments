/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */

public class Philosopher implements Runnable
{
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object left, Object right)
    {
        leftFork = left;
        rightFork = right;
    }

    /*
            "Runnable interface is the primary template for any object that is intended to be executed by a thread.
            It defines a single method run(), which is meant to contain the code that is executed by the thread."
     */
    @Override
    public void run() {
        while (true)
        {
            //think
            //pick up forks
                //takeForks()
            //eat
            //put down
                //returnForks
        }
    }
}
