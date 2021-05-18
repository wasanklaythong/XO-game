
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tanakrit
 */
public class XO2 implements Runnable {

    private ServerSocket serverSocket;
    public int port = 3000;
    private String ip = "localhost";
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    private Thread thread;

    @Override
    public void run() {

    }

    public XO2(String ip) {
        if (ip != null) {
            this.ip = ip;
        }
        if (!connect()) {
            initializeServer();
        }
        thread = new Thread(this);
        thread.start();
    }

    private boolean connect() {
        try {
            socket = new Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("Unable to connect to the address: " + ip + ":" + port + " | Starting a server");
            return false;
        }
        System.out.println("Successfully connected to the server.");
        return true;
    }

    private void initializeServer() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
