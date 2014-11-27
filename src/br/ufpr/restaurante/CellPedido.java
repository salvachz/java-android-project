package br.ufpr.restaurante;


import java.util.List;

import com.example.restaurante.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import android.app.Activity;
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
		super(context, R.layout.activity_list_cell, prod);
		this.context = context;
		this.prod = prod;
	}
	
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.activity_cell_pedido,  null, true);
		double total = prod.get(position).getPreco() * prod.get(position).getQtd();
		
		TextView txtNome= (TextView) rowView.findViewById(R.id.nome);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		TextView txtPrecoUnit = (TextView) rowView.findViewById(R.id.precoUnit);
		TextView txtQtd = (TextView) rowView.findViewById(R.id.qtd);
		TextView txtPrecoTot = (TextView) rowView.findViewById(R.id.precoTot);
		
		txtNome.setText(prod.get(position).getNome());
		ImageLoader imageLoader = ImageLoader.getInstance();
		//imageLoader.displayImage(prod.get(position).getImageResource(), imageView);
		txtPrecoUnit.setText("R$ " + prod.get(position).getPreco());
		txtQtd.setText("R$ " + prod.get(position).getQtd());
		txtPrecoTot.setText("R$ " + total);
		
		return rowView;
	}

}
