
public class Main {

	
	public Main(){
		init();
	}
	
	public void init(){
		MineSweeper thready = new MineSweeper();
		Thread loopy = new Thread(thready);
		loopy.start();
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Main MineSweeper = new Main();
	}

}
