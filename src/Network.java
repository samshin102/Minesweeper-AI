import java.util.Random;

public class Network {

	final int inputDepth;
	final int hiddenWidth;
	final int hiddenDepth;
	final int outputDepth;
	Neuron[][] hiddenLayer;
	Neuron[] inputLayer;
	Random rand = new Random();

	public Network() {
		inputDepth = 9;
		hiddenWidth = 3;
		hiddenDepth = 3;
		outputDepth = 1;
		createNetwork();
	}

	public Network(int inputDepth, int hiddenWidth, int hiddenDepth, int outputDepth) {
		this.inputDepth = inputDepth;
		this.hiddenWidth = hiddenWidth;
		this.hiddenDepth = hiddenDepth;
		this.outputDepth = outputDepth;
		createNetwork();
	}

	public void createNetwork() {
		inputLayer = new Neuron[inputDepth];
		
		hiddenLayer = new Neuron[hiddenDepth][hiddenWidth];
		for (int row = 0; row < hiddenLayer.length; row++) {
			for (int col = 0; col < hiddenLayer[0].length; col++) {
				hiddenLayer[row][col] = new Neuron(rand.nextFloat());
			}
		}
	}

	public void mutate() {

	}

	public float getOutput(float[] inputValues) {

		

	}
}
