package uppgift_1;

public class Palm extends Växt {

    private final double palmDagligVätska = 0.5;

    public Palm(String namn, double höjdIMeter) {
        super(namn, höjdIMeter);
        setVätskeTyp(VätskeTyp.KRANVATTEN);
    }

    @Override
    public double getVätskeMängd() {
        return palmDagligVätska * getHöjd();
    }
}
