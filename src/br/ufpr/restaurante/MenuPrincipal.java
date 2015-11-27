package br.ufpr.restaurante;

import java.io.Serializable;
import br.ufpr.restaurante.model.*;
import br.ufpr.restaurante.thread.FinalizeProductThread;
import br.ufpr.restaurante.thread.LoginThread;
import br.ufpr.restaurante.thread.ProductThread;

import java.util.ArrayList;
import java.util.List;

import com.example.restaurante.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPrincipal extends Activity implements OnClickListener {	
	private List<Produto> product;
	private Integer user;
	
	private Handler handlerGetProducts = new Handler(){
		public void handleMessage(Message msg){
    		Bundle bundle = msg.getData();
    		MenuPrincipal.this.product = (ArrayList<Produto>)bundle.getSerializable("products");
    		Toast.makeText(MenuPrincipal.this, "funcionou", Toast.LENGTH_LONG).show();
		}
	};
	
	private Handler handlerFinalize = new Handler(){
		public void handleMessage(Message msg){
			Intent it = new Intent(MenuPrincipal.this, ListaPedidos.class);
			Bundle params = msg.getData();
			List<Produto> finProd = (List<Produto>) params.getSerializable("products");
			params.putSerializable("product", (Serializable) finProd);
    		params.putInt("user", MenuPrincipal.this.user);
    		it.putExtras(params);
			startActivity(it);
		}
	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if(this.user == null)
        	this.user = Integer.parseInt(extras.getString("user"));
        setContentView(R.layout.activity_menu_principal);
        ProductThread productThread = new ProductThread("" , handlerGetProducts);
        productThread.start();
    }

	@Override
	public void onClick(View view) {
		Intent it;
		Bundle params = new Bundle();
		switch(view.getId()) {
			case R.id.btnPedido:			
				it = new Intent(MenuPrincipal.this, ListaProdutos.class); 
        		params.putSerializable("product", (Serializable) this.product);
        		params.putInt("user", this.user);
        		it.putExtras(params);
				startActivity(it);
				break;
			case R.id.btnPagar: 
				FinalizeProductThread finalizeProductThread = new FinalizeProductThread(this.user.toString() , handlerFinalize);
		        finalizeProductThread.start();
				break;
		}
	}
}