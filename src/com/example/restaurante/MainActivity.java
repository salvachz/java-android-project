package com.example.restaurante;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
		login = (EditText) findViewById(R.id.loginBox);
		senha = (EditText) findViewById(R.id.pwdBox);
				WebService ws = new WebService("http://salvachz.com.br/restaurante/");
				Map params2 = new HashMap(); 
				params2.put("user", "erik");
				params2.put("passwd", "maromba");
				String bla = ws.webGet("login.php", params2);
				//System.out.println(bla);

		String log = String.valueOf(login.getText());
		String pwd = String.valueOf(senha.getText());
		
		// Toast para login incorreto:
		//Intent i = null;
		//i = new Intent(this, MenuPrincipal.class);
		//startActivity(i);
	}
}