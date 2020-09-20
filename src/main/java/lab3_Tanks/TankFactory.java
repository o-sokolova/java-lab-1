package lab3_Tanks;

public class TankFactory {
    enum Country {RUSSIA, USA}

    public static Tank createTank(Country country) {
        if (country == Country.RUSSIA) {
            return new T34();
        }
        else if (country == Country.USA){
            return new Abrams();
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
