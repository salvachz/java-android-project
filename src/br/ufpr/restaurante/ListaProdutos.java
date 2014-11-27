package br.ufpr.restaurante;

import java.util.ArrayList;
import br.ufpr.restaurante.model.*;
import java.util.List;

import com.example.restaurante.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

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
	private Integer user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
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
 		
		ListCell adapter = new ListCell(ListaProdutos.this, prod, null);
		Log.i("ha","fez list cell");
        list = (ListView) findViewById(R.id.list_product);
        Log.i("ha","montando adapter");
        list.setAdapter(adapter);
        Log.i("ha","setted adapter here");
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
        		params.putInt("user", ListaProdutos.this.user);
        		it.putExtras(params);
        		startActivity(it);
			}
        	
        });
	}

}












