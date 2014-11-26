package com.example.restaurante;

import java.io.Serializable;

public class Produto implements Serializable {
	private String nome;
	private double preco;
	private Integer img;
	private int id, qtd;
	public Produto(String nome, double preco, Integer img, int id, int qtd) {
		setNome(nome);
		setPreco(preco);
		setImg(img);
		setId(id);
		setQtd(qtd);
	}
	public int getQtd() {
		return this.qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Integer getImg() {
		return img;
	}
	public void setImg(Integer img) {
		this.img = img;
	}
}