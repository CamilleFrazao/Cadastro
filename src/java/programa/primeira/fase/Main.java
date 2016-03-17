/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa.primeira.fase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import programa.Produto;

/**
 *
 * @author Camille
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File banco = new File("C:\\Users\\Camille\\Documents\\NetBeansProjects\\Cadastro\\src\\java\\banco\\banco");

        FileReader converteParaBufferedLer;

        BufferedReader ler;

        FileWriter bandoEscrever;

        BufferedWriter escrever;

        List<String> produtos;

        Scanner entrada = new Scanner(System.in);

        Produto produto = new Produto();

        int opcao;

        String id;

        System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar 4- Excluir 5- Editar");
        opcao = (Integer.parseInt(entrada.nextLine()));

        do {

            switch (opcao) {

                case 1:

                    //entrada
                    bandoEscrever = new FileWriter(banco, true);
                    escrever = new BufferedWriter(bandoEscrever);

                    System.out.println("ID: ");
                    produto.setId(Integer.parseInt(entrada.nextLine()));

                    if (produto.getId() < 999 || produto.getId() > 9999) {

                        do {

                            System.out.println("\n Id precisa ter 4 digitos, por favor insira corretamente! \n");
                            produto.setId(Integer.parseInt(entrada.nextLine()));

                        } while (produto.getId() < 999 || produto.getId() > 9999);

                    }

                    System.out.println("NOME: ");
                    produto.setNome(entrada.nextLine());

                    System.out.println("QUANTIDADE: ");
                    produto.setQuantidade(Integer.parseInt(entrada.nextLine()));

                    System.out.println("UNIDADE: ");
                    produto.setUnidade(Integer.parseInt(entrada.nextLine()));

                    System.out.println("VALOR: ");
                    produto.setValor(Double.parseDouble(entrada.nextLine()));

                    escrever.write(produto.getId() + ";" + produto.getNome() + ";" + produto.getQuantidade() + ";" + produto.getUnidade() + ";" + produto.getValor());

                    escrever.newLine();

                    escrever.close();

                    System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar 4- Excluir 5- Editar");
                    opcao = (Integer.parseInt(entrada.nextLine()));

                    break;

                case 2:

                    //listar
                    converteParaBufferedLer = new FileReader(banco);
                    ler = new BufferedReader(converteParaBufferedLer);

                    while (ler.ready()) {

                        String linha = ler.readLine();
                        System.out.println(linha);

                    }

                    ler.close();

                    System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar 4-Excluir 5- Editar");
                    opcao = (Integer.parseInt(entrada.nextLine()));

                    break;

                case 3:

                    //buscar
                    converteParaBufferedLer = new FileReader(banco);
                    ler = new BufferedReader(converteParaBufferedLer);

                    System.out.println("entre com o id do procuto: ");
                    id = entrada.nextLine();

                    while (ler.ready()) {

                        String linha = ler.readLine();
                        String idForm = linha.substring(0, 4);

                        if (id.equals(idForm)) {

                            System.out.println(linha);

                        }
                    }

                    ler.close();

                    System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar 4- Excluir 5- Editar");
                    opcao = (Integer.parseInt(entrada.nextLine()));

                    break;

                case 4:

                    //excluir
                    converteParaBufferedLer = new FileReader(banco);
                    ler = new BufferedReader(converteParaBufferedLer);

                    produtos = new ArrayList<>();

                    while (ler.ready()) {

                        String linha = ler.readLine();
                        String idForm = linha.substring(0, 4);

                        produtos.add(linha);

                    }

                    bandoEscrever = new FileWriter(banco);
                    escrever = new BufferedWriter(bandoEscrever);

                    while (ler.ready()) {

                        String linha = ler.readLine();

                        linha = " ";

                        escrever.write(linha);

                    }

                    System.out.println("QUAL O ID PARA APAGAR?");
                    String entradaId = entrada.nextLine();

                    int i = 0;

                    while (i < produtos.size()) {

                        System.out.println(produtos.get(i));

                        String s = produtos.get(i).substring(0, 4);

                        System.out.println(s);

                        if (s.equals(entradaId)) {
                            System.out.println("ex: " + produtos.get(i));
                            produtos.remove(produtos.get(i));
                            i--;
                        }
                        if (!produtos.contains(entradaId)) {
                            i++;
                        }

                    }

                    for (i = 0; i < produtos.size(); i++) {

                        escrever.write(produtos.get(i));
                        escrever.newLine();
                    }

                    ler.close();
                    escrever.close();

                    System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar 4-Excluir 5- Editar");
                    opcao = (Integer.parseInt(entrada.nextLine()));

                    break;

                case 5:
                    //excluir
                    converteParaBufferedLer = new FileReader(banco);
                    ler = new BufferedReader(converteParaBufferedLer);

                    produtos = new ArrayList<>();

                    while (ler.ready()) {

                        String linha = ler.readLine();
                        String idForm = linha.substring(0, 4);

                        produtos.add(linha);

                    }

                    bandoEscrever = new FileWriter(banco);
                    escrever = new BufferedWriter(bandoEscrever);

                    while (ler.ready()) {

                        String linha = ler.readLine();

                        linha = " ";

                        escrever.write(linha);

                    }

                    System.out.println("QUAL O ID PARA APAGAR?");
                    String idEditar = entrada.nextLine();

                    int m = 0;

                    while (m < produtos.size()) {

                        System.out.println(produtos.get(m));

                        String s = produtos.get(m).substring(0, 4);

                        System.out.println(s);

                        if (s.equals(idEditar)) {

                            System.out.println("ex: " + produtos.get(m));

                            System.out.println("Entre com o novo id: ");
                            produto.setId(Integer.parseInt(entrada.nextLine()));

                            System.out.println("Entre com o novo nome: ");
                            produto.setNome(entrada.nextLine());

                            System.out.println("Entre com a nova quantidade");
                            produto.setQuantidade(Integer.parseInt(entrada.nextLine()));

                            System.out.println("Entre com a nova Unidade");
                            produto.setUnidade(Integer.parseInt(entrada.nextLine()));

                            System.out.println("Entre com o novo valor: ");
                            produto.setValor(Double.parseDouble(entrada.nextLine()));

                            produtos.remove((m));

                            m--;

                            produtos.add(produto.getId() + ";" + produto.getNome() + ";" + produto.getQuantidade() + ";" + produto.getUnidade() + ";" + produto.getValor());

                        }

                        if (!produtos.contains(idEditar)) {
                            m++;
                        }

                    }

                    for (m = 0; m < produtos.size(); m++) {

                        escrever.write(produtos.get(m));
                        escrever.newLine();
                    }

                    ler.close();
                    escrever.close();

                    System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar 4-Excluir 5- Editar");
                    opcao = (Integer.parseInt(entrada.nextLine()));

                    break;

            }

        } while (opcao
                != 0);

    }

}
