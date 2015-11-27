package br.ufpr.restaurante;

import java.io.Serializable;
import java.util.ArrayList;
import br.ufpr.restaurante.model.*;
import br.ufpr.restaurante.thread.ConfirmeFinalizeThread;
import br.ufpr.restaurante.thread.LoginThread;

import java.util.List;

import com.example.restaurante.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ListaPedidos extends Activity {
	
	List<Produto> prod; 
	ListView list;
	private Integer user;
	private Handler handlerFim = new Handler(){
		public void handleMessage(Message msg){
			Log.i("ha","veio para handler de sucesso de pedido");
    		Bundle bundle = msg.getData();
    		Intent it = new Intent(ListaPedidos.this, MenuPrincipal.class);
    		it.putExtras(bundle);
    		startActivity(it);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pedidos);
        Bundle extras = getIntent().getExtras();
        prod = (List<Produto>) extras.get("product");
        this.user = extras.getInt("user");
        Log.i("ha","onCreate ListaProdutos hehe");
        
//        // UNIVERSAL IMAGE LOADER SETUP
// 		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
// 				.cacheOnDisc(true).cacheInMemory(true)
// 				.imageScaleType(ImageScaleType.EXACTLY)
// 				.displayer(new FadeInBitmapDisplayer(300)).build();
//
// 		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getBaseContext())
// 				.defaultDisplayImageOptions(defaultOptions)
// 				.memoryCache(new WeakMemoryCache())
// 				.discCacheSize(100 * 1024 * 1024).build();
//
// 		ImageLoader.getInstance().init(config);
// 		// END - UNIVERSAL IMAGE LOADER SETUP
 		
		CellPedido adapter = new CellPedido(ListaPedidos.this, prod);
		Log.i("ha","fez list cell");
        list = (ListView) findViewById(R.id.list_pedidos);
        Log.i("ha","montando adapter");
        list.setAdapter(adapter);
        Log.i("ha","setted adapter here");
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,	int arg2, long arg3) {
/*				Intent it = new Intent(getBaseContext(), DetalhesProduto.class);
        		Bundle params = new Bundle();
        		params.putSerializable("produto", prod.get(arg2));
        		params.putInt("user", ListaPedidos.this.user);
        		it.putExtras(params);
        		startActivity(it);*/
			}
        	
        });
	}
	
	public void onClick(View view) {
		Intent it;
		Bundle params = new Bundle();
		ConfirmeFinalizeThread comfirmeFinalize;
		switch(view.getId()) {
		case R.id.btn_dinheiro:		
			comfirmeFinalize = new ConfirmeFinalizeThread(
			this.user.toString(),
			"dinheiro",
			handlerFim);
			comfirmeFinalize.start();
			break;
			
		case R.id.btn_credito:		
			comfirmeFinalize = new ConfirmeFinalizeThread(
			this.user.toString(),
			"credito",
			handlerFim);
			comfirmeFinalize.start();
			break;
			
		case R.id.btn_debito:		
			comfirmeFinalize = new ConfirmeFinalizeThread(
			this.user.toString(),
			"debito",
			handlerFim);
			comfirmeFinalize.start();
			break;
		}
	}
}












