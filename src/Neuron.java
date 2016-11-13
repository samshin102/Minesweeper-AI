import java.util.Random;

public class Neuron {
	Random randy = new Random();
	private final float initialWeightMax = 5;
	final float delta = 0.25f;
	private float[] weight;
	float val;

	public Neuron() {
		this(0);
	}

	public Neuron(int width) {
		weight = new float[width];
		for (int i = 0; i < weight.length; i++) {
			weight[i] = (float) (initialWeightMax * randy.nextFloat() * (randy.nextBoolean() ? 1 : -1));
		}
		val = 0;
	}

	public void mutate() {
		int w = randy.nextInt(weight.length);
	}

	private float actFunc(float v) {
		float actiVal = (float) (Math.pow(Math.E, v)
				- Math.pow(Math.E, -v) / (Math.pow(Math.E, v) + Math.pow(Math.E, -v)));
		return actiVal;
	}

	public float getValue(int nc) {
		return weight[nc] * actFunc(val);
	}
}
