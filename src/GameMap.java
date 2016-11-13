import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import javax.swing.JPanel;

public class GameMap extends JPanel{
	node[][] mappy;
	int s;
	int bombs;
	int w = 500;
	int h = 500;
	
	public void paint(){
		repaint();
	}
	
	public GameMap(int s, int bombs){
		this.s = s;
		this.bombs = bombs;
		mappy = new node[s][s];
		genMap();
	}
	
	public node[][] getMappy(){
		return mappy;
	}
	
//	public static void main(String args[]){
//		GameMap map = new GameMap(10, 10);
//		System.out.println(map);
//	}
	
	public boolean activate(int X, int Y){
		if(mappy[X][Y].getVal() == -1){
			return false;
		}
		else{
			reveal(X, Y);
			return true;
		}
	}
	
	public void reveal(int r, int c){
		mappy[r][c].reveal();
		if(mappy[r][c].getVal()== 0){
			if(r>0){
				if(!mappy[r-1][c].getShow())
				reveal(r-1, c);
				if(c>0){
					if(!mappy[r-1][c-1].getShow())
					reveal(r-1, c-1);
				}
				if(c<s-1){
					if(!mappy[r-1][c+1].getShow())
					reveal(r-1, c+1);
				}
			}
			if(c>0){
				if(!mappy[r][c-1].getShow())
				reveal(r, c-1);
			}
			if(r<s-1){
				if(!mappy[r+1][c].getShow())
				reveal(r+1, c);
				if(c<s-1){
					if(!mappy[r+1][c+1].getShow())
					reveal(r+1, c+1);
				}
				if(c>0){
					if(!mappy[r+1][c-1].getShow())
					reveal(r+1, c-1);
				}
			}
			if(c<s-1){
				if(!mappy[r][c+1].getShow())
				reveal(r, c+1);
			}
			
		}
	}
	
	public void genMap(){
		for(int r = 0; r<s; r++){
			for(int c = 0; c<s; c++){
				mappy[r][c] = new node(0);
			}
		}
			
		for(int i=0; i<bombs; i++){
			int r1 = (int) Math.floor(Math.random()*s);
			int c1 = (int) Math.floor(Math.random()*s);
			mappy[r1][c1].setVal(-1);
		}
		
		for(int r = 0; r<s; r++){
			for(int c = 0; c<s; c++){
			if(mappy[r][c].getVal() != -1){
				int count = 0;
				if(r>0){
					if(mappy[r-1][c].getVal() == -1) count++;
					if(c>0){
						if(mappy[r-1][c-1].getVal() == -1) count++;
					}
					if(c<s-1){
						if(mappy[r-1][c+1].getVal() == -1) count++;
					}
				}
				if(c>0){
					if(mappy[r][c-1].getVal() == -1) count++;
				}
				if(r<s-1){
					if(mappy[r+1][c].getVal() == -1) count++;
					if(c<s-1){
						if(mappy[r+1][c+1].getVal() == -1) count++;
					}
					if(c>0){
						if(mappy[r+1][c-1].getVal() == -1) count++;
					}
				}
				if(c<s-1){
					if(mappy[r][c+1].getVal() == -1) count++;
				}
				mappy[r][c].setVal(count);
			}
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		setOpaque(true);
		super.paintComponent(g);
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.black);
		for(int i = 1; i<11; i++){
			g.drawLine((w/10)*i, 0, (w/10)*i, (h));
		}
		for(int o=1; o<11; o++){
			g.drawLine(0,(h/10)*o, w,(h/10)*o);
		}
		
		for(int r = 0; r<s; r++){
			for(int c = 0; c<s; c++){
				if(mappy[r][c].show){
					if()
					
					else
					g.drawString("" + mappy[r][c].getVal(), (c)*w/10 +23, (r+1)*h/10 -20);
					
				}
			}
		}
		repaint();
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		for(int i =0; i< s; i++){
		str.append(Arrays.toString(mappy[i]));
		str.append('\n');
		}
		return str.toString();
	}
}
