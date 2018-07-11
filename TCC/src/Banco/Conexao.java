package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection conexao = null;
	
	public static Connection getConexao() {
		String ip = "189.91.101.54";
		String porta = "3306";
		String usuario = "senai";
		String senha = "senai";
		String nomeBanco = "tcc-sig";
		
		String url = "jdbc:mysql://"+ip+":"+porta+"/"+nomeBanco;
		try {
			conexao = DriverManager.getConnection(url,usuario,senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao conectar com o banco de dados!");
		}
		 return conexao;
	}
}
