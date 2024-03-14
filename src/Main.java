import java.util.ArrayList;

public class Main {
    //Raumschiffe
    static Raumschiff klingonen = new Raumschiff(1, 100, 100, 100, 100, 2, "IKS Hegh'ta");
    static Raumschiff romulaner = new Raumschiff(2, 100, 100, 100, 100, 2, "IRW Khazara");
    static Raumschiff vulkanier = new Raumschiff(0, 80, 80, 50, 100, 5, "Ni'var");

    //Ladungen


    public static void main(String[] args){



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
