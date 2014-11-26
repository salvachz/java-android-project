package com.example.restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MenuPrincipal extends Activity implements OnClickListener {	
	
	TextView teste;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.btnPedido:
				List<Produto> prod = new ArrayList<Produto>();
				prod.add(new Produto("Arroz", 5.50, R.drawable.logo, 1, 1));
				prod.add(new Produto("Feijão", 4.50, R.drawable.logo, 2, 1));
				prod.add(new Produto("Batata Frita", 8.00, R.drawable.logo, 3, 1));
				prod.add(new Produto("Alface", 1.50, R.drawable.logo, 4, 1));
				prod.add(new Produto("Ketchup", 0.50, R.drawable.logo, 5, 1));
				prod.add(new Produto("Bacon", 3.50, R.drawable.logo, 6, 1));
				Intent i = null;
				i = new Intent(this, ListaProdutos.class); 
				Bundle params = new Bundle();
        		params.putSerializable("prod", (Serializable) prod);
        		i.putExtras(params);
				startActivity(i);
				break;
			case R.id.btnPagar:
				List<Produto> pedido = new ArrayList<Produto>();
				pedido.add(new Produto("Arroz", 5.50, R.drawable.logo, 1, 3));
				pedido.add(new Produto("Feijão", 4.50, R.drawable.logo, 2, 1));
				pedido.add(new Produto("Batata Frita", 8.00, R.drawable.logo, 3, 5));
				pedido.add(new Produto("Alface", 1.50, R.drawable.logo, 4, 2));
				pedido.add(new Produto("Ketchup", 0.50, R.drawable.logo, 5, 1));
				pedido.add(new Produto("Bacon", 3.50, R.drawable.logo, 6, 2));
				Intent intent = null;
				intent = new Intent(this, ListaPedido.class); 
				Bundle bundle = new Bundle();
				bundle.putSerializable("pedido", (Serializable) pedido);
				intent.putExtras(bundle);
				startActivity(intent);
				break;
		}
	}
}