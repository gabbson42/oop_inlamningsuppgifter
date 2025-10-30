package uppgift_1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greenest {

    public Greenest() {

        /*Exempel på dynamisk bindning. Tillkallar klassen Växt men skapar upp objekt av olika växttyper*/
        Växt igge = new Kaktus("Igge", 0.2);
        Växt laura = new Palm("Laura", 5);
        Växt meatLoaf = new KöttätandeVäxt("Meatloaf", 0.7);
        Växt olof = new Palm("Olof", 1);

        List<Växt> allaVäxter = new ArrayList<>();
        Collections.addAll(allaVäxter, igge, laura, meatLoaf, olof);

        String växt = JOptionPane.showInputDialog("Vilken växt ska få vätska?");

        if (växt == null) {
            JOptionPane.showMessageDialog(null, "Program avbrutet");
            return;
        }

        if (växt.isBlank()) {
            JOptionPane.showMessageDialog(null, "Du måste fylla i ett namn");
            return;
        }

        boolean växtHittad = false;
        for (Växt v : allaVäxter) {
            if (växt.trim().equalsIgnoreCase(v.getNamn())) {
                växtHittad = true;

                JOptionPane.showMessageDialog(null, v.getNamn() +
                        " ska få " + v.getVätskeMängd() + " liter " +
                        v.getVätskeTyp().toString().toLowerCase());
                break;
            }
        }

        if (!växtHittad) {
            JOptionPane.showMessageDialog(null, "Ingen växt med namnet \"" +
                    växt + "\" kunde hittas");
        }
    }

    public static void main(String[] args) {

        Greenest run = new Greenest();

    }
}
