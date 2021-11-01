public class VillageRoad
{
    public static void main(String[] args)
    {
        EastVillage east = new EastVillage();
        WestVillage west = new WestVillage();

        Thread thread = new Thread(east, "East Person");
        Thread thread2 = new Thread(west, "West Person");
        thread.start();
        thread2.start();
    }
}
