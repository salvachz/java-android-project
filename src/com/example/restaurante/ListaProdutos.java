package com.example.restaurante;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaProdutos extends Activity {
	
	List<Produto> prod; 
	ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        Bundle extras = getIntent().getExtras();
        prod = (List<Produto>) extras.get("prod");
		ListCell adapter = new ListCell(ListaProdutos.this, prod);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        //a = new Intent(this, DetailsActivity.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,	int arg2, long arg3) {
				//Toast.makeText(MainActivity.this, "Clicou na " + listaCarros[+arg2].getModelo(), Toast.LENGTH_SHORT).show();
				//a.putExtra("modelo", listaCarros[+arg2].getModelo());
				//a.putExtra("img", listaCarros[+arg2].getImg());
				//a.putExtra("marcaCarro", listaCarros[+arg2].getMarca());
				//a.putExtra("preco", listaCarros[+arg2].getPreco());
				//a.putExtra("cor", listaCarros[+arg2].getCor());
				//a.putSerializable("carro", listaCarros[+arg2]);
				//startActivity(a);
				//Intent it = new Intent(getBaseContext(), DetailsActivity.class);
				//Bundle params = new Bundle();
				//params.putSerializable("carro", listaCarros[arg2]);
				//it.putExtras(params);
				//startActivity(it);
				Intent it = new Intent(getBaseContext(), DetalhesProduto.class);
        		Bundle params = new Bundle();
        		params.putSerializable("produto", prod.get(arg2));
        		it.putExtras(params);
        		startActivity(it);
			}
        	
        });
	}

}












