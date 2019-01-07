package samochody;

public class Main {
    public static void main(String[] args) {
        Silnik myEngine = new Silnik("V8", 200, 24000, 14000, 0);
        Sprzeglo mySprzeglo = new Sprzeglo("Quick-Shifter", 5, 2000, false);
        SkrzyniaBiegow myGear = new SkrzyniaBiegow("Manual", 50, 9000, 0, 6, 0, mySprzeglo);
        Samochod myCar = new Samochod(myGear, myEngine, "Black", "KT 1234", "Ford", "Mustang", 299);

        System.out.println("Waga całego samochodu: " + myCar.obliczWage() + " kg");

        SamochodGUI samochodGUI = new SamochodGUI(myCar);
    }
}
