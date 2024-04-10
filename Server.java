import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("Waiting for connection.");
        
        while (true) {
            Socket s = ss.accept();
            System.out.println("Connected to the server");
        
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String message = br.readLine();
            System.out.println("Client said: " + message);
        
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeBytes("TERMINATE CONNECTION!\n");
        }
    }
}
