

public class Neuron {
	
	private float[] inputValues;
	private float weight;
	
	public Neuron(){
		inputValues = new float[1];
		weight = 1F;
	}
	public Neuron(float[] inputValues, float weight){
		this.weight = weight;
		inputValues = new float[inputValues.length];
	}
	
	public float getWeight(){
		return weight;
	}
	
	public float actFunc(){
		float rawInput = 0F;
		float preOperation = 0;
		for(float val : inputValues)
			rawInput += val;
		preOperation = weight * rawInput;
		return (float) (Math.pow(Math.E, preOperation)-Math.pow(Math.E, -preOperation) );
	}
	
}
