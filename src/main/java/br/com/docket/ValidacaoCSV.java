package br.com.docket;

import java.io.File;

public class ValidacaoCSV {

	private String[] arquivosCSV = {
			"header-arquivo-itau"
	};

	private void validarArquivosCSV() {
		ClassLoader classLoader = this.getClass().getClassLoader();

		for (int i = 0; i < arquivosCSV.length; i++) {
			String nomeArquivo = arquivosCSV + ".csv";

			File file = new File(classLoader.getResource(nomeArquivo).getFile());



		}
	}
}
