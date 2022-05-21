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
public class Agenda {
    private String nome;

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public String TipoContato ()
    {
        String tipoContato = "";
        Conexao con;
        try
        {
            con = new Conexao();
            con.Conectar();
            ResultSet Registros = con.Consultar("select ic_tipoTel from tb_contato where nm_contato = '"+nome+"';");
            while(Registros.next())
            {
                String t = Registros.getString("ic_tipoTel");
                tipoContato = t;
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
        
        return tipoContato;
    }
}
