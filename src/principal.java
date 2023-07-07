import javax.sound.midi.Soundbank;
import java.io.*;
import java.sql.SQLOutput;

public class principal {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath="datos.dat";
        Miclase miObjeto=new Miclase("Juan",42);

        try(
                FileOutputStream fileOut=new FileOutputStream(filePath);
                ObjectOutputStream obOut=new ObjectOutputStream(fileOut);
        ){
            obOut.writeObject(miObjeto);
            System.out.println("archivo escrito correctamente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //////////////////////

        try(
                FileInputStream fileIn=new FileInputStream(filePath);
                ObjectInputStream objIn=new ObjectInputStream(fileIn);
        ){
            Miclase readObject=(Miclase) objIn.readObject();
            System.out.println("El objeto en disco es:" +readObject);
            System.out.println(readObject.getEdad());
            System.out.println(readObject.getNombre());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}