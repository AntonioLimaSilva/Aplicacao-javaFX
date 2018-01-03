package br.com.luciano.javafx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Pessoa {
	
	private Long id;
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty email = new SimpleStringProperty();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome.get();
	}
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	
	public StringProperty nomeProperty() {
		return nome;
	}

	public StringProperty emailProperty() {
		return email;
	}
	
	public void adicionar(TextField txtNome, TextField txtEmail) {
		this.setNome(txtNome.getText());
		this.setEmail(txtEmail.getText());
	}
	
	public void clear() {
		this.setNome(null);
		this.setEmail(null);
	}
	
	@Override
	public String toString() {
		return String.format("Nome: %s%nEmail: %s%n", getNome(), getEmail());
	}
}
