package server;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements Runnable{
    private Socket socket;

    public RequestHandler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            while(true) {
                InputStream is = socket.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                String message = in.readLine();
                System.out.println("Recieve: " + message);
                lab10Server.displayMessage(message + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
