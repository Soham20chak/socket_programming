import java.io.*;
import java.net.*;
 
public class EServerM {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            int count = 0;
            while (true) {
                Socket socket = serverSocket.accept();
                EServerMWorker worker = new EServerMWorker(socket, count++);
                worker.start();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}