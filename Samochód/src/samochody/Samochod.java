package samochody;

public class Samochod {
    private String kolor;
    private String nrRejst;
    private String model;
    private String marka;
    private int vMax;
    private float waga;

    public SkrzyniaBiegow rpm;
    public Silnik engine;

    public Samochod(SkrzyniaBiegow rpm, Silnik engine, String kolor, String nrRejst, String model, String marka, int vMax) {
        this.rpm = rpm;
        this.engine = engine;
        this.kolor = kolor;
        this.nrRejst = nrRejst;
        this.model = model;
        this.marka = marka;
        this.vMax = vMax;
    }

    public Samochod() {
    }

    public void wlacz(){
        engine.uruchom();
    }

    public void wylacz(){
        engine.zatrzymaj();
    }

    public void jazda(){
        // ...
    }

    public float obliczWage(){
        waga = engine.getWaga() + rpm.sprzeglo.getWaga() + rpm.getWaga();
        return waga;
    }

    public String getKolor() {
        return kolor;
    }

    public String getNrRejst() {
        return nrRejst;
    }

    public String getModel() {
        return model;
    }

    public String getMarka() {
        return marka;
    }

    public int getvMax() {
        return vMax;
    }

    public float getWaga() {
        return waga;
    }
}
