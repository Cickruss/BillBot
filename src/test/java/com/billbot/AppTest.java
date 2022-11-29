package com.billbot;

import static org.junit.Assert.*;

import org.junit.Test;

import com.billbot.Bin.Conexao;
import com.billbot.Bin.Curso;
import com.billbot.Bin.WebScraping;

import org.jsoup.nodes.Document;

public class AppTest {
    Conexao conexao = new Conexao();

    @Test
    public void testConexao() {
        assertNotNull(conexao.conectar("java"));
    }

    WebScraping scraping = new WebScraping();
    Document doc = (Document) conexao.conectar("java");

    @Test
    public void testeGetName() {
        String nome = scraping.get_nameCourse(doc).toString();
        boolean validate = nome.contains(nome);

        assertTrue(validate);
    }

    @Test
    public void testeGetAutor() {
        assertNotNull(scraping.get_autor(doc));
    }

    @Test
    public void testeGetDecricao() {
        assertNotNull(scraping.get_descricao(doc));
    }

    @Test
    public void testeGetImg() {
        assertNotNull(scraping.get_img(doc));
    }

    @Test
    public void testeObjetos() {
        String img = "gato de botas";
        String courseName = "java para iniciantes";
        String decript = "O melhor curso do mundo";
        String author = "João sem braço";

        Curso curso = new Curso(img, courseName, decript, author);

        assertEquals("gato de botas", curso.getImg());
        assertEquals("java para iniciantes", curso.getCourseName());
        assertEquals("O melhor curso do mundo", curso.getDescript());
        assertEquals("João sem braço", curso.getAuthor());
    }
}
