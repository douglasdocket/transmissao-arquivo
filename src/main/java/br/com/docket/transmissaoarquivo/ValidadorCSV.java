package br.com.docket.transmissaoarquivo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ValidadorCSV {

	public static void main(String[] args) {
		new ValidadorCSV().executarValidacao();
	}

	public void executarValidacao() {
		Path path = Paths.get("layout-arquivo");

		explorar(path);
	}

	private void explorar(Path path) {

		try {

			if (Files.notExists(path)) {
				return;
			}

			if (Files.isHidden(path)) {
				return;
			}

			if (!Files.isReadable(path)) {
				return;
			}

			if (Files.isDirectory(path)) {
				List<Path> files = Files.list(path).collect(Collectors.toList());

				for (Path file : files) {
					explorar(file);
				}

			}

			String fileName = path.getFileName().toString();

			if (!fileName.endsWith(".csv")) {
				return;
			}

			System.out.println("\n=== Validação ===");
			System.out.println("Arquivo: " + path);

			List<String> lines = Files.lines(path).collect(Collectors.toList());

			System.out.println("Qtd. de linhas: " + lines.size());

			int quantidadeLinhasValidas = 0;
			int quantidadeLinhasInvalidas = 0;

			System.out.print("Linhas inválidas: ");

			for (int i = 0; i < lines.size(); i++) {
				String line = lines.get(i);

				char[] chars = line.toCharArray();

				int quantidadeVirgula = 0;

				for (char aChar : chars) {

					if (aChar == ',') {

						quantidadeVirgula++;

					}

				}

				if (quantidadeVirgula == 5) {
					quantidadeLinhasValidas++;
				}

				if (quantidadeVirgula != 5) {
					quantidadeLinhasInvalidas++;
					String numeroLinha = String.valueOf(i + 1);
					System.out.print(numeroLinha + ",");
				}
			}

			System.out.println();

			System.out.println("Qtd. de linhas válidas: " + quantidadeLinhasValidas);
			System.out.println("Qtd. de linhas inválidas: " + quantidadeLinhasInvalidas);

			System.out.println();

			return;

		} catch (Exception e) {
			e.printStackTrace();

			return;
		}

	}

}
