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
        System.out.print("Datas     | ");
        for (int j = 0; j < nomes.size(); j++) {
            System.out.print(nomes.get(j) + " |");
        }
        System.out.println();

        for (int i = 0; i < datas.size(); i++) {
            System.out.print(datas.get(i)+"|");

            for (int z = 0; z < valores.size(); z++) {
                System.out.print(valores.get(z)+"|");
            }
            System.out.println();
        }
        System.out.println();
    }

}
