/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class Panel extends javax.swing.JPanel {

    private Graphics2D g2d, g2;
    private BufferedImage buff_img;
    private int width = 800;
    private int height = 500;
    private ImageIcon img[] = new ImageIcon[5];
    private Image img1[] = new Image[5];
    private int dishX[] = {360, 250, 280, 450, 480};
    private int dishY[] = {100, 180, 300, 300, 180};
    private int iconX[] = {355, 180, 230, 490, 540};
    private int iconY[] = {30, 160, 350, 350, 160};
    JLabel lb0 = new JLabel();

    public Panel() {
        initComponents();
        createImage();
        buff_img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = (Graphics2D) buff_img.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.setSize(width, height);
        this.setLocation(0, 0);
        g2d.setColor(new Color(255, 255, 255));
        g2d.fillRect(0, 0, width, height);
        drawTable(g2d);
        for(int i=0;i<5;i++) drawChop(i);
        drawIndex();
        lb0.setBounds(iconX[0], iconY[0], 60, 60);
        this.add(lb0);
        
    }

    private void doDrawing(Graphics g) {
        g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(buff_img, null, 0, 0);
        g2.setColor(Color.DARK_GRAY);
        g2.drawRect(0, 0, 795, 499);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    public void createImage() {
        img[0] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Think.png")));
        img[1] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Hungry.png")));
        img[2] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Left.png")));
        img[3] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Right.png")));
        img[4] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/All.png")));
        for (int i = 0; i < 5; i++) {
            img1[i] = img[i].getImage();
        }
    }

    public void drawTable(Graphics g) {
        g2 = (Graphics2D) g;
        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(240, 90, 300, 300);
        g2.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            g2.fillOval(dishX[i], dishY[i], 50, 50);
        }
        repaint();
    }

    /*
        trangthai = 0: Nghĩ
        trangthai = 1: Đói
        trangthai = 2: Tay trái lấy dĩa
        trangthai = 3: Tay phải lấy dĩa
        trangthai = 4: Cả 2 tay lây dĩa(đang ăn)
     */
    public void drawState(int vitri, int trangthai) {
        /*AffineTransform at = new AffineTransform();
        int w = img1[trangthai].getWidth(this);
        int h = img1[trangthai].getHeight(this);
        at.translate(h, 0);
        at.rotate(Math.toRadians(90),0,0);
       */
        g2d.drawImage(img1[trangthai],iconX[vitri],iconY[vitri],null);
        repaint();
    }

    public void drawChop(int vitri) {
        BasicStroke bs = new BasicStroke(4f);
        g2d.setStroke(bs);
        g2d.setColor(Color.ORANGE);
        switch (vitri) {
            case (0):
                g2d.drawLine(300, 125, 330, 165);
                break;
            case (1):
                g2d.drawLine(250, 285, 300, 265);
                break;
            case (2):
                g2d.drawLine(390, 385, 390, 335);
                break;
            case (3):
                g2d.drawLine(530, 280, 475, 265);
                break;
            case (4):
                g2d.drawLine(480, 125, 455, 170);
                break;
        }
    }

    public void deleteChop(int vitri) {
        BasicStroke bs = new BasicStroke(4f);
        g2d.setStroke(bs);
        g2d.setColor(Color.LIGHT_GRAY);
        switch (vitri) {
            case (0):
                g2d.drawLine(300, 125, 330, 165);
                break;
            case (1):
                g2d.drawLine(250, 285, 300, 265);
                break;
            case (2):
                g2d.drawLine(390, 385, 390, 335);
                break;
            case (3):
                g2d.drawLine(530, 280, 475, 265);
                break;
            case (4):
                g2d.drawLine(480, 125, 455, 170);
                break;
        }
    }
     
    public void drawIndex(){
        BasicStroke bs = new BasicStroke(2f);
        g2d.setStroke(bs);
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        for(int i=0;i<5;i++){
            String s = String.valueOf(i);
            g2d.drawString(s, dishX[i]+15,dishY[i]+30);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
