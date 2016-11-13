import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MineSweeper extends JFrame implements Runnable {

	GameMap mappy;
	int X;
	int Y;
	int w = 507;
	int h = 530;
	Random rand = new Random();
	Genetic gene;

	public void run() {

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

	public MineSweeper() {
		super();
		init();

		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point platz = e.getPoint();
				Y = (int) (platz.getX() / (507 / 10));
				X = (int) (platz.getY() / (530 / 10));
				mappy.activate(X, Y);
			}
		});
	}

	@SuppressWarnings("static-access")
	public void init() {
		mappy = new GameMap(10, 10);
		gene = new Genetic();

		Dimension size = new Dimension(w, h);

		this.setSize(size);
		this.setContentPane(mappy);
		this.setResizable(false);
		this.setTitle("Minesweeper");
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

}
