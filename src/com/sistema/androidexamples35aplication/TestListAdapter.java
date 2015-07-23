package com.sistema.androidexamples35aplication;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TestListAdapter extends BaseAdapter {
	
	private List<String> listado;
	private Context context;
	private int vista;

	public TestListAdapter(Context context, 
						int vista,
						List<String> listado) {
		this.listado=listado;
		this.vista=vista;
		this.context = context;
	}

	public int getCount() {
		return listado.size();
	}

	public String getItem(int position) {
		if(null == listado){
			return null;
		}else{
			return listado.get(position);
		}
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, 
			ViewGroup parent) {
		//Log.d("getview",""+position);
		TextView tli;
		if (null == convertView) {
			tli = (TextView)View.inflate(context, 
					vista, null);
		} else {
			tli = (TextView)convertView;
		}
		tli.setText(listado.get(position));
		Log.d("Presentando", ""+position);		
		return tli;
	}

	public void forceReload() {
		notifyDataSetChanged();
	}
	

}
