import java.util.ArrayList;

public class CaveMan {

	private String name;
	private int age;
	private float weight;
	private ArrayList<Rock> rockCollection;

	public CaveMan() {
		this.setName("No name");
		this.setAge(99);
		this.setWeight(99999f);
		this.setRockCollection(null);
	}

	public CaveMan(String name, int age, float weight, ArrayList<Rock> ar) {
		super();
		this.setName(name);
		this.setAge(age);
		this.setWeight(weight);
		this.setRockCollection(ar);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public ArrayList<Rock> getRockCollection() {
		return rockCollection;
	}

	public void setRockCollection(ArrayList<Rock> rockCollection) {
		this.rockCollection = rockCollection;
	}

	public void sayHi() {
		System.out.println("Hi my name is " + this.getName());
	}

	@Override
	public String toString() {
		return "CaveMan [name=" + name + ", age=" + age + ", weight=" + weight + ", rockCollection=" + rockCollection
				+ "]";
	}

}
