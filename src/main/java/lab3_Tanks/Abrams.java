package lab3_Tanks;

public class Abrams implements Tank {
    private int ammo = 5;
    
    @Override
    public void tankFire() {
        if (ammo != 0){
            System.out.println("Fire!");
            ammo --;
        }
        else {
            System.out.println("Empty");
        }
    }
}
