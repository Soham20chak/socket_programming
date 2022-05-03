import java.io.*;
import java.net.*;
 
public class EServerMWorker extends Thread {
    Socket client;
    int number;
 
    public EServerMWorker(Socket client, int number) {
        this.client = client;
        this.number = number;
    }
 
    public void run() {
        System.out.println("Starting thread " + this.number);
        try {
            InputStream in = client.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            boolean quit = false;
            String msg;
            while (!quit) {
                msg = dis.readUTF();
                System.out.println("Thread " + number + ": " + msg);
                if (msg.contains("BYE")) {
                    quit = true;
                    System.out.println("quitting!");
                }
            }
            try {
                client.close();
                System.out.println("closing client socket");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Ending thread " + this.number);
        }
    }
}