package com.example.restaurante;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONException;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity implements OnClickListener {
	
	private Button btnEntrar;
	private EditText login;
	private EditText senha;
	private TextView teste;
	private Handler handlerLogin = new Handler(){
    	
    	public void handleMessage(Message msg){
    		Bundle bundle = msg.getData();
    		Boolean status = bundle.getBoolean("status");
    		if(status){
    			Intent it = new Intent(MainActivity.this, MenuPrincipal.class);
    			startActivity(it);
    		}else
    			Toast.makeText(MainActivity.this, "usuario/senha nao encontrados", Toast.LENGTH_LONG).show();
    	}
	};
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
	    btnEntrar = (Button) findViewById(R.id.btnEntrar);
	    btnEntrar.setOnClickListener(this);
    }
    
    
	@Override
	public void onClick(View view) {
		Bundle bundle = new Bundle();
		login = (EditText) findViewById(R.id.loginBox);
		senha = (EditText) findViewById(R.id.pwdBox);
		LoginThread loginThread = new LoginThread(login.getText().toString(),
				senha.getText().toString(),
				handlerLogin);
		loginThread.start();
	}
}
	