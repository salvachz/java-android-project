package com.example.restaurante;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

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
				WebService ws = new WebService("http://salvachz.com.br/restaurante/");
				Map params = new HashMap(); 
				params.put("user", this.user);
				params.put("passwd", this.passwd);
				String result = ws.webGet("login.php", params);
				try{
					JSONObject json = new JSONObject(result);
					Bundle bundle = new Bundle();
					bundle.putBoolean("status", json.getBoolean("status"));
					Message msg = new Message();
					msg.setData(bundle);
					this.handler.sendMessage(msg);
				}catch (org.json.JSONException e) {
					e.printStackTrace();
				}
			}
		}