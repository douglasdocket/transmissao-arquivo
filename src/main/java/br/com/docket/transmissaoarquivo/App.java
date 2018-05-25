package br.com.docket.transmissaoarquivo;

public class App {

	public static void main( String[] args ) {
		new ValidadorCSV().executarValidacao();

		new CarregarCSV().executarCarregamento();
	}

}
