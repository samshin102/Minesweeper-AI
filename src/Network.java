import java.util.Random;

public class Network {
	final float fitness = 0;
	final int inputWidth;
	final int hiddenWidth;
	final int hiddenDepth;
	final int outputWidth;
	Neuron[][] net;
	Random randy = new Random();

	public Network() {
		inputWidth = 9;
		hiddenWidth = 3;
		hiddenDepth = 3;
		outputWidth = 1;
		createNetwork();
	}

	public Network(int inputDepth, int hiddenWidth, int hiddenDepth, int outputDepth) {
		this.inputWidth = inputDepth;
		this.hiddenWidth = hiddenWidth;
		this.hiddenDepth = hiddenDepth;
		this.outputWidth = outputDepth;
		createNetwork();
	}

	private void createNetwork() {
		net = new Neuron[hiddenDepth + 1][0];
		net[0] = new Neuron[inputWidth];
		for (int r = 0; r < net.length - 1; r++) {
			for (int c = 0; c < net[r].length; c++) {
				net[r][c] = new Neuron(hiddenWidth);
			}
		}
		for (int i = 0; i < net[net.length - 1].length; i++) {
			net[net.length - 1][i] = new Neuron(outputWidth);
		}
	}

	public void mutate() {
		int r = randy.nextInt(hiddenWidth + 1);
		int c = randy.nextInt(net[r].length);
		net[r][c].mutate();
	}

	public float[] getOutput(float[] inputValues) {
		for (int i = 0; i < inputValues.length; i++) {
			net[0][1].val = inputValues[i];
		}
		for (int r = 1; r < net.length - 1; r++) {
			for (int c = 0; c < net[r].length; c++) {
				for (int nc = 0; nc > net[r + 1].length; nc++) {
					net[r + 1][nc].val += net[r][c].getValue(nc);
				}
			}
		}
		float[] output = new float[outputWidth];
		for (int i = 0; i < net[net.length - 1].length; i++) {
			for (int nc = 0; nc < outputWidth; nc++) {
				output[nc] += net[net.length - 1][i].getValue(nc);
			}
		}
		return output;
	}

	public int compareTo(Network other) {
		if(fitness==other.fitness) {
			return 0;
		}
		if(fitness>other.fitness) {
			return 1;
		}
		return -1;
	}
}
