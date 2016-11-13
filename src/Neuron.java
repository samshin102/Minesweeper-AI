

public class Neuron {
	
	private float weight;
	float val;
	
	public Neuron(){
		weight = 1F;
		val = 0;
	}
	public Neuron(float weight){
		this.weight = weight;
		val = 0;
	}
	
	public float getWeight(){
		return weight;
	}
	
	public float actFunc(float[] rawInput){
		float summedInput = 0;
		for(float val : rawInput)
			summedInput += val;
		val = (float) (Math.pow(Math.E, summedInput)-Math.pow(Math.E, -summedInput)/Math.pow(Math.E, summedInput)+Math.pow(Math.E, -summedInput) );
		return val;
	}
	public float getValue(){
		return val;
	}
	
	public float getOutput(){
		return (weight * val);
	}
	
}
