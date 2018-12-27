package samochody;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SkrzyniaBiegowTest {

    @Test
    public void testZmienBieg() {
        Silnik myEngine = new Silnik("V6", 70, 18000, 14000, 0);
        Sprzeglo mySprzeglo = new Sprzeglo("quick-shifter", 4000, 5000, true);
        SkrzyniaBiegow myGear = new SkrzyniaBiegow("Manual", 50, 9000, 0, 6, 0, mySprzeglo);
        Samochod myCar = new Samochod(myGear, myEngine, "Black", "KT 1234", "Ford", "Mustang", 400);

        try {
            assertEquals(0, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zmienBieg((short) 3);
            assertEquals(3, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zmienBieg((short)-2);
            assertEquals(3, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zmienBieg((short) 6);
            assertEquals(6, myCar.rpm.getAktualnyBieg());

        } catch (BrakSprzeglaException e) {
            e.printStackTrace();
            System.out.println("W teście wystąpił wyjątek!");
        }
    }

    @Test
    public void testZwiekszBieg() {
        Silnik myEngine = new Silnik("V6", 70, 19000, 14000, 0);
        Sprzeglo mySprzeglo = new Sprzeglo("quick-shifter", 4500, 5000, true);
        SkrzyniaBiegow myGear = new SkrzyniaBiegow("Manual", 50, 9000, 0, 6, 0, mySprzeglo);
        Samochod myCar = new Samochod(myGear, myEngine, "Black", "KT 1234", "Ford", "Mustang", 400);


        try {
            assertEquals(0, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zwiekszBieg();    //1
            assertEquals(1, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zwiekszBieg();    //2
            myCar.rpm.zwiekszBieg();    //3
            assertEquals(3, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zwiekszBieg();    //4
            myCar.rpm.zwiekszBieg();    //5
            myCar.rpm.zwiekszBieg();    //6
            assertEquals(6, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zwiekszBieg();    //6
            assertEquals(6, myCar.rpm.getAktualnyBieg());

        } catch (BrakSprzeglaException e) {
            e.printStackTrace();
            System.out.println("W teście wystąpił wyjątek!");
        }
    }

    @Test
    public void testZmniejszBieg() {
        Silnik myEngine = new Silnik("V6", 70, 18500, 14000, 0);
        Sprzeglo mySprzeglo = new Sprzeglo("quick-shifter", 4200, 5000, true);
        SkrzyniaBiegow myGear = new SkrzyniaBiegow("Manual", 50, 9000, 0, 6, 0, mySprzeglo);
        Samochod myCar = new Samochod(myGear, myEngine, "Black", "KT 1234", "Ford", "Mustang", 400);

        try {
            assertEquals(0, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zmniejszBieg();    //-1
            assertEquals(-1, myCar.rpm.getAktualnyBieg());
            myCar.rpm.zmniejszBieg();   //-1
            assertEquals(-1, myCar.rpm.getAktualnyBieg());

        } catch (BrakSprzeglaException e) {
            e.printStackTrace();
            System.out.println("W teście wystąpił wyjątek!");
        }
    }
}