package cn.sxt.game;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;



public class MyGameFrame extends JFrame {

	Image plane = GameUtil.getImage("images/plane.png");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	int planex = 250,planey=250;
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		g.drawImage(plane, planex, planey, null);
		planex++;
		planey++;
	}
	//帮助我们反复的重画窗口
	class PaintThread extends Thread{
		@Override
		public void run() {
			while(true) {
				System.out.println("重画一次");
				repaint();//重画
				
				try {
					Thread.sleep(40);//1秒25次
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 初始化窗口
	 */
	public void launchFrame() {
		this.setTitle("尚学堂学员_第一个作品");
		this.setVisible(true); 
		this.setSize(500,500);
		this.setLocation(300,300);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			} 
		});
		
		new PaintThread().start();//启动重画窗口的线程
	}
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}


