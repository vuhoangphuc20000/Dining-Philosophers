/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.awt.TextArea;
import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public class Philosopher extends Thread {

    private int id;
    private Chopstick left;
    private Chopstick right;
    private Panel panel;
    private static Random rd = new Random();
    private TextArea jt;

    public Philosopher(Panel panel,TextArea jt, int id, Chopstick trai, Chopstick phai) {
        this.panel = panel;
        this.jt = jt;
        this.id = id;
        this.left = trai;
        this.right = phai;
    }

    public void Wait() throws InterruptedException {
        if(id % 2 == 0) {
                panel.drawState(id, 1);
                //System.out.println("Triết gia "+id+" đói");
                left.takeChop();
                if(id != 2)panel.drawState(id, 3); else panel.drawState(id, 2);
                //System.out.println("Triết gia "+id+" lấy dĩa trái");
                sleep(1000);
                right.takeChop();
                panel.drawState(id, 4);
                //System.out.println("Triết gia "+id+" lấy đc 2 dĩa");
            }
        else {
            panel.drawState(id, 1);
            //System.out.println("Triết gia "+id+" đói");
            right.takeChop();
            if(id != 3)panel.drawState(id, 2); else panel.drawState(id, 3);
            //System.out.println("Triết gia "+id+" lấy dĩa phải");
            sleep(1000);
            left.takeChop();     
            panel.drawState(id, 4);
            //System.out.println("Triết gia "+id+" lấy đc 2 dĩa");
            
        }
    }

    public void Signal() {
        left.returnChop();
        right.returnChop();
        //System.out.println("Triết gia "+id+" ăn xong");

    }

    public void run() {
        try {
            while (true) {
                //nghĩ
                panel.drawState(id, 0);
                //System.out.println("Triết gia "+id+" đang nghĩ");
                sleep(500 + rd.nextInt(500));
                //đói 
                Wait();//lấy dĩa
                //ăn
                jt.append("Triết gia " + id + " đang ăn"+'\n');
                sleep(500 + rd.nextInt(500));
                Signal();
            }
        } catch (Exception e) {
        }
    }
}
