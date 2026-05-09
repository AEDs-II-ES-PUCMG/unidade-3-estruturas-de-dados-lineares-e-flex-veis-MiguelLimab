public class TesteFila {

	public static void main(String[] args) {

		String nome = "MiguelLima";
		Fila<Character> fila = new Fila<>();

		System.out.println("Enfileirando os caracteres de \"" + nome + "\"...");
		for (int i = 0; i < nome.length(); i++) {
			fila.enfileirar(nome.charAt(i));
		}

		System.out.println("Ocorrências de 'i': " + fila.contarOcorrencias('i'));
		System.out.println("Ocorrências de 'M': " + fila.contarOcorrencias('M'));
		System.out.println("Ocorrências de 'L': " + fila.contarOcorrencias('L'));
		System.out.println("Ocorrências de 'z': " + fila.contarOcorrencias('z'));

		System.out.print("Desenfileirando todos os caracteres: ");
		while (!fila.vazia()) {
			System.out.print(fila.desenfileirar());
		}
		System.out.println();

		System.out.println("Fila vazia após desenfileirar tudo? " + fila.vazia());

		System.out.println("\nTeste de extrairLote:");
		for (int i = 0; i < nome.length(); i++) {
			fila.enfileirar(nome.charAt(i));
		}
		Fila<Character> lote = fila.extrairLote(4);
		System.out.print("Lote extraído (4 primeiros): ");
		while (!lote.vazia()) {
			System.out.print(lote.desenfileirar());
		}
		System.out.println();
		System.out.print("Restante da fila original: ");
		while (!fila.vazia()) {
			System.out.print(fila.desenfileirar());
		}
		System.out.println();
	}
}
