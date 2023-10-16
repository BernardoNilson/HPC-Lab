package threads;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class DistributeTasks implements Runnable{

    private Socket socket;

    public DistributeTasks (Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            System.out.println("I distribute task for socket " + socket);

            Scanner in = new Scanner (socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());

            while (in.hasNextLine()){


                String command = in.nextLine().toUpperCase();

                switch (command) {
                    case "C1":
                        out.println("Command C1 received");
                        break;
                    case "C2":
                        out.println("Command C2 received");
                        break;
                    case "FIM":
                        out.println("Leaving the app");
                        break;
                    default:
                        out.println("Command not found");
                        System.out.println("Comando não esperado.");
                        break;
                }

                System.out.println(command);
            }
        
            Thread.sleep(10000);

            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
