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

    public RR(List<Task> queue) {this.queue = queue;}

    @Override
    public void schedule()
    {
        System.out.println("Scheduling order of RR:");
        while (queue.size() != 0) {
            Task next = pickNextTask();
            queue.remove(next);
            CPU.run(next, next.getBurst());
            System.out.printf("Task %s has finished.\n\n", next.getName());
        }
    }

    //Burst by TQ = 10. Requeue task to the end if time still left
    @Override
    public Task pickNextTask()
    {
        //INCOMPLETE SYNTAX TO MAKING A READY QUEUE
        /*
        int quantum = 10;
        List<Task> readyQueue = null;
        for (int i = 0; i < queue.size(); i++){
            //theres no arrival times

            readyQueue.add(queue.get(i));
        }
        Task temp =
        //return readyQueue.get(0);
         */

        int quantum = 10;
        queue.get(0).setBurst(queue.get(0).getBurst()-quantum);
        //Unsure what else to do with Priority. Treat like Arrival Time??
        //queue.get(0).setPriority(queue.get(0).getPriority()-quantum);
        if(queue.get(0).getBurst() > 0){
            //if the task isn't done by the quantum time limit, it gets added to the back
            queue.add(queue.get(0));
        }
        return queue.get(0);
    }
}