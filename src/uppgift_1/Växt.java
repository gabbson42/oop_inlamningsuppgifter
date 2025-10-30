package uppgift_1;

/* Superklass. Ärvs av subklasserna Kaktus, Palm och KöttätandeVäxt. */
public class Växt  implements VattningsProtokoll {

    /*Exempel på inkapsling. Valt att göra variablerna private och
    * istället använda setters och getters där nödvändigt för att komma åt variablerna utifrån klassen.*/
    private String namn;
    private double höjd;
    private VätskeTyp vätskeTyp;

    public Växt(String namn, double höjdIMeter) {
        this.namn = namn;
        this.höjd = höjdIMeter;
    }

    public String getNamn() {
        return namn;
    }

    public double getHöjd() {
        return höjd;
    }

    public VätskeTyp getVätskeTyp() {
        return vätskeTyp;
    }

    public void setVätskeTyp(VätskeTyp vätskeTyp) {
        this.vätskeTyp = vätskeTyp;
    }

    /*Metod implementerad från interfacet "VattningsProtokoll".
    * Ger olika resultat beroende på vilken subklass som använder metoden (Polymorfism) */
    @Override
    public double getVätskeMängd() {
        return 0;
    }
}
