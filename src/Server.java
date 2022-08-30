import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8082);
        System.out.println("Server start");
        Socket clientSocket = serverSocket.accept(); //ожидание клиента
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("New connection accepted");
        final String name = in.readLine();
        System.out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
        out.println("Receiving the message successfully");
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
