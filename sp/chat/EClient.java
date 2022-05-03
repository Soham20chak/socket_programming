import java.io.*;
import java.net.*;
// import java.util.*;
 
public class EClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket(args[0], Integer.parseInt(args[1]));
            boolean quit = false;
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            OutputStream out = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            String message;
            while (!quit) {
                message = buff.readLine();
                dos.writeUTF("Client Say :: " + message);
                dos.flush();
                if (message.equalsIgnoreCase("Q")) {
                    quit = true;
                    Thread.sleep(500);
                }
            }
            client.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Communication with server completed.");
        }
    }
}