public class Transportgut extends Ladung {

    private double laengeMeter;
    private double breiteMeter;

    private double hoeheMeter;

    private String bezeichnung;

    private int menge;

    public Transportgut(String bezeichnung, int menge, double laengeMeter, double breiteMeter, double hoeheMeter){
        super(bezeichnung, menge);
        this.laengeMeter = laengeMeter;
        this.breiteMeter = breiteMeter;
        this.hoeheMeter = hoeheMeter;
    }

    public double getLaengeMeter() {
        return laengeMeter;
    }

    public void setLaengeMeter(double laengeMeter) {
        this.laengeMeter = laengeMeter;
    }

    public double getBreiteMeter() {
        return breiteMeter;
    }

    public void setBreiteMeter(double breiteMeter) {
        this.breiteMeter = breiteMeter;
    }

    public double getHoeheMeter() {
        return hoeheMeter;
    }

    public void setHoeheMeter(double hoeheMeter) {
        this.hoeheMeter = hoeheMeter;
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

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        return className;
    }
}
