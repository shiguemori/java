
public class Rock {

	private String color;
	private float weight;

	public Rock() {
		super();
		this.setColor("black");
		this.setWeight(1.5f);
	}

	public Rock(String color, float weight) {
		super();
		this.setColor(color);
		this.setWeight(weight);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Rock [color=" + color + ", weight=" + weight + "]";
	}

	
}
