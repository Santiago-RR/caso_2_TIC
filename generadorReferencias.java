import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Date;

public class GeneradorReferencias {
    
    public static void generarArchivo(int filas, int columnas, int tam_vector, int tam_pag, int num_pasadas, String nombre_archivo){
        int num_ref = (num_pasadas*filas*columnas*3) + (filas*columnas*3);
        int totalBytes = (filas*columnas) + tam_vector;
        int num_pag = (int) Math.ceil((double) totalBytes/tam_pag); 

        try {
			PrintWriter fileOutput = new PrintWriter(nombre_archivo);

            fileOutput.println("TP=" + tam_pag);
            fileOutput.println("NF1=" + filas);
            fileOutput.println("NC1=" + columnas);
			fileOutput.println("NV=" + tam_vector);
            fileOutput.println("numPasadas=" + num_pasadas);
            fileOutput.println("NR=" + num_ref);
            fileOutput.println("NP=" + num_pag);

            for (int pasada = 0; pasada < num_pasadas; pasada++) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    //m[i][j] = (byte) ((m[i][j] + v[j % v.length]) & 0xFF);
                    String a = escribirReferencia("mat1", i, j, (i * columnas) + j, tam_pag);
                    fileOutput.println(a);

                    int idxV = j % tam_vector;
                    String b = escribirReferencia("v", 0, idxV, (filas * columnas) + idxV, tam_pag);
                    fileOutput.println(b);
                    
                    String c = escribirReferencia("mat1", i, j, (i * columnas) + j, tam_pag);
                    fileOutput.println(c);
                }
            }
            }
            for (int j = 0; j < columnas; j++) {
               for (int i = 0; i < filas; i++) {
                    //m[i][j] = (byte) ((m[i][j] ^ v[i % v.length]) & 0xFF);
                    String d = escribirReferencia("mat1", i, j, (i * columnas) + j, tam_pag);
                    fileOutput.println(d);

                    int idxV = i % tam_vector;
                    String e = escribirReferencia( "v", 0, idxV, (filas * columnas) + idxV, tam_pag);
                    fileOutput.println(e);

                    String f = escribirReferencia( "mat1", i, j, (i * columnas) + j, tam_pag);
                    fileOutput.println(f);
                }
            }


			fileOutput.flush();
			fileOutput.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

        }
        
    private static String escribirReferencia(String prefijo, int i, int j, int dv, int tam_pagina) {
            int pagina = dv / tam_pagina;
            int desplazamiento = dv % tam_pagina;
            String sol = "[" + prefijo + "-" + i + "-" + j + "]," + pagina + "," + desplazamiento;
            return sol;
        }
    public static void main(String[] Args){
        generarArchivo(300, 20, 142, 256, 5, "hola.txt");
    }

}
