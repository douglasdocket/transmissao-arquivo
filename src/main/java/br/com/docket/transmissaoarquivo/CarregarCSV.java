package br.com.docket.transmissaoarquivo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class CarregarCSV {

	public static void main(String[] args) throws IOException {


		Path arquivo = Paths.get("layout-arquivo/itau/arquivo");

		List<Path> paths = Files.list(arquivo).collect(Collectors.toList());

		for (Path path : paths) {

			if (Files.notExists(path)) {
				continue;
			}

			if (Files.isHidden(path)) {
				continue;
			}

			if (!Files.isReadable(path)) {
				continue;
			}

			if (Files.isDirectory(path)) {
				continue;
			}

			String fileName = path.getFileName().toString();

			if (!fileName.endsWith(".csv")) {
				continue;
			}

			//TODO nath implementar leitura de linhas e para cada linha criar uma nova instancia de HeaderArquivo setar atributos e salvar em uma lista e imprimir essa lista em formato JSON no console ao terminar todo processo


		}


	}

}
