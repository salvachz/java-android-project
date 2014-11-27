package br.ufpr.restaurante;

//import com.example.listacar.R;

import java.util.List;
import br.ufpr.restaurante.model.*;

import com.example.restaurante.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListCell extends ArrayAdapter<Produto> {
	private final Activity context;
	private final List<Produto> prod;
	private ImageLoader imageLoader;
	
	public ListCell(Activity context, List<Produto> prod, ImageLoader imageLoader) {
		super(context, R.layout.activity_list_cell, prod);
		this.context = context;
		this.prod = prod;
		this.imageLoader = imageLoader;
	}
	
	public View getView(int position, View view, ViewGroup parent) {
		Log.i("ha"," chegou aqui na getView");
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.activity_list_cell,  null, true);
		TextView txtNome= (TextView) rowView.findViewById(R.id.nome);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		TextView txtPreco = (TextView) rowView.findViewById(R.id.preco);
		txtNome.setText(prod.get(position).getNome());
		//this.imageLoader.displayImage(prod.get(position).getImageResource(), imageView);
		txtPreco.setText("R$ " + prod.get(position).getPreco());
		return rowView;
	}
}
