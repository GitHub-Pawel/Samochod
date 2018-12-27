package samochody;

public class Main {
    public static void main(String[] args) {
        Silnik myEngine = new Silnik("V8", 70, 18000, 14000, 0);
        Sprzeglo mySprzeglo = new Sprzeglo("quick-shifter", 4000, 5000, false);
        SkrzyniaBiegow myGear = new SkrzyniaBiegow("Manual", 50, 9000, 0, 6, 0, mySprzeglo);
        Samochod myCar = new Samochod(myGear, myEngine, "Black", "KT 1234", "Ford", "Mustang", 400);

        System.out.println("Waga całego samochodu: " + myCar.obliczWage() + " kg");

        SamochodGUI samochodGUI = new SamochodGUI(myCar);
    }
}
