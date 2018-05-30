package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Banco.Conexao;
import DAO.Clientes;

public class CRUDClientes {
	
	Conexao con = new Conexao();
	public ResultSet dadosSelect = null;
	
	public boolean insertClienteFisico(Clientes cliente) {
		try {
			String sql = "INSERT INTO clientes (tipo_de_pessoa,nome_razao,sexo,email,uf,cidade,bairro,rua,numero,cpf_cnpj,rg_ie,mae,pai,estado_civil,tel1,tel2,cel1,cel2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, cliente.getTipoDePessoa());
			stmt.setString(2, cliente.getNomeRazao());
			stmt.setString(3, cliente.getSexo());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getUF());
			stmt.setString(6, cliente.getCidade());
			stmt.setString(7, cliente.getBairro());
			stmt.setString(8, cliente.getRua());
			stmt.setString(9, cliente.getNumero());
			stmt.setString(10, cliente.getCPF_CNPJ());
			stmt.setString(11, cliente.getRG_IE());
			stmt.setString(12, cliente.getMae());
			stmt.setString(13, cliente.getPai());
			stmt.setString(14, cliente.getEstadoCivil());
			stmt.setString(15, cliente.getTel1());
			stmt.setString(16, cliente.getTel2());
			stmt.setString(17, cliente.getCel1());
			stmt.setString(18, cliente.getCel2());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertClienteJuridico(Clientes cliente) {
		try {
			String sql = "INSERT INTO clientes (tipo_de_pessoa,nome_razao,email,uf,cidade,bairro,rua,numero,cpf_cnpj,rg_ie,tel1,tel2,cel1,cel2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			stmt.setString(1, cliente.getTipoDePessoa());
			stmt.setString(2, cliente.getNomeRazao());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getUF());
			stmt.setString(5, cliente.getCidade());
			stmt.setString(6, cliente.getBairro());
			stmt.setString(7, cliente.getRua());
			stmt.setString(8, cliente.getNumero());
			stmt.setString(9, cliente.getCPF_CNPJ());
			stmt.setString(10, cliente.getRG_IE());
			stmt.setString(11, cliente.getTel1());
			stmt.setString(12, cliente.getTel2());
			stmt.setString(13, cliente.getCel1());
			stmt.setString(14, cliente.getCel2());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet selectClientes() {
		String sql = "SELECT * FROM clientes";
		try {
			PreparedStatement stmt = con.getConexao().prepareStatement(sql);
			dadosSelect = stmt.executeQuery();
			stmt.execute();
			stmt.close();
			return dadosSelect;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return dadosSelect = null;
		}
	}
}
