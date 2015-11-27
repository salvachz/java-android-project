package br.ufpr.restaurante.thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import br.ufpr.restaurante.WebService;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


public class ConfirmeFinalizeThread extends Thread{
			private String user;
			private String passwd;
			private String payment;
			private Handler handler;
			public ConfirmeFinalizeThread (String user, String payment, Handler handler){
				this.user = user;
				this.passwd = passwd;
				this.payment = payment;
				this.handler = handler;
			}
			
			public void run(){
				Log.i("ha","run in LoginThread");
				WebService ws = new WebService("http://salvachz.com.br/restaurante/");
				List<NameValuePair> params = new ArrayList<NameValuePair>(); 
				Log.i("ha","criou variavel, user id eh "+user.toString());
				params.add(new BasicNameValuePair("user", this.user.toString()));
				params.add(new BasicNameValuePair("payment", this.payment));
				Log.i("ha","doing webGet");
				String result = ws.doPost("finalizar.php",params);
				Log.i("ha","done webGet");
				Bundle bundle = new Bundle();
				bundle.putString("user", this.user);
				Message msg = new Message();
				msg.setData(bundle);
				this.handler.sendMessage(msg);
			}
		}