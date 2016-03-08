/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Camille
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File banco = new File("C:\\Users\\Camille\\Documents\\NetBeansProjects\\Cadastro\\src\\java\\banco\\banco");

        FileReader converteParaBufferedLer;

        BufferedReader ler;

        Scanner entrada = new Scanner(System.in);

        Produto produto = new Produto();

        int opcao;

        System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar");
        opcao = (Integer.parseInt(entrada.nextLine()));

        do {

            switch (opcao) {

                case 1:

                    //entrada
                    FileWriter bandoEscrever = new FileWriter(banco, true);
                    BufferedWriter escrever = new BufferedWriter(bandoEscrever);

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

                    System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar");
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

                    System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar");
                    opcao = (Integer.parseInt(entrada.nextLine()));

                    break;

                case 3:

                    //buscar
                    converteParaBufferedLer = new FileReader(banco);
                    ler = new BufferedReader(converteParaBufferedLer);

                    System.out.println("entre com o id do procuto: ");
                    String id = entrada.nextLine();

                    while (ler.ready()) {

                        String linha = ler.readLine();
                        String idForm = linha.substring(0, 4);

                        if (id.equals(idForm)) {

                            System.out.println(linha);

                        }
                    }

                    ler.close();

                    System.out.println("\n MENU:  1- Inserir  2- Listar 3- Buscar");
                    opcao = (Integer.parseInt(entrada.nextLine()));

                    break;
                    
                case 4:
                    
                    //excluir
                    converteParaBufferedLer = new FileReader(banco);
                    ler =new BufferedReader(converteParaBufferedLer);
                    
                                        
                    
                    break;

            }

        } while (opcao
                != 0);

    }

}
