package samochody;

public class SkrzyniaBiegow extends Komponent{
    private int aktualnyBieg;
    private int iloscBiegow;
    private int aktualnePrzelozenie;

    Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, float waga, int cena, int aktualnyBieg, int iloscBiegow, int aktualnePrzelozenie, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.aktualnePrzelozenie = aktualnePrzelozenie;
        this.sprzeglo = sprzeglo;
    }

    public SkrzyniaBiegow(String nazwa, float waga, int cena, int aktualnyBieg, int iloscBiegow, int aktualnePrzelozenie)  {
        super(nazwa, waga, cena);
        this.aktualnyBieg = aktualnyBieg;
        this.iloscBiegow = iloscBiegow;
        this.aktualnePrzelozenie = aktualnePrzelozenie;
    }

    public SkrzyniaBiegow()  {
    }

    public void zmienBieg(short nrBiegu) throws BrakSprzeglaException {
        if (sprzeglo.isStanSprzegla() == false){
            throw new BrakSprzeglaException();
        } else if (nrBiegu <= this.iloscBiegow && nrBiegu >= -1){
            this.aktualnyBieg = nrBiegu;
        }
    }

    public void zwiekszBieg() throws BrakSprzeglaException {
        if (sprzeglo.isStanSprzegla() == false){
            throw new BrakSprzeglaException();
        } else if (this.aktualnyBieg < this.iloscBiegow){
            this.aktualnyBieg++;
        }
    }

    public void zmniejszBieg() throws BrakSprzeglaException {
        if (sprzeglo.isStanSprzegla() == false) {
            throw new BrakSprzeglaException();
        }else if (this.aktualnyBieg > -1){
            this.aktualnyBieg--;
        }
    }

    public void obliczPrelozenie(){
        //this.aktualnePrzelozenie = this.aktualnyBieg * obroty.getObroty();
        System.out.println("...");
    }

    public int getAktualnyBieg() {
        return aktualnyBieg;
    }

    public int getIloscBiegow() {
        return iloscBiegow;
    }

    public int getAktualnePrzelozenie() {
        return aktualnePrzelozenie;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

}
