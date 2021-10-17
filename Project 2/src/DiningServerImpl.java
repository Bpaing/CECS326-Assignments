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
    @Override
    public void takeForks(int philNumber) {

    }

    @Override
    public void returnForks(int philNumber) {

    }
}
