package br.com.docket.transmissaoarquivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CarregarCSV {

	public static void main(String[] args) {
		new CarregarCSV().executarCarregamento();
	}

	public void executarCarregamento() {
		Path path = Paths.get("layout-arquivo");

		try {
			explorar(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void explorar(Path path) throws IOException {

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
			if (path.getFileName().equals("arquivo")) {

			}



		}

	}

}
