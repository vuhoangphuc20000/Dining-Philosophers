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
public class TrietGia extends Thread {
    private int id;
    private Dia trai;
    private Dia phai;
    
    public TrietGia(int id,Dia trai,Dia phai){
        this.id = id;
        this.trai = trai;
        this.phai = phai;
    }
    
    public void Wait() throws InterruptedException{
        if(id % 2 == 0){
            System.out.println("Triết gia "+id+" đói");
            trai.layDia();
            System.out.println("Triết gia "+id+" lấy dĩa trái");
            sleep(500);
            phai.layDia();
            System.out.println("Triết gia "+id+" lấy đc 2 dĩa");
        }
        else
        {
            System.out.println("Triết gia "+id+" đói");
            phai.layDia();
            System.out.println("Triết gia "+id+" lấy dĩa phải");
            sleep(500);
            trai.layDia();     
            System.out.println("Triết gia "+id+" lấy đc 2 dĩa");
            
        }
    }
    
    public void Signal(){
        trai.traDia();
        phai.traDia();
        System.out.println("Triết gia "+id+" ăn xong");

    }
    
    public void run(){
        try{
            while(true){
                //nghĩ
                System.out.println("Triết gia "+id+" đang nghĩ");
                sleep(500);
                //đói 
                Wait();//lấy dĩa
                //ăn
                System.out.println("Triết gia "+id+" đang ăn");
                sleep(500);
                Signal();
            }
        }catch(Exception e){}
    }
}
