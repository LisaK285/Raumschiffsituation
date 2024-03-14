public class Gast extends Ladung {

    private String bezeichnung;
    private int menge;
    private String heimatplaneten;
    private String sprache;
    private String verpflegung;

    public Gast(String bezeichnung, int menge, String heimat, String sprache, String verpflegung){
        super(bezeichnung, menge);
        this.heimatplaneten = heimat;
        this.sprache = sprache;
    }





    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className;
    }
}
