package samochody;

public abstract class Komponent {
    private String nazwa;
    private float waga;
    private int cena;

    public Komponent(String nazwa, float waga, int cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

    public Komponent() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public float getWaga() {
        return waga;
    }

    public int getCena() {
        return cena;
    }
}

