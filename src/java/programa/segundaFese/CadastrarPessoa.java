/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa.segundaFese;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    List<String> pessoas = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        pessoa = new Pessoa();

        pessoa.setNome(req.getParameter("cadPesNome"));
        pessoa.setRg(req.getParameter("cadPesRg"));

        String data = req.getParameter("cadPesNas");

        SimpleDateFormat x = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();

        try {
            d = x.parse(data);

//        pessoa.setNascimento((Date) req.getParameter("cadPesNas"));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

        pessoa.setNascimento(d);
        pessoa.setEndereco(req.getParameter("cadPesEnd"));

        String linha = pessoa.getRg() + ";" + pessoa.getNome() + ";" + pessoa.getCpf()
                + ";" + pessoa.getEndereco() + ";" + pessoa.getNascimento();

        pessoas.add(linha);

    }
}
