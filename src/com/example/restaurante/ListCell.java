package com.example.restaurante;

//import com.example.listacar.R;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ListCell extends ArrayAdapter<Produto> {
	private final Activity context;
	private final List<Produto> prod;
	
	public ListCell(Activity context, List<Produto> prod) {
		super(context, R.layout.activity_list_cell, prod);
		this.context = context;
		this.prod = prod;
	}
	
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.activity_list_cell,  null, true);
		TextView txtNome= (TextView) rowView.findViewById(R.id.nome);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		TextView txtPreco = (TextView) rowView.findViewById(R.id.preco);
		txtNome.setText(prod.get(position).getNome());
		imageView.setImageResource(prod.get(position).getImg());
		txtPreco.setText("R$ " + prod.get(position).getPreco());
		return rowView;
	}
}
