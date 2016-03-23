/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa.segundaFese;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camille
 */
public class Data {

    public Date stringParaDate(String data) {

        SimpleDateFormat x = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();

        try {
            System.out.println("dataaaaaa " + data);
            d = x.parse(data);

//        pessoa.setNascimento((Date) req.getParameter("cadPesNas"));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return d;

    }

}
