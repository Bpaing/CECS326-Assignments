/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */


public class DiningPhilosophers
{
    public static void main(String args[])
    {
        Philosopher[] phil = new Philosopher[5];
        Object[] forks = new Object[5];

        for (int i = 0; i < forks.length; i++)
            forks[i] = new Object();

        for (int i = 0; i < phil.length; i++) {
            Object left = forks[i];
            Object right = forks[(i+1 % forks.length)];
            //modulus length so that the last philosopher can use the first fork

            phil[i] = new Philosopher(left, right);

            Thread thread = new Thread(phil[i], "Philosopher #" + (i+1));
            thread.start();
            // now every philosopher is executing run() method
        }
    }
}
