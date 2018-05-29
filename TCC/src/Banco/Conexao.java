package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private String ip = "189.91.101.54";
	private String porta = "3306";
	private String usuario = "senai";
	private String senha = "senai";
	private String nomeBanco = "tcc-sig";
	
	public Connection getConexao() {
		 Connection conexao = null;
		 String url = "jdbc:mysql://"+ip+":"+porta+"/"+nomeBanco;
		 try {
			conexao = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Conectado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erro ao conectar com o banco de dados!");
		}
		 return conexao;
	}
}
