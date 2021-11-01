public class WestVillage implements Runnable
{
    private SingleLaneRoad road;

    public WestVillage()
    {
        road = road.getInstance();
    }

    public void transact() throws InterruptedException
    {
        System.out.printf("%s is engaging in commerce.\n", Thread.currentThread().getName());
        Thread.sleep((int) ((Math.random() * 4000) + 1000));
    }

    @Override
    public void run()
    {
        while (true) {
            try {
                //take the road
                road.takeRoad();

                //eat donuts
                road.eatDonut();

                //exit the road
                road.exitRoad();

                //engage in commerce
                transact();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
