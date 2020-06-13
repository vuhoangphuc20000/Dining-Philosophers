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
    
    public int getId() {
        return id;
    }

    public Dia(int id)
    {
        this.id = id;
    }
    public synchronized void traDia(){
        khoa = false;
        notify();
    }
    public synchronized void layDia() throws InterruptedException{
        while(khoa) wait();
        khoa = true;
    }
}
