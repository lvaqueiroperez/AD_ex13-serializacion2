package ex13_serializacion2;

import java.io.*;

public class Ex13_serializacion2 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        String[] cod = {"p1", "p2", "p3"};
        String[] desc = {"parafusos", "cravos ", "tachas"};
        Double[] prezo = {3.0, 4.0, 5.0};

        FileOutputStream fichR = new FileOutputStream("C:\\Users\\luis-\\Desktop\\2ºDAM\\AD\\ex13\\serial2.txt");
        ObjectOutputStream fichrOOS = new ObjectOutputStream(fichR);

        //Creamos en bucle el objeto y lo guardamos ya directamente en el fichero
        for (int i = 0; i < prezo.length; i++) {

            Product producto = new Product(cod[i], desc[i], prezo[i]);
            fichrOOS.writeObject(producto);

        }
        //Cuando salgamos del bucle se supone que ya no hay más que escribir
        //Será aquí donde pongamos el null para indicar que se ha llegado al final
        //del fichero
        fichrOOS.writeObject(null);
        fichrOOS.close();
        fichR.close();

        FileInputStream fichL = new FileInputStream("C:\\Users\\luis-\\Desktop\\2ºDAM\\AD\\ex13\\serial2.txt");
        ObjectInputStream fichlOIS = new ObjectInputStream(fichL);

        Object contenido = 0;

        while (contenido != null) {

            if (contenido == null) {
                //no imprime fin???
                System.out.println("fin");

            } else {

                contenido = fichlOIS.readObject();

                System.out.println(contenido);
            }
        }

        fichlOIS.close();
        fichL.close();

    }

}
