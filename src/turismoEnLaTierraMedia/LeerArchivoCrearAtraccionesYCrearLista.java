package turismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class LeerArchivoCrearAtraccionesYCrearLista {

    public static LinkedList<Atraccion> getAtracciones(String archivo) {
        LinkedList<Atraccion> atracciones = new LinkedList<Atraccion>();
        Scanner sc = null;

        try {
            sc = new Scanner(new File(archivo));

            while (sc.hasNext()) {
                try {
                    String linea = sc.nextLine();
                    atracciones.add(crearAtraccion(linea));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (sc != null) {
                    sc.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return atracciones;
    }

    public static Atraccion crearAtraccion(String linea) throws Exception {
        String datos[] = linea.split(",");
        Atraccion atraccion = null;
        String nombre = null;
        double costo = 0;
        double duracion = 0;
        TipoDeAtraccion tipo = null;
        int cupo = 0;

        if (datos.length < 5) {
            throw new ArrayIndexOutOfBoundsException("faltan par�metros");
        } else if (datos.length > 5) {
            throw new ArrayIndexOutOfBoundsException("sobran par�metros");

        }
        try {
            nombre = datos[0];
            costo = Double.parseDouble(datos[1]);
            duracion = Double.parseDouble(datos[2]);
            tipo = TipoDeAtraccion.valueOf(datos[4].toUpperCase());
            cupo = Integer.parseInt(datos[3]);

            atraccion = new Atraccion(nombre, costo, duracion, tipo, cupo);

        } catch (Exception e) {
            throw new Exception("Par�metro inv�lido");

        }
        return atraccion;
    }

}
