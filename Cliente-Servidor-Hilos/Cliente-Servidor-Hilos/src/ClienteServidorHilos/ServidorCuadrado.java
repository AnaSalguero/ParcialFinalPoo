package ClienteServidorHilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Andrea
 */
public class ServidorCuadrado {

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Esperando conexiones...");
            
            while(true){
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());
               // Thread hiloCliente = new Thread(new ManejadorCliente(cliente));
               // hiloCliente.start();
            }
        }catch(IOException e){
        System.out.println(e);
        }
    }
}
    
