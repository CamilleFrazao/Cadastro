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
public class Executavel {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File entrada = new File("C:\\Users\\Camille\\Documents\\NetBeansProjects\\Cadastro\\src\\java\\testeVibe\\io\\teste.txt");
        FileReader leitorEntrada = new FileReader(entrada);
        BufferedReader br = new BufferedReader(leitorEntrada);

        List<Pessoa> pessoas = new ArrayList<>();
        List<String> datas = new ArrayList<>();
        List<String> nomes = new ArrayList<>();
        List<String> valores = new ArrayList<>();

        Pessoa pessoa = new Pessoa();

        while (br.ready()) {

            String linha = br.readLine();
            linha = linha.replace("|", " ; ");
            String dados[] = linha.split(" ; ");

            datas.add(dados[0]);
            nomes.add(dados[1]);
            valores.add(dados[2]);

        }
        
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
            pessoa.setNome(nomes.get(i));
            pessoas.add(pessoa);
        }
//
//        for (int i = 0; i < datas.size(); i++) {
//
//            pessoa.setData(datas.get(i));
//            pessoa.setNome(nomes.get(i));
//            pessoa.setValor(valores.get(i));
//            
//            pessoas.add(pessoa);
//
//        }
        
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i).getNome());
        }

    }

}
