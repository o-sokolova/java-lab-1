public class SpaceShipUtils {
    public static double getAvgSpeed(SpaceShip s1, SpaceShip s2, SpaceShip s3) {
        return ((double) s1.getSpeed() + s2.getSpeed() + s3.getSpeed())/3;
    }
    
    public static int getMinSpeed(SpaceShip s1, SpaceShip s2, SpaceShip s3) {
        return Min3.min(s1.getSpeed(), s2.getSpeed(), s3.getSpeed());
    }

    public static void main(String[] args) {
        SpaceShip s1 = new SpaceShip(0);
        SpaceShip s2 = new SpaceShip(Integer.MAX_VALUE);
        SpaceShip s3 = new SpaceShip(Integer.MAX_VALUE);
        System.out.println(SpaceShipUtils.getAvgSpeed(s1, s2, s3));
        System.out.println(SpaceShipUtils.getMinSpeed(s1, s2, s3));
    }
}
