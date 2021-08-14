package video.aula;

/**
 * 
 * @author Shiguemori
 *
 */
public class ArvoreBinaria {

	public int valor;
	public ArvoreBinaria esquerda;
	public ArvoreBinaria direita;

	/**
	 * Construção da arvore
	 * 
	 * @param valor
	 * @param esquerda
	 * @param direita
	 */
	ArvoreBinaria(int valor, ArvoreBinaria esquerda, ArvoreBinaria direita) {
		this.valor = valor;
		this.esquerda = esquerda;
		this.direita = direita;
	}

	public ArvoreBinaria inserir(int valor) {
		return inserir(this, valor);
	}

	/**
	 * Preenche a arvore
	 * 
	 * @param noDaArvore
	 * @param valor
	 * @return
	 */
	public static ArvoreBinaria inserir(ArvoreBinaria noDaArvore, int valor) {
		if (noDaArvore == null) {
			return new ArvoreBinaria(valor, null, null);
		} else {
			ArvoreBinaria novoNo;
			if (valor <= noDaArvore.valor) {
				novoNo = inserir(noDaArvore.esquerda, valor);
				noDaArvore.esquerda = novoNo;
			} else {
				novoNo = inserir(noDaArvore.direita, valor);
				noDaArvore.direita = novoNo;
			}
			return noDaArvore;
		}
	}


	/**
	 * Itera a arvore
	 * 
	 * @param noDaArvore
	 */
	public void iterarNo() {
		int i = 0;
		int altura = this.altura();
		for (i = 0; i <= altura; i++) {
			imprimirRecursivo(this, i);
		}
	}

	/**
	 * Imprime os valores de forma recursiva transversal
	 * 
	 * @param noDaArvore
	 * @param alvo
	 */
	public static void imprimirRecursivo(ArvoreBinaria noDaArvore, int alvo) {
		if (noDaArvore == null)
			return;

		if (alvo == 0)
			System.out.print(noDaArvore.valor + " ");

		imprimirRecursivo(noDaArvore.esquerda, alvo - 1);
		imprimirRecursivo(noDaArvore.direita, alvo - 1);
	}

	public int altura() {
		return this.altura(this);
	}

	/**
	 * Retorna a altura da arvore
	 * 
	 * @param noDaArvore
	 * @return
	 */
	private int altura(ArvoreBinaria noDaArvore) {
		if (noDaArvore == null)
			return -1;

		if (noDaArvore.esquerda == null && noDaArvore.direita == null) {
			return 0;
		}

		int esquerda = 1 + altura(noDaArvore.esquerda);
		int direita = 1 + altura(noDaArvore.direita);

		return esquerda > direita ? esquerda : direita;
	}

	/**
	 * Imprimi os valores da arvore de forma recursiva
	 * 
	 * @param no
	 */
	public static void imprimirPreOrdem(ArvoreBinaria noDaArvore) {
		System.out.print(noDaArvore.valor + " ");
		if (noDaArvore.esquerda != null) {
			ArvoreBinaria.imprimirPreOrdem(noDaArvore.esquerda);
		}
		if (noDaArvore.direita != null) {
			ArvoreBinaria.imprimirPreOrdem(noDaArvore.direita);
		}
	}

	/**
	 * Conta quantos nós tem a arvore
	 * 
	 * @param soma
	 * @return
	 */
	public int contarNos(int soma) {
		soma = soma + 1;
		if (this.temEsquerda())
			soma = this.esquerda.contarNos(soma);

		if (this.temDireita())
			soma = this.direita.contarNos(soma);

		return soma;
	}

	/**
	 * Busca o valor dentro da arvore
	 * 
	 * @param alvo
	 * @param encontrado
	 * @return
	 */
	public boolean buscar(int alvo, boolean encontrado) {

		if (this.valor == alvo) {
			encontrado = true;
		}

		if (encontrado == true) {
			return encontrado;
		}

		if (alvo <= this.valor) {
			if (!this.temEsquerda())
				return false;

			encontrado = this.esquerda.buscar(alvo, encontrado);
		} else {

			if (!this.temDireita())
				return false;

			encontrado = this.direita.buscar(alvo, encontrado);
		}
		return encontrado;
	}

	/**
	 * Valida se possui esquerda e direita
	 * 
	 * @return
	 */
	public boolean temDireitaEEsquerda() {
		if (this.temEsquerda() && this.temDireita())
			return true;
		else
			return false;
	}

	/**
	 * Valida se possui esquerda ou direita
	 * 
	 * @return
	 */
	public boolean temDireitaOuEsquerda() {
		if (this.temEsquerda() || this.temDireita())
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param noDaArvore
	 * @return
	 */
	public boolean temDireitaEEsquerda(ArvoreBinaria noDaArvore) {
		if (noDaArvore.temEsquerda() && noDaArvore.temDireita())
			return true;
		else
			return false;
	}

	/**
	 * Valida se possui direita
	 * 
	 * @return
	 */
	public boolean temDireita() {
		if (this.direita == null)
			return false;
		else
			return true;
	}

	/**
	 * Valida se possui esquerda
	 * 
	 * @return
	 */
	public boolean temEsquerda() {
		if (this.esquerda == null)
			return false;
		else
			return true;
	}

	/**
	 * Remove o no
	 * 
	 * @param valor
	 * @return
	 */
	public ArvoreBinaria removerNo(int valor) {
		return this.removerNo(this, valor);
	}

	/**
	 * 
	 * Remove o no
	 * 
	 * @param noDaArvore
	 * @param valor
	 * @return
	 */
	public ArvoreBinaria removerNo(ArvoreBinaria noDaArvore, int valor) {
		if (noDaArvore == null)
			return noDaArvore;

		if (valor > noDaArvore.valor) {
			noDaArvore.direita = removerNo(noDaArvore.direita, valor);

		} else if (valor < noDaArvore.valor) {
			noDaArvore.esquerda = removerNo(noDaArvore.esquerda, valor);

		} else {
			if (noDaArvore.esquerda == null && noDaArvore.direita == null) {
				noDaArvore = null;

			} else if (noDaArvore.direita != null) {
				noDaArvore.valor = sucessor(noDaArvore);
				noDaArvore.direita = removerNo(noDaArvore.direita, noDaArvore.valor);
			} else {
				noDaArvore.valor = predecessor(noDaArvore);
				noDaArvore.esquerda = removerNo(noDaArvore.esquerda, noDaArvore.valor);
			}
		}
		return noDaArvore;
	}

	/**
	 * 
	 * @param noDaArvore
	 * @return
	 */
	private int sucessor(ArvoreBinaria noDaArvore) {
		noDaArvore = noDaArvore.direita;
		while (noDaArvore.esquerda != null) {
			noDaArvore = noDaArvore.esquerda;
		}
		return noDaArvore.valor;
	}

	/**
	 * 
	 * @param noDaArvore
	 * @return
	 */
	private int predecessor(ArvoreBinaria noDaArvore) {
		noDaArvore = noDaArvore.esquerda;
		while (noDaArvore.direita != null) {
			noDaArvore = noDaArvore.direita;
		}
		return noDaArvore.valor;
	}

}
