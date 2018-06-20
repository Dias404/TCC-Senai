package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.sun.corba.se.spi.activation.Repository;

import Banco.Conexao;
import DAO.Lojas;
import DAO.Lugar;

public class CRUDLugar {

	static Conexao con = new Conexao();
	public static ResultSet dadosSelect = null;
	
	public static boolean insertCidade(Lugar cidade, int idEstado) {
		try {
			String sql = "INSERT INTO cidades (nome_cidade, id_estado) VALUES (?,?)";
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, cidade.getNomeCidade());
			stmt.setInt(2, idEstado);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar a cidade.");
			return false;
		}
	}
	
	public static ResultSet selectCidadeCondicao1(String nomeCidade, int idEstado) {
		String sql = "SELECT * FROM cidades WHERE nome_cidade = ? AND id_estado = ?";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, nomeCidade);
			stmt.setInt(2, idEstado);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public static ResultSet selectEstados() {
		String sql = "SELECT * FROM estados";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
	
	public static int selectIdEstado(String nomeEstado) {
		ResultSet estados;
		int resposta = 0;
		String sql = "SELECT * FROM estados WHERE nome_estado = ?";
		PreparedStatement stmt;
		try {
			stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, nomeEstado);
			estados = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			
			if(estados.next()) {
				resposta = estados.getInt("id_estado");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposta;
	}
	
}
