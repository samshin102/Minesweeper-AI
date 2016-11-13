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

	public int getMapVal(int r, int c) {
		if (r < 0 || c < 0 || r >= s || c >= s) {
			return 0;
		}
		return mappy.getMappy()[r][c].getVal();
	}

	public void run() {
		gene = new Genetic(8, 3, 3, 1);
		while (true) {
			try {
				Thread.sleep(100);
				mappy.paint();
				if(mappy.winCheck())
					System.out.println("you win!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			float[][] danger = new float[s][s];
			for (int r = 0; r < danger.length; r++) {
				for (int c = 0; c < danger[r].length; c++) {
					if (mappy.getMappy()[r][c].getShow()) {
						danger[r][c] = Integer.MAX_VALUE;
					} else {
						float[] input = new float[8];
						input[0] = getMapVal(r - 1, c - 1);
						input[1] = getMapVal(r - 1, c);
						input[2] = getMapVal(r - 1, c + 1);
						input[3] = getMapVal(r, c - 1);
						input[4] = getMapVal(r, c + 1);
						input[5] = getMapVal(r + 1, c - 1);
						input[6] = getMapVal(r + 1, c);
						input[7] = getMapVal(r + 1, c + 1);
						// danger[r][c] =
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
				Y = (int) Math.floor((platz.getX() / (512 / s)));
				X = (int) Math.ceil((platz.getY() / (512 / s)));
				X -= 2;
				if (SwingUtilities.isLeftMouseButton(e)) {
					mappy.paint();

					if(!mappy.activate(X, Y));
				}
				else if(SwingUtilities.isRightMouseButton(e)){
					mappy.flag(X,Y);
					mappy.paint();
				}
			}
		});
	}

	@SuppressWarnings("static-access")
	public void init() {
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