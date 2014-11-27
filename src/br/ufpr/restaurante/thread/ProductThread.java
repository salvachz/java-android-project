package br.ufpr.restaurante.thread;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import br.ufpr.restaurante.WebService;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import br.ufpr.restaurante.model.*;

public class ProductThread extends Thread{
			private String filter;
			private Handler handler;
			
			public ProductThread (String filter, Handler handler){
				this.filter = filter;
				this.handler = handler;
			}
			
			public void run(){
				Log.e("ha","chamou ProductThread");
				WebService ws = new WebService("http://salvachz.com.br/restaurante/");
				Map params = new HashMap(); 
				if(!this.filter.equals(""))
					params.put("filter", this.filter);
				String result = ws.webGet("produtos.php", params);
				try{
					JSONObject json = new JSONObject(result);
					Bundle bundle = new Bundle();
					List<Produto> listProduct = new ArrayList<Produto>();
					
					bundle.putBoolean("status", json.getBoolean("status"));
					JSONArray products = json.getJSONArray("produtos");
					
					for (int i=0; i<products.length(); i++) {
						JSONObject product = products.getJSONObject(i);
						Integer id = product.getInt("proId");
						String nome = product.getString("proName");
						Double preco = product.getDouble("proValue");
						String imgResource = product.getString("imgResource");
						listProduct.add( new Produto(id, nome, preco, imgResource, 0));
					}
					
					bundle.putSerializable("products", (Serializable) listProduct);
					Message msg = new Message();
					msg.setData(bundle);
					this.handler.sendMessage(msg);
				}catch (org.json.JSONException e) {
					Log.e("ha","catch JSONObject");
					e.printStackTrace();
				}
			}
		}