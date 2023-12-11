import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3080);

        System.out.println("El servidor está listo para recibir\n" +
                           "Por favor corra el programa de Cliente.java en otra terminal");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Conexión recibida desde: " + clientSocket.getInetAddress());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equals("requesting_home")) {
                    String response = "<html>" +
                                      "<body>" +
                                      "<h1>Hola, ¡bienvenido a mi página de inicio!</h1>" +
                                      "</body>" +
                                      "</html>";
                    out.println(response);

                    clientSocket.close();
                }
            }
        }
    }
}
