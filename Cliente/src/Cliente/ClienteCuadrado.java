/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Diego Retana
 */
public class ClienteCuadrado {

    public static void main(String[] args) {
        try {
            //estableciendo conexion con el servidor
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Conexion exitosa con el servidor.");

            //flujos entrada/salida
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //nombre y numero del cliente
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa tu nombre: ");
            String nombre = sc.nextLine();
            writer.println(nombre);
            
            System.out.print("Ingresa un número entero: ");
            String num = sc.nextLine();
            int numero = Integer.parseInt(num); 
            writer.println(numero); 

            //recibiendo respuesta del servidor y mostrandola
            String res = reader.readLine();
            System.out.println("Respuesta del servidor: " + res);

            //cerrando los recursos
            writer.close();
            reader.close();
            sc.close();
            socket.close();
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa un número válido.");
        } catch (IOException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
