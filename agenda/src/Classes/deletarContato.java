/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DBConexao.Conexao;
import joao5472_luiz5463.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaoz
 */
public class deletarContato {
    private String parametro;

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
    
    public boolean Deletar (){
        boolean Valida = false;
        Conexao con;
        try
        {
            con = new Conexao();
            con.Conectar();
            con.Executar("delete from tb_contato where nm_contato = '"+parametro+"';");
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NullPointerException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Valida;
    }
    
    public boolean ValiDel (){
        boolean Valida = false;
        Conexao con;
        try
        {
            con = new Conexao();
            con.Conectar();
            ResultSet Registros = con.Consultar("select nm_contato from tb_contato");
            while(Registros.next())
            {
                String n = Registros.getString("nm_contato");
                if(parametro.equals(n))
                {
                    Valida = true;
                    break;
                }
            }
        }
        catch(ClassNotFoundException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(NullPointerException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Valida;
    }
}
