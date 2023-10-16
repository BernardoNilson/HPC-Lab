package threads;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTask {

    public static void main(String[] args) throws Exception {
        
        Socket socket = new Socket("localhost", 12345);

        System.out.println("Connection established!");

        Thread sendCommand = new Thread(new Runnable(){
            @Override
            public void run (){
                try {
                    System.out.println("Sending data to the server");
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    Scanner scan = new Scanner(System.in);

                    while(scan.hasNextLine()){
                        String line = scan.nextLine();
                    
                        if(line.trim().equals("")) break;
                    
                        out.println(line);
                    }
                    out.close();
                    scan.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        Thread receiveResponse = new Thread(new Runnable(){
            @Override
            public void run (){
                try {
                    System.out.println("Receiving data from the server");
                    Scanner response = new Scanner(socket.getInputStream());
                    while (response.hasNextLine()){
                        String line = response.nextLine();
                        System.out.println("Confirmação do servidor: " + line);
                    }
                    response.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        sendCommand.start();
        receiveResponse.start();
        
        sendCommand.join();

        socket.close();
    }
}
