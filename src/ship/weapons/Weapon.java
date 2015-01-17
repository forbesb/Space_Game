package ship.weapons;

import java.awt.Graphics;
import java.util.ArrayList;

import ship.weapons.ammo.Bullet;

public abstract class Weapon {
	protected int size;
	protected ArrayList<Bullet> bullets;
	
	public abstract void draw(Graphics g, double x, double y, double angle);
	public abstract void fire(double x, double y, double angle);
	public abstract void update(double x, double y);
	public abstract ArrayList<Bullet> getBullets();
}
