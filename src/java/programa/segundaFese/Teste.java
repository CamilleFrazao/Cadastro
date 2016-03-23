/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa.segundaFese;

import java.lang.reflect.Array;

/**
 *
 * @author Camille
 */
public class Teste {

    public static void main(String[] args) {

        String ler = "Camille f;20/10/1992;av";

        String linha = ler;
//
//        linha = linha.replace(" ", "...");
//
//        System.out.println(linha);
//
//        linha = linha.replace(";", " ");

        System.out.println("linha sem ; :" + linha);
        
        String nomes[] = linha.split(";");
        
        System.out.println(nomes.length);
        
        String nome = nomes[0];
        System.out.println(nome);
        
     
    }

}
