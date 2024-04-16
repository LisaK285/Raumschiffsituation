import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class DateiHandler {

    private final static String datei = "zahlen.dat";

    public DateiHandler(){}

    public static void liesAusDatei() {
        DataInputStream inputStream = null;

        try {
            inputStream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream(datei)
                    )
            );

            System.out.println(inputStream.readInt());
            System.out.println(inputStream.readDouble());

        } catch(FileNotFoundException ex) {
            System.out.println("Datei konnte nicht gefunden werden!");
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (inputStream != null) inputStream.close();
            } catch(IOException e) {}
        }

    }
    public static void schreibeDatenInDatei() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(datei)));

            dos.writeInt(-5);
            dos.writeDouble(Math.PI);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (IOException ioe){}
        }
    }
}
