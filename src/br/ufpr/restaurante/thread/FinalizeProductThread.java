package br.ufpr.restaurante.thread;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import br.ufpr.restaurante.WebService;
import br.ufpr.restaurante.model.Produto;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class FinalizeProductThread extends Thread{
			private String user;
			private Handler handler;
			
			public FinalizeProductThread (String user, Handler handler){
				this.user = user;
				this.handler = handler;
			}
			
			public void run(){
				Log.i("ha","run in LoginThread");
				WebService ws = new WebService("http://salvachz.com.br/restaurante/");
				Map<String,String> params = new HashMap<String,String>(); 
				params.put("user", this.user);
				Log.i("ha","doing webGet");
				String result = ws.webGet("pedidos.php",params);
				Log.i("ha","done webGet");
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
						Integer count = product.getInt("count");
						listProduct.add( new Produto(id, nome, preco, imgResource, count));
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