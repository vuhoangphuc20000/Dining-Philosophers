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
public class TrietGia extends Thread {

    private int id;
    private Dia trai;
    private Dia phai;
    private Panel panel;
    private static Random rd = new Random();
    private TextArea jt;

    public TrietGia(Panel panel,TextArea jt, int id, Dia trai, Dia phai) {
        this.panel = panel;
        this.jt = jt;
        this.id = id;
        this.trai = trai;
        this.phai = phai;
    }

    public void Wait() throws InterruptedException {
        if(id % 2 == 0) {
                panel.drawState(id, 1);
                //System.out.println("Triết gia "+id+" đói");
                trai.layDia();
                if(id != 2)panel.drawState(id, 3); else panel.drawState(id, 2);
                //System.out.println("Triết gia "+id+" lấy dĩa trái");
                sleep(1000);
                phai.layDia();
                panel.drawState(id, 4);
                //System.out.println("Triết gia "+id+" lấy đc 2 dĩa");
            }
        else {
            panel.drawState(id, 1);
            //System.out.println("Triết gia "+id+" đói");
            phai.layDia();
            if(id != 3)panel.drawState(id, 2); else panel.drawState(id, 3);
            //System.out.println("Triết gia "+id+" lấy dĩa phải");
            sleep(1000);
            trai.layDia();     
            panel.drawState(id, 4);
            //System.out.println("Triết gia "+id+" lấy đc 2 dĩa");
            
        }
    }

    public void Signal() {
        trai.traDia();
        phai.traDia();
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
