/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeVibe;

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
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File entrada = new File("C:\\Users\\Camille\\Documents\\NetBeansProjects\\Cadastro\\src\\java\\testeVibe\\io\\teste.txt");
        FileReader leitorEntrada = new FileReader(entrada);
        BufferedReader br = new BufferedReader(leitorEntrada);

        List<String> datas = new ArrayList<>();
        List<String> nomes = new ArrayList<>();
        List<String> valores = new ArrayList<>();

        while (br.ready()) {

            String linha = br.readLine();
            linha = linha.replace("|", " ; ");
            String dados[] = linha.split(" ; ");

            String dia[] = dados[0].split("/");

            datas.add(dia[0]);
            nomes.add(dados[1]);
            valores.add(dados[2]);

        }
        
        List<Integer>xs = new ArrayList<>();
        
        for(int i = 0; i < datas.size() ; i++){
        
           int x = Integer.parseInt(datas.get(i));           
           xs.add(x);
           
        }
        
        List<Integer>xsOrdenado = new ArrayList<>();
        int aux = 0;
                
        for (int i = 0; i < xs.size(); i++) {
            for (int j = 0; j < xs.size()-1; j++) {
                if(xs.get(j)>xs.get(j+1)){
                    System.out.println("dia: "+xs.get(j)+" maior que "+xs.get(j+1));
                    aux = xs.get(j);
                }
            }
        }
        
        for (int i = 0; i < xsOrdenado.size(); i++) {
            System.out.println(xsOrdenado.get(i));
        }
        
        

        List<String> nomes2 = new ArrayList<>();

        for (int i = 0; i < nomes.size(); i++) {

            if (!nomes2.containsAll(nomes)) {

                nomes2.add(nomes.get(i));

            }

        }

    }
}
