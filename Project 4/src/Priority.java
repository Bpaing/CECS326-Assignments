/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

// Your code here
public class Priority implements Algorithm
{
    private List<Task> queue;

    public Priority(List<Task> queue) { this.queue = queue; }

    @Override
    public void schedule()
    {
        System.out.println("Scheduling order of Priority:");
        while (queue.size() != 0) {
            Task next = pickNextTask();
            queue.remove(next);
            CPU.run(next, next.getBurst());
            System.out.printf("Task %s has finished.\n\n", next.getName());
        }
    }

    //Picks the Task with the highest priority (smallest value).
    @Override
    public Task pickNextTask()
    {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < queue.size(); i++) {
            int currentPriority = queue.get(i).getPriority();
            if (currentPriority < min) {
                min = currentPriority;
                index = i;
            }
        }
        return queue.get(index);
    }


}