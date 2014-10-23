package com.example.minsbaseballgame;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class Start extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		ImageView button2 = (ImageView) findViewById(R.id.imageView1);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Stage1.class);
                startActivity(intent);
			}
		});

		ImageView button3 = (ImageView) findViewById(R.id.imageView2);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Stage2.class);
                startActivity(intent);
			}
		});
		ImageView button4 = (ImageView) findViewById(R.id.imageView5);
		button4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Stage3.class);
                startActivity(intent);
			}
		});
	}

		


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
		return true;
	}

}
