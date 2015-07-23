package com.sistema.androidexamples35aplication;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Mostrar extends AppActivity {

	private Integer id;
	private boolean primera;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mostrar);
		Bundle extras = getIntent().getExtras();
        id = extras.getInt("id");
		tv=(TextView)findViewById(R.id.mostrar_tv);
		tv.setText(app.get(id).toString());
		primera=true;
	}
	public void edit(View v){
		Intent intent=new Intent(this,
						AddEdit.class);
		intent.putExtra("id", id);
		this.startActivity(intent);
	}
	@Override
	public void onResume(){
		super.onResume();
		if(primera==true){
			primera=false;
		}else{
			tv.setText(app.get(id).toString());
		}
	}
	public void delete(View v){
		app.remove(app.get(id));
		Toast.makeText(this, R.string.deleted, Toast.LENGTH_SHORT).show();
		finish();
	}
}
