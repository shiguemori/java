package video.aula;

public class ArvoreNaria {

	public int valor;
	public ArvoreNaria filhoPrimogenito;
	public ArvoreNaria irmao;

	/**
	 * 
	 * @param valor
	 * @param filhoPrimogenito
	 * @param irmao
	 */
	ArvoreNaria(int valor, ArvoreNaria filhoPrimogenito, ArvoreNaria irmao) {
		this.valor = valor;
		this.filhoPrimogenito = filhoPrimogenito;
		this.irmao = irmao;
	}
	
}
