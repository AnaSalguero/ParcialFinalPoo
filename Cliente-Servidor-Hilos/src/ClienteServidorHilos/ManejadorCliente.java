/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClienteServidorHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author anasa
 */
public class ManejadorCliente implements Runnable {
    private Socket cliente;

    public ManejadorCliente(Socket cliente) {
        this.cliente = cliente;
    }
    @Override
    public void run(){
        //Generamos la hora del momento de la conenexion
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //le damos formato al texto
        String fechaHoraTexto = fechaHoraActual.format(formato);
        try {
            InputStream input = cliente.getInputStream();
            OutputStream output = cliente.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output,true);
            String res = reader.readLine();
            System.out.println("Fecha y hora del servidor: " + fechaHoraTexto);
            writer.println("Bienvenido/a, "+res);
            String numero = reader.readLine();
            int numeroCuadrado = (int)Math.pow(Integer.parseInt(numero),2);
            System.out.println("el numero al cuadrado es: " + numeroCuadrado);
            cliente.close();
        }catch(IOException e){
            
        }
    }
}
