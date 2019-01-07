package samochody;

import samochody.Exceptions.SamochodWylaczonyException;
import java.util.Random;
import static java.lang.Math.abs;

public class Silnik extends Komponent implements Runnable{
    private int max_obroty;
    private int obroty;
    private Obserwator obserwator;

    public Silnik() {
    }

    public Silnik(String nazwa, float waga, int cena, int max_obroty, int obroty) {
        super(nazwa, waga, cena);
        this.max_obroty = max_obroty;
        this.obroty = obroty;
    }

    public void uruchom(){
        obroty = 1500;
    }

    public void zatrzymaj(){
        obroty = 0;
    }

    public void zwieksz_obroty(int value) throws SamochodWylaczonyException {
        if(obroty == 0) throw new SamochodWylaczonyException();
        else if (this.obroty+value <= this.max_obroty){
            this.obroty += value;
        }
    }

    public void zwieksz_obroty() throws SamochodWylaczonyException{
        if(obroty == 0) throw new SamochodWylaczonyException();
        else {
            this.zwieksz_obroty(1000);
        }
    }

    public void zmniejsz_obroty(int change) throws SamochodWylaczonyException{
        if(obroty == 0){
            throw new SamochodWylaczonyException();
        } else if (this.obroty-change > 0){
            this.obroty -= change;
        }
    }

    public void zmniejsz_obroty() throws SamochodWylaczonyException {
        if(obroty == 0){
            throw new SamochodWylaczonyException();
        } else {
            this.zmniejsz_obroty(1000);
        }
    }

    public void subskrybuj(Obserwator o){
        obserwator = o;
    }

    public void odsubskrybuj(Obserwator o){
        if (obserwator == o){
            obserwator = null;
        }
    }

    public void run(){
        Random r = new Random();
        int losowa;
        while (true){
            losowa = r.nextInt(21) - 10;

            if (losowa > 0){
                try {
                    this.zwieksz_obroty(losowa);
                } catch (SamochodWylaczonyException e1){
                }
            } else {
                try {
                    this.zmniejsz_obroty(abs(losowa));
                } catch (SamochodWylaczonyException e2){
                }
            }

            obserwator.inform();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e3) {
            }
        }
    }

    public int getObroty() {
        return obroty;
    }

    public int getMax_obroty() {
        return max_obroty;
    }
}
