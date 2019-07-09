package cn.sxt.game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class MyGameFrame extends JFrame {
	
//	@Override
//	public void paint(Graphics g) {
//		Color c = g.getColor();
//		Font f = g.getFont();
//		g.setColor(Color.BLUE);
//		g.drawLine(100, 100, 300, 300);
//		g.drawRect(100, 100, 300, 300);
//		g.drawOval(100, 100, 300, 300);
//		g.fillRect(100, 100, 300, 300);
//		g.drawString("", 200, 200);
//		g.setColor(c);
//	}
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
	}
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}


