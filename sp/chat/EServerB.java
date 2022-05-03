import java.io.*;
import java.net.*;
 
public class EServerB {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            while (true) {
                Socket client = serverSocket.accept();
                boolean quit = false;
                InputStream in = client.getInputStream();
                DataInputStream dis = new DataInputStream(in);
                String msg;
                while (!quit) {
                    msg = dis.readUTF();
                    System.out.println(msg);
                    if (msg.contains("Q")) {
                        quit = true;
                        System.out.println("quitting!");
                    }
                }
                try {
                    client.close();
                    System.out.println("Closing the client socket");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Ending thread");
        }
    }
}