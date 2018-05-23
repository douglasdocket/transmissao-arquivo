package br.com.docket;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ValidacaoCSV {

	private String[] arquivosCSV = {
			"header-arquivo-itau"
	};

	public boolean validarArquivosCSV() {

		boolean valido = true;

		for (int i = 0; i < arquivosCSV.length; i++) {
			String arquivoCSV = arquivosCSV[i];

			List<String> linhas = pegarLinhas(arquivoCSV);

			for (int j = 0; j < linhas.size(); j++) {
				String linha = linhas.get(j);

				char[] caracteres = linha.toCharArray();

				int quantidadeVirgula = 0;

				for (char caractere : caracteres) {
					quantidadeVirgula = caractere == ',' ? quantidadeVirgula + 1 : quantidadeVirgula;
				}

				if (quantidadeVirgula != 5) {
					System.err.println("Arquivo " + arquivoCSV + " linha " + (j + 1) + " está inválida.");
					valido = false;
				}
			}

		}

		return valido;

	}

	private List<String> pegarLinhas(String arquivoCSV) {
		ClassLoader classLoader = this.getClass().getClassLoader();

		String nomeArquivo = arquivoCSV + ".csv";

		try {
			Path path = Paths.get(classLoader.getResource(nomeArquivo).getPath());

			return Files.readAllLines(path);
		} catch (Exception e) {
			System.err.println("\nNão foi possível carregar arquivo: " + nomeArquivo + "\n");
			e.printStackTrace();

			return new ArrayList<>();
		}

	}
}
