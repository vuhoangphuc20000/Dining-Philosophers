/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

/**
 *
 * @author Admin
 */
public class Chopstick {
    private boolean khoa = false;
    private int id;
    private Panel panel;
    public int getId() {
        return id;
    }

    public Chopstick(Panel panel,int id)
    {
        this.panel = panel;
        this.id = id;
    }
    public synchronized void returnChop(){
        khoa = false;
        panel.drawChop(id);
        notify();
    }
    public synchronized void takeChop() throws InterruptedException{
        while(khoa) wait();
        khoa = true;
        panel.deleteChop(id);
    }
}
