import java.util.ArrayList;
import java.util.Random;

public class Raumschiff {



    /**Anzahl der verfügbaren Photonentorpedos, die nicht im Ladungsverzeichnis sind. */
    private int photonentorpedoAnzahl;

    /** Prozentzahl der verfügbaren Energieversorgung*/
    private int energieversorgungInProzent;

    /** Prozentzahl, die den Zustand des aktuellen Schildes beschreibt*/
    private int schildeInProzent;

    /**Prozentzahl, die den Zustand der aktuellen Hülle beschreibt */
    private int huelleInProzent;

    /**Prozentahl, die den Zustand der Lebenserhaltungssysteme beschreibt */
    private int lebenserhaltungssystemeInProzent;

    /** Die Anzahl der verfügbaren Androiden*/
    private int androidenAnzahl;

    /** Der Schiffsname*/
    private String schiffsname;

    /** Der Kommunikator auf dem alle Meldungen gespeichert werden*/
    private static final ArrayList<String> broadcastKommunikator = new ArrayList<String>();

    /** Das Verzeichnis aus dem alle momentanen Ladungen ausgelesen werden können */
    private final ArrayList<Ladung> ladungsverzeichnis = new ArrayList<Ladung>();

    public Raumschiff() {

    }

    public Raumschiff(int photonentorpedoAnzahl, int energieversorgungInProzent, int schildeInProzent, int huelleInProzent, int lebenserhaltungssystemeInProzent, int androidenAnzahl, String schiffsname)
    {
        this.photonentorpedoAnzahl = photonentorpedoAnzahl;
        this.energieversorgungInProzent = energieversorgungInProzent;
        this.schildeInProzent = schildeInProzent;
        this.huelleInProzent = huelleInProzent;
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
        this.androidenAnzahl = androidenAnzahl;
        this.schiffsname = schiffsname;
    }

    public int getPhotonentorpedoAnzahl() {
        return photonentorpedoAnzahl;
    }

    public void setPhotonentorpedoAnzahl(int photonentorpedoAnzahl) {
        this.photonentorpedoAnzahl = photonentorpedoAnzahl;
    }

    public int getEnergieversorgungInProzent() {
        return energieversorgungInProzent;
    }

    public void setEnergieversorgungInProzent(int energieversorgungInProzent) {
        this.energieversorgungInProzent = energieversorgungInProzent;
    }

    public int getSchildeInProzent() {
        return schildeInProzent;
    }

    public void setSchildeInProzent(int schildeInProzent) {
        this.schildeInProzent = schildeInProzent;
    }

    public int getHuelleInProzent() {
        return huelleInProzent;
    }

    public void setHuelleInProzent(int huelleInProzent) {
        this.huelleInProzent = huelleInProzent;
    }

    public int getLebenserhaltungssystemeInProzent() {
        return lebenserhaltungssystemeInProzent;
    }

    public void setLebenserhaltungssystemeInProzent(int lebenserhaltungssystemeInProzent) {
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent;
    }

    public int getAndroidenAnzahl() {
        return androidenAnzahl;
    }

    public void setAndroidenAnzahl(int androidenAnzahl) {
        this.androidenAnzahl = androidenAnzahl;
    }

    public String getSchiffsname() {
        return schiffsname;
    }

    public void setSchiffsname(String schiffsname) {
        this.schiffsname = schiffsname;
    }

    /**Fügt Ladungen in das Ladungsverzeichnis hinzu*/
    public void addLadung(Ladung neueLadung) {
        ladungsverzeichnis.add(neueLadung);
    }

    /**Nimmt ein Objekt der Klasse Raumschiff als Parameter an. Wenn die verfügbare Photonentorpedoanzahl null ist,
     * wird eine Nachricht "Click" an den Broadcasterkommunikator mithilfe der Methode "Nachricht an alle" übermittelt.
     *
     * Ansonsten wird der Photonentorpedoanzahl um eins verringert und es wird die Nachricht "Photonentorpedo abgeschossen.
     * Danach wird die private Funktion "treffer" aufgerufen um den Schuss zu registrieren.*/
    public void photonentorpedoSchiessen(Raumschiff r) {
        if (this.photonentorpedoAnzahl == 0) {
            nachrichtAnAlle("-=*Click*=-");
        }
        this.photonentorpedoAnzahl--;

        nachrichtAnAlle("Photonentorpedo abgeschossen");
        treffer(r);
    }

    /** Nimmt ein Objekt der Klasse Raumschiff als Parameter an. Wenn die Energieversorgung zu niedrig ist, wird eine Nachricht "Click" an den Broadcastkommunikator übermittelt.
     *
     * Ansonsten wird eine Nachricht mit "Phaserkanone wurde abgeschossen" übermittelt und die Methode "treffer" aufgerufen um den Treffer zu registrieren.*/
    public void phaserkanoneSchiessen(Raumschiff r) {
        if(this.energieversorgungInProzent < 50) {
            nachrichtAnAlle("-=*Click*=-");
        }
        this.energieversorgungInProzent -= 50;
        nachrichtAnAlle("Phaserkanone abgeschossen");

        treffer(r);
    }

    /** Nimmt ein Objekt der Klasse Raumschiff als Parameter an. Zuerst wird die Nachricht "{Schiffname} wurde getroffen" an den Broadcastkommunikator übermittelt.
     * Dabei weist Schiffsname auf das Attribut des jeweiligen Objektes hin.
     * Die Schilde des jeweiligen Objektes werden um 50 verringert. Wenn die Schilde komplett unten sind, werden die Hülle und Energieversorgung herabgesetzt.
     * Falls die Hülle ebenfalls gleich null ist, werden die Lebenserhaltungssysteme auf null gesetzt und es wird eine Nachricht übermittelt, dass die Systeme vernichtet wurden.*/
    private void treffer(Raumschiff r) {
        nachrichtAnAlle(r.getSchiffsname() + " wurde getroffen!");
        r.setSchildeInProzent(r.getSchildeInProzent()-50);
        if(r.getSchildeInProzent() == 0) {
            r.setEnergieversorgungInProzent(r.getEnergieversorgungInProzent()-50);
            r.setHuelleInProzent(r.getHuelleInProzent()-50);
        }
        if(r.getHuelleInProzent() == 0) {
            r.setLebenserhaltungssystemeInProzent(0);
            r.nachrichtAnAlle("Lebenserhaltungssysteme wurden vernichtet!");
        }

    }

    /** Fügt eine Nachricht dem Broadcastkommunikator hinzu.*/
    public void nachrichtAnAlle(String message) {
        broadcastKommunikator.add(message);
    }

    /** Gibt sämtliche Einträge im Broadcastkommunikator wieder, unabhängig von den Instanzen der Klasse.*/
    public static ArrayList<String> eintraegeAnLogbuchZurueckgeben() {
        return broadcastKommunikator;
    }

    /** Nimmt die Anzahl der Torpedos als Parameter an. Erst wird überprüft, ob Photonentorpedos überhaupt im Ladungsverzeichnis vorhanden sind.
     * Falls keine vorhanden sind, wird dieses ausgegeben. Falls mehr geladen werden, als vorhanden, werden sämtlichen verfügbaren Torpedos geladen.
     * Ansonsten wird die Anzahl der Torpedos im Ladungsverzeichnis angepasst.
     * Danach wird an die Konsole ausgegeben, wie viele Torpedos geladen wurden.*/
    public void photonentorpedosLaden(int anzahlTorpedos) {

        for(Ladung ladung : ladungsverzeichnis) {
            if (ladung.getBezeichnung() != "Photonentorpedo") {
                System.out.println("Keine Photonentorpedo gefunden!");
            }
            if(ladung.getMenge() < anzahlTorpedos) {
                photonentorpedoAnzahl = anzahlTorpedos;
            }
            photonentorpedoAnzahl = anzahlTorpedos;
            ladung.setMenge(anzahlTorpedos);

            System.out.println(anzahlTorpedos + " Photonentorpedo(s) wurden eingesetzt");
        }
    }

    /**Als Parameter nimmt die Methode drei Boolean-Werte an, die die Raumschiffstellen repräsentieren, die repariert werden sollen und die Anzahl der Androiden,
     * die für diesen Vorgang eingesetzt werden.
     *
     * Für die Berechnung des Reparaturwertes, wird eine zufällige Zahl generiert und überprüft, wie viele Stellen repariert werden sollen.
     * Wenn mehr Androiden eingesetzt werden sollen, als verfügbar sind, werden alle verfügbaren Androiden eingesetzt.
     * Die Stellen werden dann um der berechneten Prozentzahl repariert und deren Wert wird angehoben.*/
    public void reparaturDurchfuehren (boolean schutzschilde, boolean energieversorgung, boolean schiffshuelle, int anzahlDroiden)
    {
        int benoetigteReparaturenAnzahl = 0;

        if(schutzschilde){
            benoetigteReparaturenAnzahl++;
        }
        if(energieversorgung){
            benoetigteReparaturenAnzahl++;
        }
        if(schiffshuelle){
            benoetigteReparaturenAnzahl++;
        }

        Random random = new Random();
        int randomNumber = random.nextInt(101);
        if(getAndroidenAnzahl() < anzahlDroiden) {
            anzahlDroiden = getAndroidenAnzahl();
        }
        int reparaturInProzent = ((randomNumber * getAndroidenAnzahl()) / benoetigteReparaturenAnzahl);

        if(schutzschilde){
            setSchildeInProzent(getSchildeInProzent() + reparaturInProzent);
        }
        if(energieversorgung){
            setEnergieversorgungInProzent(getEnergieversorgungInProzent() + reparaturInProzent);
        }
        if(schiffshuelle){
            setHuelleInProzent(getHuelleInProzent() + reparaturInProzent);
        }

    }

    /**Der Zustand des Raumschiffes wird ausgegeben */
    public void zustandRaumschiff() {
        System.out.println("Zustand des Schiffes wird abgerufen. Bitte warten.");
        System.out.println("Name des Schiffes: " + schiffsname);
        System.out.println("Anzahl der Photonentorpedos: " + photonentorpedoAnzahl);
        System.out.println("Anzahl der Energieversogung in Prozent: " + energieversorgungInProzent);
        System.out.println("Schildwert in Prozent: " + schildeInProzent);
        System.out.println("Hüllenwert in Prozent: " + huelleInProzent);
        System.out.println("Wert der Lebenserhaltungssysteme in Prozent: " + lebenserhaltungssystemeInProzent);
        System.out.println("Anzahl der Androiden: " + androidenAnzahl);

    }

    /** Für jeden Eintrag im Ladungsverzeichnis wird die Bezeichnung und die Menge der Ladung ausgelesen.*/
    public void ladungsverzeichnisAusgeben() {
        for(Ladung ladung: ladungsverzeichnis) {
            System.out.print("Ladungsbezeichnung: " + ladung.getBezeichnung() + "\n" + "Ladungsmenge: " + ladung.getMenge());
        }
    }


    /** Wenn die Menge einer Ladung null ist, wird der Eintrag aus dem Ladungsverzeichnis entfernt. */
    public void ladungsverzeichnisAufraeumen() {


        for(Ladung ladung: ladungsverzeichnis) {

            if (ladung.getMenge() == 0) {
                ladungsverzeichnis.remove(ladung);
            }
        }
    }
}
