
import java.io.DataOutputStream;
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
public class Sender implements Runnable {

    private Data data;

    public boolean action = true;
    public int i = 0;

    public DataOutputStream dos;

    Sender(DataOutputStream data) {
        this.dos = data;
    }

    public void setData(int p) {
        i = p;
    }

    // standard constructors
    @Override
    public void run() {
        try {
            dos.writeInt(i);
            //data.send(i);
            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } catch (IOException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
