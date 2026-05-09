import java.util.NoSuchElementException;

public class Fila<E> {

	private Celula<E> inicio;
	private Celula<E> fim;

	public Fila() {

		Celula<E> sentinela = new Celula<E>();
		inicio = sentinela;
		fim = sentinela;
	}

	public boolean vazia() {
		return inicio == fim;
	}

	public void enfileirar(E item) {

		fim.setProximo(new Celula<E>(item));
		fim = fim.getProximo();
	}

	public E desenfileirar() {

		E desenfileirado = consultarPrimeiro();
		Celula<E> primeira = inicio.getProximo();
		inicio.setProximo(primeira.getProximo());
		if (primeira == fim) {
			fim = inicio;
		}
		return desenfileirado;
	}

	public E consultarPrimeiro() {

		if (vazia()) {
			throw new NoSuchElementException("Não há nenhum item na fila!");
		}
		return inicio.getProximo().getItem();
	}

	public int contarOcorrencias(E item) {

		int ocorrencias = 0;
		Celula<E> atual = inicio.getProximo();
		while (atual != null) {
			if (atual.getItem() != null && atual.getItem().equals(item)) {
				ocorrencias++;
			}
			atual = atual.getProximo();
		}
		return ocorrencias;
	}

	public Fila<E> extrairLote(int numItens) {

		Fila<E> lote = new Fila<E>();
		for (int i = 0; i < numItens && !vazia(); i++) {
			lote.enfileirar(desenfileirar());
		}
		return lote;
	}
}
