package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image img;
	double x,y;
	int speed;
	int wight,height;
	
	public void drawSelf(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
	public GameObject(Image img, double x, double y, int speed, int wight, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.wight = wight;
		this.height = height;
	}
	public GameObject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	public GameObject() {
	}
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y,wight,height);
	}
	
	
}
