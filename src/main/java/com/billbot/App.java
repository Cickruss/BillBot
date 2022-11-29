package com.billbot;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jsoup.nodes.Document;

import com.billbot.Bin.Conexao;
import com.billbot.Bin.Curso;
import com.billbot.Bin.WebScraping;

public class App {
    public static void main(String[] args) {
        String search = JOptionPane.showInputDialog("O que você deseja aprender?");

        ArrayList<Curso> cursos = new ArrayList<Curso>();

        setarArrayCurso(search, cursos);

        ArrayList<String> listaDeCursos = new ArrayList<String>();

        mostrarCursos(cursos, listaDeCursos, search);

    }

    public static void setarArrayCurso(String search, ArrayList<Curso> cursos) {

        Conexao conexao = new Conexao();
        Document document = conexao.conectar(search);
        WebScraping scraping = new WebScraping();
        int quatidadedecursos = scraping.get_nameCourse(document).length;
        String[] imgs = scraping.get_img(document);
        String[] nomes = scraping.get_nameCourse(document);
        String[] autores = scraping.get_autor(document);
        String[] descricoes = scraping.get_descricao(document);

        try {
            for (int i = 0; i < quatidadedecursos; i++) {
                Curso curso = new Curso(imgs[i], nomes[i], descricoes[i], autores[i]);
                cursos.add(curso);
            }
        } catch (Exception e) {

        }

    }

    public static void mostrarCursos(ArrayList<Curso> cursos, ArrayList<String> listaDeCursos, String search) {
        int contador = 1;

        for (Curso curso : cursos) {
            listaDeCursos.add(contador + " - " + curso.getCourseName());
            System.out.println("Imagem do curso: " + curso.getImg());
            System.out.println("Nome do curso: " + curso.getCourseName());
            System.out.println("Autor do curso: " + curso.getAuthor());
            System.out.println("Descrição do curso: " + curso.getDescript());
            System.out.println("\n");
            System.out.println("===========================================");
            System.out.println("\n");
            contador++;
        }
        JOptionPane.showMessageDialog(null,
                listaDeCursos.toString().replace(",", "\n").replace("[", "").replace("]", ""),
                "Pesquisa por " + search,
                JOptionPane.INFORMATION_MESSAGE);
    }

}
