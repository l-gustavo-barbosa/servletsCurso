package Modelo;

import java.util.Date;

public class Empresa {
	private Integer id;
	private String nome;
	private Date data = new Date();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setData(Date dataAbertura) {
		this.data = dataAbertura;
	}
	
	public Date getData() {
		return data;
	}

	
}
