package br.com.docket;

import java.io.File;

public class App {

    static String[] headerArquivo = new String[240];

    static String[] arquivosCSV = {
            "header-arquivo-itau"
    };

    public static void main( String[] args ) {
        boolean arquivosOk = validarArquivosCSV();

        if (arquivosOk) {
            System.out.println("Arquivos OK!");
        }

    }

    private static boolean validarArquivosCSV() {

        ClassLoader classLoader = App.class.getClassLoader();

        for (int i = 0; i < arquivosCSV.length; i++) {

            String nomeArquivo = arquivosCSV + ".csv";

            File file = new File(classLoader.getResource(nomeArquivo).getFile());
        }
        


        return true;
    }
}
