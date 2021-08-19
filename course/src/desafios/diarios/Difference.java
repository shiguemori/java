package desafios.diarios;

public class Difference {

	public int maior = 0;
	public int menor = 999999999;
	public int maximumDifference;
  	private int[] elements;
  	
	public Difference(int[] a) {
		this.elements = a;
	}

	public void computeDifference() {
		
		for (int i : this.elements) {
			i = Math.abs(i);
			if (this.maior < i)
				this.maior = i;
			
			if (this.menor > i)
				this.menor = i;
			
		}
		
		this.maximumDifference = this.maior - this.menor;
	}

}
