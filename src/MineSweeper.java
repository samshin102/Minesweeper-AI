import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
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
			return -2;
		}
		if (!mappy.getMappy()[r][c].getShow()) {
			return -1;
		}
		return mappy.getMappy()[r][c].getVal();
	}

	public void run() {
		gene = new Genetic(8, 4, 1, 1);
		int generation = 0;
		while (true) {
			List<Network> nets = gene.pop;
			float totalFitness = 0;
			for (int i = 0; i < nets.size(); i++) {
				Network net = nets.get(i);
				float fitness = 0;
				boolean playing = true;
				while (playing) {
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
								float d = net.getOutput(input)[0];
								danger[r][c] = d;
							}
						}
					}
					int lowR = 0;
					float lowVal = Integer.MAX_VALUE;
					int lowC = 0;
					for (int r = 0; r < danger.length; r++) {
						for (int c = 0; c < danger[r].length; c++) {
							if (danger[r][c] < lowVal) {
								lowR = r;
								lowC = c;
								lowVal = danger[r][c];
							}
						}
					}
					if (mappy.activate(lowR, lowC)) {
						fitness += 1;
					} else {
						playing = false;
						net.fitness = fitness;
						totalFitness += fitness;
					}
					if (mappy.netWinCheck()) {
						System.out.println("Winner!!! Neural network of generation: " + generation +" has cleared the minefield!");
						System.exit(1);
					}
				}
				mappy.resetVisible();
			}
			System.out.printf("%.2f%n", totalFitness / nets.size());
			gene.train();
			mappy.genMap();
			generation++;
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
					if (!mappy.activate(X, Y)) {
						mappy.resetVisible();
					}
				} else if (SwingUtilities.isRightMouseButton(e)) {
					mappy.flag(X, Y);
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
