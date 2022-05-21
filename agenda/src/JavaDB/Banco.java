/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaDB;

import DBConexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class Banco {
    public static void main(String[] args) {
        
        Conexao con;
        
        try
        {
            con = new Conexao();
            con.Conectar();
            
            System.out.println(con.getConexaoBanco().getCatalog());
            System.out.println(con.getConexaoBanco());
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NullPointerException ex)
        {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
