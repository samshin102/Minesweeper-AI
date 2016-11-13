import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.JFrame;

public class MineSweeper extends JFrame implements Runnable{

	GameMap mappy;
	int X;
	int Y;
	int w = 507;
	int h = 530;
	
	public void run(){
		
		try {
			Thread.sleep(100);
			mappy.paint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public MineSweeper(){
		super();
		init();
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				Point platz = e.getPoint();
				Y = (int) (platz.getX()/(507/10));
				X = (int) (platz.getY()/(530/10));
				mappy.activate(X, Y);
			}
		});
	}
	
	
	public void init(){
		mappy = new GameMap(10, 10);
		
		Dimension size = new Dimension(w, h);
		
		this.setSize(size);
		this.setContentPane(mappy);
		this.setResizable(false);
		this.setTitle("Minesweeper");
		this.setVisible(true);
	}
}

