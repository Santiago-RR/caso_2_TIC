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
    }
