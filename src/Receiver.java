
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tanakrit
 */
public class Receiver implements Runnable {

    private Data load;

    public DataInputStream dis;
    int receivedMessage;

    Receiver(DataInputStream data) {
        dis = data;
    }

    public int getPosition() {
        return receivedMessage;
    }

    @Override
    public void run() {
        try {
            receivedMessage = dis.readInt();
            if (receivedMessage != 0) {
                System.out.println(receivedMessage);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println("fail");
            }
        } catch (IOException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*public static void main(String[] args) {
        Data data = new Data();
        Sender sender = new Sender(data);
        Thread Tsender = new Thread(sender);
        Receiver receiver = new Receiver(data);
        Thread Treceiver = new Thread(receiver);
        sender.setData(0);

        Tsender.start();
        Treceiver.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }

        Tsender = new Thread(sender);
        Treceiver = new Thread(receiver);
        sender.setData(2);
        Tsender.start();
        Treceiver.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
