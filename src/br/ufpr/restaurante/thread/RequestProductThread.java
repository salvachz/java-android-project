package br.ufpr.restaurante.thread;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import br.ufpr.restaurante.WebService;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class RequestProductThread extends Thread{
			private Integer user;
			private Integer product_id;
			private Integer count;
			private Handler handler;
			
			public RequestProductThread (Integer user_id, Integer product_id, Integer count, Handler handler){
				this.user = user_id;
				this.product_id = product_id;
				this.count = count;
				this.handler = handler;
			}
			
			public void run(){
				Log.i("ha","chamou requestProduct");
				WebService ws = new WebService("http://salvachz.com.br/restaurante/");
				Log.i("ha","vai montar parametros");
				List<NameValuePair> params = new ArrayList<NameValuePair>(); 
				Log.i("ha","criou variavel");
				params.add(new BasicNameValuePair("user", this.user.toString()));
				params.add(new BasicNameValuePair("product", this.product_id.toString()));
				params.add(new BasicNameValuePair("count", this.count.toString()));
				
				Log.i("ha","vai fazer o POST");
				
				ws.doPost("pedidos.php", params);
				
				Log.i("ha","fez o POST o/");
				Bundle bundle = new Bundle();
				bundle.putInt("user", user);
				Log.i("ha","fechou requestProduct com sucesso");
				Message msg = new Message();
				msg.setData(bundle);
				this.handler.sendMessage(msg);
			}
		}