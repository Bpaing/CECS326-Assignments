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

    private void doSomething(String str) {
        System.out.printf("%s is currently %s", Thread.currentThread().getName(), str);
    }

    /*
            "Runnable interface is the primary template for any object that is intended to be executed by a thread.
            It defines a single method run(), which is meant to contain the code that is executed by the thread."

            define threads in main?
     */
    @Override
    public void run() {
        while (true)
        {
            //think
            doSomething("thinking");
            //pick up either left or right

            //eat (when both picked up)
            doSomething("eating");
            //put down
        }
    }
}
