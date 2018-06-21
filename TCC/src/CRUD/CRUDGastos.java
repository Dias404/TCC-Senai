package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;

public class CRUDGastos {

	Conexao con = new Conexao();
	public ResultSet dados = null;
	
	public boolean insertGastos(String loja, String data, String descricao, String valorTotal, String notaFiscal) {
		String sql = "INSERT INTO gastos (loja,data,descricao,valor_total,nota_fiscal) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, loja);
			stmt.setString(2, data);
			stmt.setString(3, descricao);
			stmt.setString(4, valorTotal);
			stmt.setString(5, notaFiscal);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectGastos() {
		String sql = "SELECT * FROM gastos ORDER BY loja";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return dados = null;
		}
	}
	
	public ResultSet selectGastosComWhere(String variavelSelect, String valorSelect) {
		String sql = "SELECT * FROM gastos WHERE "+variavelSelect+" LIKE ? ORDER BY loja";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, valorSelect+"%");
			dados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return dados = null;
		}
		
	}
	
}
