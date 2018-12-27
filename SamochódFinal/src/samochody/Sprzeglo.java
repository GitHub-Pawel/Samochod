package samochody;

public class Sprzeglo extends Komponent {
    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, float waga, int cena, boolean stanSprzegla) {
        super(nazwa, waga, cena);
        this.stanSprzegla = stanSprzegla;
    }

    public Sprzeglo() {
    }

    public void zalacz(){
        this.stanSprzegla = true;
    }

    public void rozlacz(){
        this.stanSprzegla = false;
    }

    public boolean isStanSprzegla() {
        return stanSprzegla;
    }
}
