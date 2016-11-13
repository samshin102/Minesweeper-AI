import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MineSweeper extends JFrame implements Runnable{

	GameMap mappy;
	int X;
	int Y;
	int w = 520;
	int h = 542;
	int s = 16;
	int b = 25;
	
	public void run(){
		while(true){
		try {
			Thread.sleep(100);
			mappy.paint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	public MineSweeper(){
		super();
		init();
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				Point platz = e.getPoint();
				Y = (int)Math.floor((platz.getX()/(512/s)));
				X = (int)Math.ceil((platz.getY()/(512/s)));
				X-=2;
				if(SwingUtilities.isLeftMouseButton(e)){
					mappy.paint();
					if(!mappy.activate(X, Y))
						System.exit(0);
				}
				else if(SwingUtilities.isRightMouseButton(e)){
					mappy.flag(X,Y);
					mappy.paint();
				}
			}
		});
	}
	
	
	@SuppressWarnings("static-access")
	public void init(){
		mappy = new GameMap(s, b);
		
		Dimension size = new Dimension(w, h);
		
		this.setSize(size);
		this.setContentPane(mappy);
		this.setResizable(false);
		this.setTitle("Minesweeper");
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

