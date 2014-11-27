package br.ufpr.restaurante.model;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class Produto implements Serializable {
	private String nome;
	private double preco;
	private Integer id, qtd;
	private String imgResource;
	
	public Produto(Integer id, String nome, double preco,String imgResource, int qtd) {
		setId(id);
		setNome(nome);
		setPreco(preco);
		loadImage(imgResource);
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
	
	public String getImageResource(){
		return this.imgResource;
	}
	
	private void loadImage(String resource) {
	    this.imgResource = resource;
	}
}