package samochody;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class SamochodGUI extends JFrame implements Obserwator{
    private Samochod car;
    private String lastError;

    private JPanel panel1;
    private JPanel Samochód;
    private JPanel Silnik;
    private JPanel SkrzyniaBiegów;
    private JPanel Sprzęgło;
    private JCheckBox silnikWłączonyCheckBox;
    private JButton zwiększObrotyButton;
    private JButton zmniejszObrotyButton;
    private JSlider ZmienBieg;
    private JTextField kolorTextField;
    private JTextField nrRejestTextField;
    private JTextField modelTextField;
    private JTextField markaTextField;
    private JTextField vMaxTextField;
    private JTextField wagaTextField;
    private JTextField ilośćBiegówTextField;
    private JTextField aktualnyBiegTextField;
    private JTextField obrotyTextField;
    private JTextField maxObrotyTextField;
    private JTextField sprzęgłoWłączoneTextField;
    private JTextField errorTextField;
    private JRadioButton załączSprzęgłoRadioButton;
    private JTextField nazwaTextField;
    private JTextField wagaTextField2;
    private JTextField cenaTextField;
    private JTextField nazwaTextField1;
    private JTextField wagaTextField1;
    private JTextField cenaTextField1;
    private JTextField nazwaTextField2;
    private JTextField wagaTextField3;
    private JTextField cenaTextField2;


    public SamochodGUI(Samochod _car) {
        car = _car;
        lastError = "";

        this.setTitle("SamochodGUI");
        this.add(panel1);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        refresh();

        zwiększObrotyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    car.engine.zwieksz_obroty();
                } catch (SamochodWylaczonyException e1){
                    lastError = "Włącz Samochód!";
                }
                refresh();
            }
        });

        zmniejszObrotyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    car.engine.zmniejsz_obroty();
                } catch (SamochodWylaczonyException e1) {
                    lastError = "Włącz Samochód!";
                }
                refresh();
            }
        });


        silnikWłączonyCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (car.engine.getObroty() == 0){
                    car.engine.uruchom();
                    lastError = "";
                } else {
                    car.engine.zatrzymaj();
                }

                refresh();
            }
        });
        załączSprzęgłoRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (car.rpm.sprzeglo.isStanSprzegla() == false){
                    car.rpm.sprzeglo.zalacz();
                    lastError = "";
                } else {
                    car.rpm.sprzeglo.rozlacz();
                }

                refresh();
            }
        });

        ZmienBieg.addComponentListener(new ComponentAdapter() {
        });
        ZmienBieg.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    car.rpm.zmienBieg((short) ZmienBieg.getValue());
                } catch (BrakSprzeglaException e2){
                    lastError = "Naciśnij sprzęgło!";
                    ZmienBieg.setValue(car.rpm.getAktualnyBieg());
                }
                refresh();
            }
        });

        car.engine.subskrybuj(this);
        car.engine.run();
    }

    public void refresh(){
        kolorTextField.setText(car.getKolor());
        nrRejestTextField.setText(car.getNrRejst());
        modelTextField.setText(car.getModel());
        markaTextField.setText(car.getMarka());
        vMaxTextField.setText(Integer.toString(car.getvMax()));
        wagaTextField.setText(Float.toString(car.getWaga()));
        ilośćBiegówTextField.setText(Integer.toString(car.rpm.getIloscBiegow()));
        aktualnyBiegTextField.setText(Integer.toString(car.rpm.getAktualnyBieg()));
        obrotyTextField.setText(Float.toString(car.engine.getObroty()));
        maxObrotyTextField.setText(Float.toString(car.engine.getMax_obroty()));
        sprzęgłoWłączoneTextField.setText(Boolean.toString(car.rpm.sprzeglo.isStanSprzegla()));
        nazwaTextField.setText(car.rpm.getNazwa());
        wagaTextField2.setText(Float.toString(car.rpm.getWaga()));
        cenaTextField.setText(Integer.toString(car.rpm.getCena()));
        nazwaTextField1.setText(car.engine.getNazwa());
        wagaTextField1.setText(Float.toString(car.engine.getWaga()));
        cenaTextField1.setText(Integer.toString(car.engine.getCena()));
        nazwaTextField2.setText(car.rpm.sprzeglo.getNazwa());
        wagaTextField3.setText(Float.toString(car.rpm.sprzeglo.getWaga()));
        cenaTextField2.setText(Integer.toString(car.rpm.sprzeglo.getCena()));

        errorTextField.setText(this.lastError);
    }

    public void inform(){
        this.refresh();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SamochodGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
