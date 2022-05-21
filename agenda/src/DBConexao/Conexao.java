package DBConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Anderson
 */
public class Conexao {
    
    private Connection conexaoBanco;
    private Statement ponteStatement;
    private ResultSet colecaoRegistros;
    private String driverBanco;
    private String server;
    private String port;
    private String database;
    private String user;
    private String password;

    public Connection getConexaoBanco() {
        return conexaoBanco;
    }

    public void setConexaoBanco(Connection conexaoBanco) {
        this.conexaoBanco = conexaoBanco;
    }

    public Statement getPonteStatement() {
        return ponteStatement;
    }

    public void setPonteStatement(Statement ponteStatement) {
        this.ponteStatement = ponteStatement;
    }

    public ResultSet getColecaoRegistros() {
        return colecaoRegistros;
    }

    public void setColecaoRegistros(ResultSet colecaoRegistros) {
        this.colecaoRegistros = colecaoRegistros;
    }

    public String getDriverBanco() {
        return driverBanco;
    }

    public void setDriverBanco(String driverBanco) {
        this.driverBanco = driverBanco;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Conexao() throws ClassNotFoundException {
        driverBanco = "com.mysql.jdbc.Driver";
        server = "127.0.0.1";
        port = "3306";
        database = "db_agenda";
        user = "root";
        password = "root";
        Class.forName(driverBanco);
    }
    
    public void Conectar() throws SQLException{
        conexaoBanco = (Connection) DriverManager.getConnection(
                "jdbc:MySQL://" + server + ":" + port
                + "/" + database + "?user=" + user
                + "&password=" + password);
    }
    
    public void Executar(String textoSQL) throws SQLException{
       System.out.println("Estou dentro do método Executar da Classe Conexão");
       System.out.println(textoSQL);
       ponteStatement = (Statement) conexaoBanco.createStatement();
       ponteStatement.executeUpdate(textoSQL);
    }
    
    public ResultSet Consultar(String textoSQL) throws SQLException{
        System.out.println(textoSQL);
        ponteStatement = (Statement) conexaoBanco.createStatement();
        colecaoRegistros = ponteStatement.executeQuery(textoSQL);
        return colecaoRegistros;
    }
}
