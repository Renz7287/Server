import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {    
    public static void main(String[] args) throws Exception {
        System.out.println("Client started.");
        Socket s = new Socket("localhost", 8080);

        String greeting = JOptionPane.showInputDialog(null, "Enter your greeting:");

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println(greeting + "\r\n");

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String response = br.readLine();
        System.out.println("Server response: " + response);

        br.close();
        pw.close();
        s.close();
    }
}
