package com.sistema.androidexamples35aplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;

public class Aplicacion extends Application {
	
	private List<String> datos;
	@Override
	public void onCreate() {
		super.onCreate();
		datos=new ArrayList<String>();
		cargaDatos();
	}
	private void cargaDatos() {
		for(int i=0;i<10;i++){
			datos.add(new String("datos"+i));
		}
	}
	public List<String> getDatos() {
		return datos;
	}
	
	public String get(int position){
		return datos.get(position);
	}
	
	public String add(String s){
		datos.add(s);
		return s;
	}
	
	public String set(int position,String s){
		datos.set(position, s);
		return s;
	}
	
	public String remove (String s){
		datos.remove(s);
		return s;
	}

}
