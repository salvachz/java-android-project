package br.ufpr.restaurante;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.restaurante.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.ufpr.restaurante.model.*;


public class CellPedido extends ArrayAdapter<Produto> {
	private final Activity context;
	private final List<Produto> prod;
	
	public CellPedido(Activity context, List<Produto> prod) {
		super(context, R.layout.activity_cell_pedido, prod);
		this.context = context;
		this.prod = prod;
	}
	
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.activity_cell_pedido,  null, true);
		
		TextView txtNome= (TextView) rowView.findViewById(R.id.nome);
		//ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		TextView txtPrecoUnit = (TextView) rowView.findViewById(R.id.precoUnit);
		TextView txtQtd = (TextView) rowView.findViewById(R.id.qtd_b);
		
		
		txtNome.setText(prod.get(position).getNome());
		//ImageLoader imageLoader = ImageLoader.getInstance();
		//imageLoader.displayImage(prod.get(position).getImageResource(), imageView);
		txtPrecoUnit.setText("R$ " + prod.get(position).getPreco());
		txtQtd.setText("Quantidade: " + String.valueOf(prod.get(position).getQtd()));
		
		
		/*try {
			URL url = new URL("http://files.softicons.com/download/social-media-icons/circle-social-icons-by-anli-zaimi/png/50x50/google.png");
			Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
			imageView.setImageBitmap(bmp);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		//new ImageDownloader(imageView).execute("http://files.softicons.com/download/social-media-icons/circle-social-icons-by-anli-zaimi/png/50x50/google.png");
		
		//imageView.setImageAlpha(prod.get(position).getImageResource());
		/*try {
	        URL url = new URL(prod.get(position).getImageResource());
	        //try this url = "http://0.tqn.com/d/webclipart/1/0/5/l/4/floral-icon-5.jpg"
	        HttpGet httpRequest = null;

	        httpRequest = new HttpGet(url.toURI());

	        HttpClient httpclient = new DefaultHttpClient();
	        HttpResponse response = (HttpResponse) httpclient
	                .execute(httpRequest);

	        HttpEntity entity = response.getEntity();
	        BufferedHttpEntity b_entity = new BufferedHttpEntity(entity);
	        InputStream input = b_entity.getContent();

	        Bitmap bitmap = BitmapFactory.decodeStream(input);

	        imageView.setImageBitmap(bitmap);

	    } catch (Exception ex) {

	    }*/
		
		
		return rowView;
	}

}
