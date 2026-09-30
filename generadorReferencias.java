import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class generadorReferencias {
    
    public static void generarArchivo(int filas, int columnas, int tam_vector, int tam_pag, int num_pasadas, String nombre_archivo){
        int num_ref = (num_pasadas*filas*columnas*3) + (filas*columnas*3);
        int totalBytes = (filas*columnas) + tam_vector;
        int num_pag = (int) Math.ceil((double) totalBytes/tam_pag); 

        
        for (int pasada = 0; pasada < num_pasadas; pasada++) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++)
                    m[i][j] = (byte) ((m[i][j] + v[j % v.length]) & 0xFF);
            }
        }
            for (int j = 0; j < columnas; j++) {
                for (int i = 0; i < filas; i++) {
                    m[i][j] = (byte) ((m[i][j] ^ v[i % v.length]) & 0xFF);
                }
            }
        
        
        
        }
    public static void Archivo(int filas, int columnas, int tam_vector, int tam_pag, int num_pasadas, String nombre_archivo){
		try {
            File Obj = new File("myfile.txt");

          	// Creating File
            if (Obj.createNewFile()) {
                System.out.println("File created: " + Obj.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }
      	// Exception Thrown
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        
        // Writing Text File       
        try {

            FileWriter Writer = new FileWriter("myfile.txt");

            // Writing File
            Writer.write("Files in Java are seriously good!!\n");
            Writer.write("TP=" + tam_pag + "\n");
            Writer.write("NF=" + filas + "\n");
            Writer.write("NC=" + columnas + "\n");
            Writer.write("Tamaño vector=" + tam_vector + "\n");
            Writer.write("numPasadas=" + num_pasadas + "\n");
            Writer.write("NR=" + "\n");
            Writer.write("NP="  + "\n");
            Writer.close();
            
            System.out.println("Successfully written.");
        }

        // Exception Thrown
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

    }
    
    
    }
