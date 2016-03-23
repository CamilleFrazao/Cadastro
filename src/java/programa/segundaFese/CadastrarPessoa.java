/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa.segundaFese;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camille
 */
@WebServlet(urlPatterns = "/cadastro")
public class CadastrarPessoa extends HttpServlet {
    
    Pessoa pessoa;
    
    List<Pessoa> pessoas = new ArrayList<>();
    
    File banco = new File("C:\\Users\\Camille\\Documents\\NetBeansProjects\\Cadastro\\src\\java\\banco\\banco");
    
    FileReader converteParaBufferedLer;
    
    BufferedReader ler;
    
    FileWriter bandoEscrever;
    
    BufferedWriter escrever;
    
    Data date = new Data();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        pessoa = new Pessoa();
        
        bandoEscrever = new FileWriter(banco, true);
        
        escrever = new BufferedWriter(bandoEscrever);
        
        escrever.newLine();
        
        pessoa.setRg(req.getParameter("cadPesRg"));
        
        System.out.println("rg: "+pessoa.getRg());
        
        pessoa.setNome(req.getParameter("cadPesNome"));
        
        pessoa.setCpf(req.getParameter("cadPesCpf"));
        
//        String data = req.getParameter("cadPesNas");
        
        pessoa.setNascimento(req.getParameter("cadPesNas"));
        
        pessoa.setEndereco(req.getParameter("cadPesEnd"));
        
        String linha = pessoa.getRg()
                + ";" + pessoa.getNome()
                + ";" + pessoa.getCpf()+";"
                +pessoa.getNascimento()+ ";" 
                + pessoa.getEndereco();
        
        System.out.println(linha);
        
        escrever.write(linha);
        
        escrever.newLine();
        
        pessoas.add(pessoa);
        
        escrever.close();
        
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        converteParaBufferedLer = new FileReader(banco);
        
        ler = new BufferedReader(converteParaBufferedLer);
        
        pessoas = new ArrayList<>();
        
        while(ler.ready()){
            
            String linha = ler.readLine();
            
            String dados[] = linha.split(";");
            
            pessoa.setRg(dados[0]);
            pessoa.setNome(dados[1]);
            pessoa.setCpf(dados[2]);
            pessoa.setEndereco(dados[3]);
            pessoa.setNascimento(dados[4]);
            
            pessoas.add(pessoa);
            
            
        }
                
        req.setAttribute("pessoas", pessoas);
        
        RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
        
    }
    
}
