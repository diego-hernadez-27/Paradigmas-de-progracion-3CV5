import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 3080);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = "requesting_home";
        out.println(message);
        FileWriter fileWriter = new FileWriter("home.html");
        String inputLine;
        
        while ((inputLine = in.readLine()) != null) {
            fileWriter.write(inputLine);
        }
        fileWriter.close();

        clientSocket.close();
    }
}
