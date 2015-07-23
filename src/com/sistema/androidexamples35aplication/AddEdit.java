package com.sistema.androidexamples35aplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddEdit extends AppActivity {

	private EditText editcadena;
	private Integer id;
	private String cadena;
	private boolean edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_edit);
		try{
			Bundle extras = getIntent().getExtras();
	        id = extras.getInt("id");
	        cadena=app.get(id);
	        edit=true;
		}catch(Exception e){
			edit=false;
		}
		setUpviews();
	}

	private void setUpviews() {
		editcadena=(EditText)findViewById(R.id.cadena);
		if(edit==true){
			editcadena.setText(cadena);
		}
	}
	@Override
	public void onBackPressed(){
		this.save(new View(this));
	}
	public void save(View v){
		String s=editcadena.getText().toString();
		if(edit==false){
			app.add(s);
			Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT)
			.show();
		}else{
			app.set(id, s);
			Toast.makeText(this, R.string.modified, Toast.LENGTH_SHORT)
			.show();
		}
			
		finish();
	}
}
