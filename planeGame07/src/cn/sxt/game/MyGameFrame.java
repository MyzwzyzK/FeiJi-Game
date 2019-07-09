package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import sun.awt.image.OffScreenImage;

/**
 * �ɻ���Ϸ��������
 * @author ���
 *
 */
public class MyGameFrame  extends Frame {
	
	Image   planeImg  = GameUtil.getImage("images/plane.png");
	Image   bg  = GameUtil.getImage("images/bg.jpg");
	
	Plane   plane = new Plane(planeImg,250,250);
//	Shell shell = new Shell();
	Shell[] shells = new Shell[100];
	
	@Override
	public void paint(Graphics g) {		//�Զ������á�  g�൱��һֻ����
		
		g.drawImage(bg, 0, 0, null);
		
		plane.drawSelf(g);  //���ɻ�
		
		for (int i = 0; i < shells.length; i++) {
			shells[i].draw(g);
		}
	}
	
	
	//�������Ƿ������ػ����ڣ�
	class  PaintThread  extends  Thread  {
		@Override
		public void run() {
			while(true){
				repaint();		//�ػ�
				
				try {
					Thread.sleep(40);   	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}
		}
		
	}
	
	//������̼������ڲ���
	class   KeyMonitor extends  KeyAdapter  {

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
	}
	
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
			Graphics gOff = offScreenImage.getGraphics();
			paint(gOff);
			g.drawImage(offScreenImage, 0, 0, null);
		}
	}
	
	/**
	 * ��ʼ������
	 */
	public  void  launchFrame(){
		this.setTitle("��ѧ��ѧԱ_����Գ��Ʒ");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		new PaintThread().start();	//�����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor());   //���������Ӽ��̵ļ���
		
		//��ʼ��50���ڵ�
		for (int i = 0; i < shells.length; i++) {
			shells[i] = new Shell();
		}
	}
	
	public static void main(String[] args) {
		MyGameFrame  f = new MyGameFrame();
		f.launchFrame();
	}
	
	
}



