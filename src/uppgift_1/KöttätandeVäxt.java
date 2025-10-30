package uppgift_1;

public class KöttätandeVäxt extends Växt {

    private final double köttÄtandeVäxtDagligVätskaBas = 0.1;
    private final double köttÄtandeVäxtDagligVätskaTillskott = 0.2;

    public KöttätandeVäxt(String namn, double höjdIMeter) {
        super(namn, höjdIMeter);
        setVätskeTyp(VätskeTyp.PROTEINVÄTSKA);
    }

    @Override
    public double getVätskeMängd() {
        return köttÄtandeVäxtDagligVätskaBas + (getHöjd() * köttÄtandeVäxtDagligVätskaTillskott);
    }
}
