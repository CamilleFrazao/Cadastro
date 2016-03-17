/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa.primeira.fase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camille
 */
public class NovoClass {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        List<String> produtos = new ArrayList<>();

        File banco = new File("C:\\Users\\Camille\\Documents\\NetBeansProjects\\Cadastro\\src\\java\\banco\\banco");

        FileReader converteParaBufferedLer = new FileReader(banco);
        BufferedReader ler = new BufferedReader(converteParaBufferedLer);

        while (ler.ready()) {

            String linha = ler.readLine();
            String idForm = linha.substring(0, 4);

            produtos.add(linha);

        }

        ler.close();
        converteParaBufferedLer.close();

//        int i = 0;
//        
//              while (i < produtos.size()) {
//            
//            System.out.println(produtos.get(i));
//            
//            String s = produtos.get(i).substring(0, 4);
//            
//            System.out.println(s);
//            
//            if (s.equals("3111")) {
//                System.out.println("ex: "+produtos.get(i));
//                produtos.remove(produtos.get(i));
//                
//            }
//            if (!produtos.contains("3111")) {
//                i++;
//            }
//
//        }


        

        System.out.println("--------lista---------");

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i));
        }

    }

}
