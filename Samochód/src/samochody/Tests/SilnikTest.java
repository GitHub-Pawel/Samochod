package samochody.Tests;

import org.junit.jupiter.api.Test;
import samochody.Exceptions.SamochodWylaczonyException;
import samochody.Samochod;
import samochody.Silnik;
import samochody.SkrzyniaBiegow;
import samochody.Sprzeglo;

import static org.junit.jupiter.api.Assertions.*;

class SilnikTest {
    private Silnik myEngine = new Silnik("V6", 70, 18000, 14000, 0);
    private Sprzeglo mySprzeglo = new Sprzeglo("quick-shifter", 4000, 5000, true);
    private SkrzyniaBiegow myGear = new SkrzyniaBiegow("Manual", 50, 9000, 0, 6, 0, mySprzeglo);
    private Samochod myCar = new Samochod(myGear, myEngine, "Black", "KT 1234", "Ford", "Mustang", 400);

    @Test
    void zwieksz_obroty() {
        try{
            myCar.wlacz();
            assertEquals(1500, myCar.engine.getObroty());

            myCar.engine.zwieksz_obroty();
            assertEquals(2500, myCar.engine.getObroty());

            myCar.engine.zwieksz_obroty();
            assertEquals(3500, myCar.engine.getObroty());

            for (int i = 0; i<10; ++i){
                myCar.engine.zwieksz_obroty();
            }
            assertEquals(13500, myCar.engine.getObroty());
            myCar.wylacz();
        } catch (SamochodWylaczonyException e){
            System.out.println("An error in the test!");
        }
    }

    @Test
    void zmniejsz_obroty() {
        try{
            myCar.wlacz();
            assertEquals(1500, myCar.engine.getObroty());

            myCar.engine.zmniejsz_obroty();
            assertEquals(500, myCar.engine.getObroty());

            for (int i = 0; i<10; ++i){
                myCar.engine.zmniejsz_obroty();
            }
            assertEquals(500, myCar.engine.getObroty());
        } catch (SamochodWylaczonyException e){
            System.out.println("An error in the test!");
        }
    }
}