public abstract class Ladung {

    private String bezeichnung;
    private int menge;

    public Ladung(String bezeichnung, int menge) {
        this.bezeichnung = bezeichnung;
        this.menge = menge;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    /**Die toString() Methode wird überschrieben um den Namen der Klasse, deren Bezeichnung und deren Menge auszugeben.*/

    public abstract String toString();
}//aAAAAAAAAAAAAAAAAAAA
