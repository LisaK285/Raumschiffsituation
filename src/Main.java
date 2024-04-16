import com.sun.jdi.connect.Transport;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    //Raumschiffe
    static Raumschiff klingonen = new Raumschiff(1, 100, 100, 100, 100, 2, "IKS Hegh'ta");
    static Raumschiff romulaner = new Raumschiff(2, 100, 100, 100, 100, 2, "IRW Khazara");
    static Raumschiff vulkanier = new Raumschiff(0, 80, 80, 50, 100, 5, "Ni'var");

    //Ladungen

    static Transportgut transportgut1 = new Transportgut("Ferengi Schneckensaft", 200, 0.2, 0.2, 0.1);
    static Transportgut transportgut2 = new Transportgut("Bat'leth Klingonen Schwert", 200, 0.8, 0.2, 0.1);
    static Gast gast1 = new Gast("Borg", 200, "Delta-Quadrant", "irrelevant, alphanumerischer Code", Versorgungsart.ALLES_INKLUSIVE);
    static Transportgut transportgut3 = new Transportgut("Borg-Schrott", 5, 0.2, 0.5, 0.5);
    static Transportgut transportgut4 = new Transportgut("Rote Materie", 2, 1.0, 1.0, 1.0);
    static Transportgut transportgut5 = new Transportgut("Plasma-Waffe", 50, 1.0, 1.0, 1.0);
    static Transportgut transportgut6 = new Transportgut("Forschungssonde", 35, 100.0, 50.0, 25.0);
    static Transportgut transportgut7 = new Transportgut("Photonentorpedo", 3, 2.0, 2.0, 1.0);
    static Gast gast2 = new Gast("Ferengi", 10, "Ferenginar", "Ferengi", Versorgungsart.VOLLPENSION);


    public static void main(String[] args){

        klingonen.addLadung(transportgut1);
        klingonen.addLadung(transportgut2);
        klingonen.addLadung(gast1);

        romulaner.addLadung(transportgut3);
        romulaner.addLadung(transportgut4);
        romulaner.addLadung(transportgut5);

        vulkanier.addLadung(transportgut6);
        vulkanier.addLadung(transportgut7);
        vulkanier.addLadung(gast2);


        klingonen.photonentorpedoSchiessen(romulaner);
        romulaner.phaserkanoneSchiessen(klingonen);

        vulkanier.nachrichtAnAlle("Gewalt ist nicht logisch");

        klingonen.zustandRaumschiff();
        klingonen.ladungsverzeichnisAusgeben();

        vulkanier.reparaturDurchfuehren(true, true, true, vulkanier.getAndroidenAnzahl());

        //vulkanier.photonentorpedosLaden(ladungV2.getMenge());
        vulkanier.ladungsverzeichnisAufraeumen();

        klingonen.photonentorpedosLaden(2);
        klingonen.photonentorpedoSchiessen(romulaner);

        klingonen.zustandRaumschiff();
        klingonen.ladungsverzeichnisAusgeben();

        vulkanier.zustandRaumschiff();
        vulkanier.ladungsverzeichnisAusgeben();

        romulaner.zustandRaumschiff();
        romulaner.ladungsverzeichnisAusgeben();

        ArrayList<String> gesamteEintraege = Raumschiff.eintraegeAnLogbuchZurueckgeben();

        for(String eintrag : gesamteEintraege){
            System.out.println(eintrag + "\n");
        }

    }
}
