package CRUD;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Banco.Conexao;
import DAO.Clientes;

public class CRUDClientes {
	
	Conexao con = new Conexao();
	public Clientes dados = null;
	
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
}
