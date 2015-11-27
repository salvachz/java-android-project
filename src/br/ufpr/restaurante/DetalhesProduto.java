package br.ufpr.restaurante;

import com.example.restaurante.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import br.ufpr.restaurante.model.*;
import br.ufpr.restaurante.thread.ProductThread;
import br.ufpr.restaurante.thread.RequestProductThread;
public class DetalhesProduto extends Activity implements OnClickListener {
	
	Produto produto;
	TextView txtMarca;
	EditText qtd;
	private Integer user;
	private Handler handlerRequestedProduct = new Handler(){
		public void handleMessage(Message msg){
			Log.i("ha","veio para handler de sucesso de pedido");
    		Bundle bundle = msg.getData();
    		Intent it = new Intent(DetalhesProduto.this, MenuPrincipal.class);
    		it.putExtras(bundle);
    		startActivity(it);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhes_produto);
		 Bundle extras = getIntent().getExtras();
		 this.user = extras.getInt("user");
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
		//ImageLoader imageLoader = ImageLoader.getInstance();
		//imageLoader.displayImage(produto.getImageResource(), imageView);
		
		return true;
	}

	public void onClick(View view) {
		Log.i("ha", "on click");
		// TODO Auto-generated method stub
		qtd = (EditText) findViewById(R.id.fieldQtd);
		
		Integer quantidade = Integer.parseInt(qtd.getText().toString());
		Log.i("ha", "quantidade vai!ela vale:"+quantidade);
		Integer product_id = produto.getId();
		
		Log.i("ha", "um ponto antes da thread");
		
		RequestProductThread requestProductThread = new RequestProductThread(
				this.user, product_id, quantidade, handlerRequestedProduct);
        requestProductThread.start();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		// TODO Auto-generated method stub
		
	}
}