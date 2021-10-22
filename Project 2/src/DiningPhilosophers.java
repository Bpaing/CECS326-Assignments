/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */


public class DiningPhilosophers
{
    public static void main(String[] args)
    {
        Philosopher[] phil = new Philosopher[5];

        for (int i = 0; i < phil.length; i++) {
            phil[i] = new Philosopher(i+1);

            Thread thread = new Thread(phil[i], "Philosopher #" + phil[i].getNum());
            thread.start();
            // now every philosopher is executing run() method
        }
    }
}
