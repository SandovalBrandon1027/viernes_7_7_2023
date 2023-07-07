
import javax.swing.*;
import java.io.*;

public class Formulario {

    private JPanel A;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton cargarButton;
    private JButton guardarButton;

    public static void main(String[] args) throws FileNotFoundException {
        String filePath="formulario.dat";
        Formulario miObjeto=new Formulario();
        JFrame frame = new JFrame("Formulario.dat");
        frame.setContentPane(new Formulario().A);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try(
                FileOutputStream fileOut=new FileOutputStream(filePath);
                ObjectOutputStream obOut=new ObjectOutputStream(fileOut);
        ){
            obOut.writeObject(miObjeto);
            System.out.println("archivo escrito correctamente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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


