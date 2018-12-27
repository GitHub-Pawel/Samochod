package samochody;

import java.util.Random;

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

    public void zwieksz_obroty() throws SamochodWylaczonyException {
        if(obroty == 0) throw new SamochodWylaczonyException();
        else if (this.obroty+1000 <= this.max_obroty){
            this.obroty += 1000;
        }
    }

    public void zmniejsz_obroty(int change) {
        if (getObroty() >= change){
            this.obroty -= change;
        }
    }

    public void zmniejsz_obroty() throws SamochodWylaczonyException {
        if(obroty == 0){
            throw new SamochodWylaczonyException();
        } else if (getObroty() >= 1000){
            this.obroty -= 1000;
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
            if (obroty != 0) {
                obroty += losowa;
                //System.out.println(obroty);
            }
            obserwator.inform();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
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
