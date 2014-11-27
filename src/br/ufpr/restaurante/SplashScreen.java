package br.ufpr.restaurante;

import com.example.restaurante.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
 
public class SplashScreen extends Activity{
    
    private Thread mSplashThread; 
    private boolean mblnClicou = false;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    
        mSplashThread = new Thread() {
            @Override
            public void run() {
             try {
                    synchronized(this){
                        wait(2000);
                        mblnClicou = true;
                    }
                }
                catch(InterruptedException ex){                    
                }
                 
                if (mblnClicou){
                    finish();
                     
                 Intent i = new Intent();
                 i.setClass(SplashScreen.this, MainActivity.class);
                 startActivity(i);
                }
            }
        };
         
        mSplashThread.start();
    }
     
    @Override
    public void onPause()
    {
        super.onPause();
        mSplashThread.interrupt();
    }
     
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
         synchronized(mSplashThread){
          mblnClicou = true;
                mSplashThread.notifyAll();
            }            
        }
        return true;
    }
 
}