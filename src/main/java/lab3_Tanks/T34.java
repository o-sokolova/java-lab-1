package lab3_Tanks;

public class T34 implements Tank {
    private int ammo = 5;

    @Override
    public void tankFire() {
        if (ammo != 0){
            System.out.println("Огонь!");
            ammo --;
        }
        else {
            System.out.println("Пустой");
        }
    }
}
