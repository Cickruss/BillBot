package com.billbot.Bin;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Conexao {
    private static final String BASE_URL_HOTMART = "https://hotmart.com/pt-br/marketplace/produtos?initialSelectedCategory=&q=";

    public Document conectar(String search) {

        String url = BASE_URL_HOTMART + search.replaceAll(" ", "+");
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
            System.out.println("Conexão sucedida!");
        } catch (IOException e) {
            System.out.println("Erro ao conectar com o link!");
        }

        return document;
    }
}
