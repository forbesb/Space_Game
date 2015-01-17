package ship;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;

import ship.weapons.Weapon;
import ship.weapons.ammo.Bullet;

public class RingShip extends Enemy{
	private double tyo=0, txo=0, tyn=0, txn=0;
	
	public RingShip(double x, double y){
		super(x, y);
		speed=2;
		health=1;
	}
	@Override
	public void target(Ship user){
		tyo = tyn;
		txo = txn;
		tyn = user.getY();
		txn = user.getX();
		//System.out.println("Old:"+txo+","+tyo);
		//System.out.println("New:"+txn+","+tyn);
		
		
		pursuit();
	}
	private void pursuit(){
		Vector<Double> targetVector = getVector();
		//T= Dc
		//idk how c works, turning parameter apparently? I took rad/frame divided by accel/frame
		double T = getDistance()*0.5;
		//double T = 10;
		double xs = targetVector.get(1);
		double ys = targetVector.get(2);
		double fx = txn+xs*T;
		System.out.println(xs);
		double fy = tyn+ys*T;
		System.out.println(ys);
		tx = fx;
		ty = fy;
		System.out.println("Target:" +tx+","+ty);
		
		
		
	}
	
	private Vector<Double> getVector(){
		Vector<Double> tv = new Vector<Double>();
		double xspeed = txn-txo;
		double yspeed = tyn-tyo;
		double tSpeed = Math.sqrt(Math.pow(xspeed, 2)+ Math.pow(yspeed, 2));
		tv.add(tSpeed);
		tv.add(xspeed);
		tv.add(yspeed);
		double tAngle = Math.atan(yspeed/xspeed);
		boolean ypos = yspeed>0;
		boolean xpos = xspeed>0;
		if ((ypos && !xpos) || (!ypos&& xpos)){
			tAngle+=180;
		}
		tv.add(tAngle);
		return tv;
	}
	
	private double getDistance(){
		
		double Dx = txn-x;
		double Dy = tyn-y;
		double Dt = Math.sqrt(Math.pow(Dx, 2)+Math.pow(Dy, 2));
		
		return Dt;
	}
	
	@Override
	public void avoid(Ship user){
		
	}
	@Override
	public void drawShip(Graphics g) {
		if(health<=0){
			g.setColor(Color.red);
			g.drawRect((int)x-size, (int)y-size, health*-1,health*-1);
			health--;
			return;
		}
		g.setColor(Color.yellow);
		g.drawOval((int)x-size, (int)y-size, size*2, size*2);
		g.setColor(Color.green);
		g.drawLine((int)(x-size*1.5), (int)y-6, (int)(x+size*1.5*health/10), (int)y-6);
	}
	@Override
	public void damage(Ship user) {
		ArrayList<Bullet> bullets=user.getWeapons().get(0).getBullets();
		if(user.getRect().intersects(this.getRect())){
			System.out.println(user.getHealth());
			user.setHealth(user.getHealth()-20);
			health=-10;
		}
		for(int i=0;i<bullets.size();i++){
			if(bullets.get(i).getRect().intersects(this.getRect())){
				health--;
				bullets.remove(i);
				i--;
			}
			else if(bullets.get(i).getRect().x>1000||bullets.get(i).getRect().y>800||bullets.get(i).getRect().x<0||bullets.get(i).getRect().y<0){
				bullets.remove(i);
				i--;
			}
		}
	}
}
