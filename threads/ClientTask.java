package threads;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTask {

    public static void main(String[] args) throws IOException {
        
        Socket socket = new Socket("localhost", 12345);

        System.out.println("Connection established!");

        PrintStream out = new PrintStream(socket.getOutputStream());

        out.println("Command 1");

        Scanner scan = new Scanner(System.in);
        scan.nextLine();


        out.close();
        scan.close();
        socket.close();
    }
}
