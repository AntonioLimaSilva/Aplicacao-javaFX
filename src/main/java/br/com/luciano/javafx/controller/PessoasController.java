package br.com.luciano.javafx.controller;

import br.com.luciano.javafx.dao.PessoaDAO;
import br.com.luciano.javafx.model.Pessoa;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * 
 * @author Luciano Lima
 *
 */
public class PessoasController {
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private Button btnSalvar;
	
	@FXML
	private Button btnLimpar;
	
	private Pessoa pessoa;
	
	/**
	 * Esse método é invovado toda vez que esse controller for incializado, isso é feito automaticamente pelo javaFX
	 */
	public void initialize() {
		this.pessoa = new Pessoa();
		
		this.txtNome.textProperty().bindBidirectional(this.pessoa.nomeProperty());
		this.txtEmail.textProperty().bindBidirectional(this.pessoa.emailProperty());
		
		//Valida si os campos estão vazios, caso estejam o botão salvar fica desabilitado
		this.btnSalvar.disableProperty().bind(this.pessoa.nomeProperty().isEmpty().or(this.pessoa.emailProperty().isEmpty()));
	}

	@FXML
	public void salvar() {
		this.pessoa.adicionar(this.txtNome, this.txtEmail);

		PessoaDAO pessoaDAO = new PessoaDAO();
		int count = pessoaDAO.salvar(pessoa);
		
		mensagem(count);
	}
	
	@FXML
	public void limpar() {
		this.pessoa.clear();
	}
	
	private void mensagem(int count) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmação!");
		alert.setHeaderText("Pessoa salva com sucesso: " + count);
		alert.setContentText(pessoa.toString());
		alert.showAndWait();
	}
}
