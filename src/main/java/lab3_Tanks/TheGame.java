package lab3_Tanks;
import static lab3_Tanks.TankFactory.Country.*;

public class TheGame {
    public static void runGame() {
        Tank tankT34 = TankFactory.createTank(RUSSIA);
        Tank tankAbrams = TankFactory.createTank(USA);
        for (int i = 5; i >= 0 ; i--) {
            tankAbrams.tankFire();
            tankT34.tankFire();
        }
    }

    public static void main(String[] args) {
        TheGame.runGame();
    }
}
