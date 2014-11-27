package br.ufpr.restaurante.thread;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import br.ufpr.restaurante.WebService;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


public class LoginThread extends Thread{
			private String user;
			private String passwd;
			private Handler handler;
			public LoginThread (String user, String passwd, Handler handler){
				this.user = user;
				this.passwd = passwd;
				this.handler = handler;
			}
			
			public void run(){
				Log.i("ha","run in LoginThread");
				WebService ws = new WebService("http://salvachz.com.br/restaurante/");
				Map<String,String> params = new HashMap<String,String>(); 
				params.put("user", this.user);
				params.put("passwd", this.passwd);
				Log.i("ha","doing webGet");
				String result = ws.webGet("login.php",params);
				Log.i("ha","done webGet");
				try{
					JSONObject json = new JSONObject(result);
					Bundle bundle = new Bundle();
					bundle.putBoolean("status", json.getBoolean("status"));
					bundle.putString("user", json.optString("user",""));
					Message msg = new Message();
					msg.setData(bundle);
					Log.i("ha","run sending message");
					this.handler.sendMessage(msg);
				}catch (org.json.JSONException e) {
					e.printStackTrace();
					Log.e("ha","catch loginThread");
				}
			}
		}