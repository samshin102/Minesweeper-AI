import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MineSweeper extends JFrame implements Runnable {

	GameMap mappy;
	int X;
	int Y;
	int w = 520;
	int h = 542;
	int s = 16;
	int b = 25;
	Random rand = new Random();
	Genetic gene;

	
	public void run(){
		while(true){
		try {
			Thread.sleep(100);
			mappy.paint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 250; i++){
			Network network = new Network(8, 3, 3, 1);
			gene.pop.add(network);
		boolean cj = false;
		while (!cj) {
			int x = rand.nextInt(16);
			int y = rand.nextInt(16);
			if((mappy.getMappy())[x][y].getShow() && mappy.getMappy()[x][y].getVal()  != 0){
				cj = true;
				float[] input = new float[8];
				if(x == 15 && y == 0){
					input[0] += 0;
					input[1] += (float)(mappy.getMappy()[x-1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[2] += (float)(mappy.getMappy()[x-1][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[3] += 0;
					input[4] += (float)(mappy.getMappy()[x][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[5] += 0;
					input[6] += 0;
					input[7] += 0;
				}else if(x == 0 && y == 15){
					input[0] += 0;
					input[1] += 0;
					input[2] += 0;
					input[3] += (float)(mappy.getMappy()[x][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[4] += 0;
					input[5] += (float)(mappy.getMappy()[x+1][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[6] += (float)(mappy.getMappy()[x+1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[7] += 0;
				}else if(x == 15 && y == 15){
					input[0] += (float)(mappy.getMappy()[x-1][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[1] += (float)(mappy.getMappy()[x-1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[2] += 0;
					input[3] += (float)(mappy.getMappy()[x][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[4] += 0;
					input[5] += 0;
					input[6] += 0;
					input[7] += 0;
				}else if(x == 0 && y == 0){
					input[0] += 0;
					input[1] += 0;
					input[2] += 0;
					input[3] += 0;
					input[4] += (float)(mappy.getMappy()[x][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[5] += 0;
					input[6] += (float)(mappy.getMappy()[x+1][y].getShow()?mappy.getMappy()[x][y].getVal():0); 
					input[7] += (float)(mappy.getMappy()[x+1][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
				}else if(x == 0){
					input[0] += 0;
					input[1] += 0;
					input[2] += 0;
					input[3] += (float)(mappy.getMappy()[x][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[4] += (float)(mappy.getMappy()[x][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[5] += (float)(mappy.getMappy()[x+1][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[6] += (float)(mappy.getMappy()[x+1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[7] += (float)(mappy.getMappy()[x+1][y+1].getShow()?mappy.getMappy()[x][y].getVal():0); /////////////////
				}else if(y == 0){
					input[0] += 0;
					input[1] += (float)(mappy.getMappy()[x-1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[2] += (float)(mappy.getMappy()[x-1][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[3] += 0;
					input[4] += (float)(mappy.getMappy()[x][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[5] += 0;
					input[6] += (float)(mappy.getMappy()[x+1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[7] += (float)(mappy.getMappy()[x+1][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
				}else if(y == 15){
					input[0] += (float)(mappy.getMappy()[x-1][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[1] += (float)(mappy.getMappy()[x][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[2] += 0; 
					input[3] += (float)(mappy.getMappy()[x][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[4] += 0;
					input[5] += (float)(mappy.getMappy()[x+1][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[6] += (float)(mappy.getMappy()[x-1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[7] += 0;
				}else if(x == 15){
					input[0] += (float)(mappy.getMappy()[x-1][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[1] += (float)(mappy.getMappy()[x-1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[2] += (float)(mappy.getMappy()[x-1][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[3] += (float)(mappy.getMappy()[x][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[4] += (float)(mappy.getMappy()[x][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[5] += 0;
					input[6] += 0;
					input[7] += 0;
				}else{
					input[0] += (float)(mappy.getMappy()[x-1][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[1] += (float)(mappy.getMappy()[x-1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[2] += (float)(mappy.getMappy()[x-1][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[3] += (float)(mappy.getMappy()[x][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[4] += (float)(mappy.getMappy()[x][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[5] += (float)(mappy.getMappy()[x+1][y-1].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[6] += (float)(mappy.getMappy()[x+1][y].getShow()?mappy.getMappy()[x][y].getVal():0);
					input[7] += (float)(mappy.getMappy()[x+1][y+1].getShow()?mappy.getMappy()[x][y].getVal():0);
				}
				if(network.getOutput(input)[0] > .5F){
					
				}
				}
			}
		}
		}
	}

	public MineSweeper() {
		super();
		init();

		this.addMouseListener(new MouseAdapter() {
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
