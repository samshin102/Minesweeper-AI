import java.util.Random;

public class Neuron {
	Random randy = new Random();
	int width = 0;
	private final float initialWeightMax = 5;
	final float delta = 0.15f;
	float[] weight;
	float val;

	public Neuron() {
		this(0);
	}

	public Neuron(int width) {
		this.width = width;
		weight = new float[this.width];
		for (int i = 0; i < weight.length; i++) {
			weight[i] = (float) (initialWeightMax * randy.nextFloat() * (randy.nextBoolean() ? 1 : -1));
		}
		val = 0;
	}

	public Neuron(Neuron p) {
		width = p.width;
		weight = new float[p.width];
		for (int i = 0; i < weight.length; i++) {
			weight[i] = p.weight[i];
		}
	}

	public void mutate() {
		int w = randy.nextInt(weight.length);
		weight[w] += delta * (randy.nextBoolean() ? 1 : -1);
	}

	private float actFunc(float v) {
		float actiVal = (float) ((Math.pow(Math.E, v) - Math.pow(Math.E, -v))
				/ (Math.pow(Math.E, v) + Math.pow(Math.E, -v)));
		return actiVal;
	}

	public float getValue(int nc) {
		return weight[nc] * actFunc(val);
	}
}
