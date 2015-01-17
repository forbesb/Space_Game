import graphics.Grid;
import graphics.Pixel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import ship.Ship;


public class Game extends JPanel implements KeyListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pixel[] pixels;
	private Pixel[] pixels_2;
	private Grid grid;
	private Ship ship;
	private boolean left, right, up, space;
	
//	Action up, right, left;
	
	Timer timer;
	public Game(){
		super();
		setSize(1000,800);
		timer=new Timer(10,this);
		
		ship=new Ship();
		setBackground(new Color(0, 0, 0));
		setBackground(50);
		
		addKeyListener(this);
		
//		up=new AbstractAction(){
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				ship.accel();
//			}
//		};
//		
//		right=new AbstractAction(){
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void actionPerformed(ActionEvent e){
//				ship.turn(Math.toRadians(-5));
//			}
//		};
//		
//		left=new AbstractAction(){
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;
//
//			@Override
//			public void actionPerformed(ActionEvent e){
//				ship.turn(Math.toRadians(5));
//			}
//		};
//		getInputMap().put(KeyStroke.getKeyStroke("UP"), "up");
//		getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");
//		getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
//		getActionMap().put("up", up);
//		getActionMap().put("right", right);
//		getActionMap().put("left", left);
		
		timer.start();
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		drawBackground(g);
		ship.draw(g);
	}
	
	//Draws Backgrounds based on Pixels
	public void drawBackground(Graphics g){
		for(int i=0;i<pixels.length;i++){
			pixels[i].draw(g, 0, 0);
			pixels_2[i].draw(g, 0, 0);
		}
		grid.draw(g,0,0);
	}
	
	//Generates Pixels;
	public void setBackground(int size) {
		pixels = new Pixel[size];
		pixels_2 = new Pixel[size];
		grid=new Grid(new Color(0,255,0),getWidth()/100,getHeight()/100, 100);
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 
					new Pixel(
					new Color(200, 200, 200, 100), 
					1000, 
					800);
			pixels_2[i] = 
					new Pixel(
					new Color(200, 200, 255, 100), 
					1000, 
					800);
		}
	}
	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		keys();
		repaint();
	}
	public void keys(){
		if(up){
			ship.accel();
		}
		if(right){
			ship.turn(Math.toRadians(-5));
		}
		if(left){
			ship.turn(Math.toRadians(5));
		}
		if(space){
			ship.shoot();
		}
	}
	//KeyListener
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W){
			up=true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_D){
			right=true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_A){
			left=true;
		}
		else if(e.getKeyCode()==32){
			space=true;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W){
			System.out.println("left");
			up=false;
		}
		else if(e.getKeyCode()==KeyEvent.VK_D){
			System.out.println("left");
			right=false;
		}
		else if(e.getKeyCode()==KeyEvent.VK_A){
			System.out.println("left");
			left=false;
		}
		else if(e.getKeyCode()==32){
			space=false;
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
