public class Gast extends Ladung {

    private String bezeichnung;
    private int menge;
    private final String heimatplaneten;
    private final String sprache;
    private Versorgungsart verpflegung;

    public Gast(String bezeichnung, int menge, String heimat, String sprache, Versorgungsart verpflegung){
        super(bezeichnung, menge);
        this.heimatplaneten = heimat;
        this.sprache = sprache;
        this.verpflegung = verpflegung;
    }





    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className;
    }

    @Override
    public String getBezeichnung() {
        return bezeichnung;
    }

    @Override
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Override
    public int getMenge() {
        return menge;
    }

    @Override
    public void setMenge(int menge) {
        this.menge = menge;
    }

    public String getHeimatplaneten() {
        return heimatplaneten;
    }

    public String getSprache() {
        return sprache;
    }

    public Versorgungsart getVerpflegung() {
        return verpflegung;
    }

    public void setVerpflegung(Versorgungsart verpflegung) {
        this.verpflegung = verpflegung;
    }
}
