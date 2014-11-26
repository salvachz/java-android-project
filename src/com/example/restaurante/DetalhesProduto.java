package com.example.restaurante;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalhesProduto extends Activity implements OnClickListener {
	
	Produto produto;
	TextView txtMarca;
	EditText qtd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_produto);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		Bundle extras = getIntent().getExtras();
		getMenuInflater().inflate(R.menu.detalhes_produto, menu);
		ImageView imageView = (ImageView) findViewById(R.id.img);
		TextView txtNome = (TextView) findViewById(R.id.nome);
		TextView txtPreco = (TextView) findViewById(R.id.preco);
		
		//txtTitle.setText(carros[position].getModelo());
		Intent it = getIntent();
		Bundle params = it.getExtras();
		produto = (Produto) params.get("produto");
		
		
		txtNome.setText("Nome: " + produto.getNome());
		txtPreco.setText("Preço: R$ " + produto.getPreco());
		imageView.setImageResource(produto.getImg());
		
		return true;
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		//qtd = (EditText) findViewById(R.id.qtd);
		//String quantidade = String.valueOf(qtd.getText());
		//String id = String.valueOf(produto.getId());
		// Guardar no banco!
		Intent i = null;
		i = new Intent(this, MenuPrincipal.class);
		startActivity(i);
	}
}
