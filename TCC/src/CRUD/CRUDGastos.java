package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;

public class CRUDGastos {

	Conexao con = new Conexao();
	ResultSet dados = null;
	
	public boolean insertGastos() {
		String sql = "INSERT INTO gastos (id_gasto,data,descricao,valor_total,nota_fiscal) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
