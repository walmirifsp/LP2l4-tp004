/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 walmir santos feitoza junior 	
 aramis nogueira
 */
import java.sql.*;
import java.util.List;
public class Conexao
{
    static List<Funcionario> func;
public static void main(String args[])
{
    
 //Conexao c = new Conexao();
 //c.insert(1, "", 1.1, 1);
}

public void insert(int id, String nome, double valor, int peso)
{
try
{
String url = "jdbc:sqlserver://187.60.29.29\\SQLEXPRESS;databaseName=AulaJava;integratedSecurity=true";
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con;
con = DriverManager.getConnection(url);
Statement st = con.createStatement();
String x = "Insert into tb_prods (cd_prod, ds´prod, vl_prod, qt_pesoprod) values(" + id + ", '"+nome+"', "+valor+", "+peso+")";
st.executeUpdate(x);
con.close();
}
catch (Exception e)
{
System.out.println("Erro: " + e.getMessage());
}

}
public List<Funcionario> select(String nome)
{
try
{
String url = "jdbc:sqlserver://187.60.29.29\\SQLEXPRESS;databaseName=AulaJava;integratedSecurity=true";
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
Connection con;
con = DriverManager.getConnection(url);
Statement st = con.createStatement();
ResultSet rs;
rs = st.executeQuery("Select cod_func, nome_func, sal_func, ds_cargo from tbfuncs INNER JOIN tbcargos ON tbfuncs.cod_cargo = tbcargos.cd_cargo where nome_func like '"+ nome +"'");
mostraRS(rs);
con.close();


}
catch (Exception e)
{
System.out.println("Erro: " + e.getMessage());
}
return func;
}

private static void mostraRS(ResultSet rs) throws SQLException
{

int i;
ResultSetMetaData rsmd = rs.getMetaData();
int numcols = rsmd.getColumnCount();

while (rs.next())
{
    func.add(new Funcionario(rs.getInt(0),rs.getString(1),rs.getDouble(2),rs.getString(3)));
}
}
}





