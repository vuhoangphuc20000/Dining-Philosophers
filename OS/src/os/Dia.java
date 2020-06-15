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
public class Dia {
    private boolean khoa = false;
    private int id;
    private Panel panel;
    public int getId() {
        return id;
    }

    public Dia(Panel panel,int id)
    {
        this.panel = panel;
        this.id = id;
    }
    public synchronized void traDia(){
        khoa = false;
        panel.drawChop(id);
        notify();
    }
    public synchronized void layDia() throws InterruptedException{
        while(khoa) wait();
        khoa = true;
        panel.deleteChop(id);
    }
}
