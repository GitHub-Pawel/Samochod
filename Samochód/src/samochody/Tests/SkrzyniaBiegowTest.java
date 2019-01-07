package samochody.Tests;

import org.junit.jupiter.api.Test;
import samochody.Exceptions.BrakSprzeglaException;
import samochody.Samochod;
import samochody.Silnik;
import samochody.SkrzyniaBiegow;
import samochody.Sprzeglo;

import static org.testng.Assert.assertEquals;

class SkrzyniaBiegowTest {
    private Silnik myEngine = new Silnik("V6", 70, 18000, 14000, 0);
    private Sprzeglo mySprzeglo = new Sprzeglo("quick-shifter", 4000, 5000, true);
    private SkrzyniaBiegow myGear = new SkrzyniaBiegow("Manual", 50, 9000, 0, 6, 0, mySprzeglo);
    private Samochod myCar = new Samochod(myGear, myEngine, "Black", "KT 1234", "Ford", "Mustang", 400);

    @Test
    void zmienBieg() {
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
    void zwiekszBieg() {
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
    void zmniejszBieg() {
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