package br.com.docket;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ValidacaoCSV {

	private String[] arquivosCSV = {
			"header-arquivo-itau"
	};

	public void validarArquivosCSV() {
		ClassLoader classLoader = this.getClass().getClassLoader();

		for (int i = 0; i < arquivosCSV.length; i++) {
			String nomeArquivo = arquivosCSV[i] + ".csv";

			Path path = Paths.get(classLoader.getResource(nomeArquivo).getPath());

			try {
				List<String> lines = Files.readAllLines(path);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
