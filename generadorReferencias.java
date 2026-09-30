public class generadorReferencias {
    
    public static void generarArchivo(int filas, int columnas, int tam_vector, int tam_pag, int num_pasadas, String nombre_archivo){
        int num_ref = (num_pasadas*filas*columnas*3) + (filas*columnas*3);
        int totalBytes = (filas*columnas) + tam_vector;
        int num_pag = (int) Math.ceil((double) totalBytes/tam_pag); 

    }
}