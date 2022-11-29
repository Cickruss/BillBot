package com.billbot.Bin;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebScraping {

    public String[] get_nameCourse(Document doc) {
        Elements elementnomedocurso;
        String nomedocurso = null;

        elementnomedocurso = doc.select("div[class=product-card-alt__title ga-product-card-title]");
        nomedocurso = elementnomedocurso.toString()
                .replace("<div class=\"product-card-alt__title ga-product-card-title\">", "").replace("</div>", ",")
                .replace("\n", "");

        String[] nomes = nomedocurso.split(",");
        return nomes;
    }

    public String[] get_autor(Document document) {
        Elements elementautordocurso;
        String autordocurso = null;

        elementautordocurso = document.select("div[class=product-card-alt__author]");
        autordocurso = elementautordocurso.toString().replace("<div class=\"product-card-alt__author\">", "")
                .replace("</div>", ",").replace("\n", "");

        String[] autores = autordocurso.split(",");

        return autores;
    }

    public String[] get_descricao(Document document) {
        Elements elementdescriptdocurso;
        String ratingdocurso = null;

        elementdescriptdocurso = document.select("div[class=product-card-alt__description]");
        ratingdocurso = elementdescriptdocurso.toString().replace("<div class=\"product-card-alt__description\">", "")
                .replace("</div>", "¶").replace("\n", "");

        String[] descricoes = ratingdocurso.split("¶");
        return descricoes;
    }

    public String[] get_img(Document document) {
        Elements elementimgdocurso;
        String imgdocurso = null;

        elementimgdocurso = document.select("img[class=product-image product-card-alt__image]");
        imgdocurso = elementimgdocurso.toString().replace("<img role=\"presentation\" srcset=\"", "")
                .replace("<img role=\"presentation\" src=\"", "").replace("\n", "¶");

        String[] avaliacoes = imgdocurso.split("¶");

        return avaliacoes;
    }
}
