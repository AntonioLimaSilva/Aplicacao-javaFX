package br.com.luciano.javafx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.luciano.javafx.factory.ConnectionFactory;
import br.com.luciano.javafx.model.Pessoa;

/**
 * 
 * @author Luciano Lima
 *
 */
public class PessoaDAO {
	
	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	
	public int salvar(Pessoa pessoa) {
		String sql = "INSERT INTO pessoa (nome, email) VALUES (?, ?)";
		try {
			this.stmt = this.connection.prepareStatement(sql);
			this.stmt.setString(1, pessoa.getNome());
			this.stmt.setString(2, pessoa.getEmail());
			return this.stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			fechar();
		}
	}

	public void fechar() {
		try {
			if(this.connection != null) {
				this.connection.close();
			}
			if(this.stmt != null) {
				this.stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
