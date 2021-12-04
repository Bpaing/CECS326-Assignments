/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */

import java.util.*;

// Your code here
public class RR implements Algorithm
{
    private List<Task> queue;
    int quantum = 10;

    public RR(List<Task> queue) {this.queue = queue;}

    @Override
    public void schedule()
    {
        System.out.println("Scheduling order of RR:");
        System.out.println("quantum = " + quantum);
        while (queue.size() != 0) {
            Task next = pickNextTask();
            queue.remove(next);
            if (next.getBurst() > quantum) {
                CPU.run(next, quantum);
                next.setBurst(next.getBurst() - quantum);
                System.out.printf("%s ran for: %d\nRemaining Burst: %d\n\n", next.getName(), quantum, next.getBurst());
                queue.add(next);
            } else {
                CPU.run(next, next.getBurst());
                next.setBurst(0);
                System.out.printf("%s ran for: %d\nRemaining Burst: %d\n\n", next.getName(), quantum, next.getBurst());
                System.out.printf("Task %s has finished.\n\n", next.getName());
            }
        }
    }

    //Burst by TQ = 10. Requeue task to the end if time still left
    @Override
    public Task pickNextTask()
    {
        return queue.get(0);
    }
}