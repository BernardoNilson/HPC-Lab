package threads;

import java.net.Socket;
import java.util.Scanner;

public class DistributeTasks implements Runnable {

    private Socket socket;

    public DistributeTasks (Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            System.out.println("I distribute task for socket " + socket);

            Scanner in = new Scanner (socket.getInputStream());

            while (in.hasNextLine()){
                String command = in.nextLine();
                System.out.println(command);
            }
        
            Thread.sleep(20000);

            in.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    

}
