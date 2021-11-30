/**
 * FCFS scheduling algorithm.
 */
 
import java.util.*;

//Your code here
public class FCFS implements Algorithm
{
    private List<Task> queue;

    public FCFS(List<Task> queue)
    {
        this.queue = queue;
    }

    @Override
    public void schedule()
    {
        System.out.println("Scheduling order of FCFS:");
        while (queue.size() != 0) {
           Task next = pickNextTask();
           queue.remove(next);
           CPU.run(next, next.getBurst());
           System.out.printf("%s, %d\n", next.getName(), next.getBurst());
       }
    }

    //FCFS chooses the first task in the queue.
    @Override
    public Task pickNextTask()
    {
        return queue.get(0);
    }
}