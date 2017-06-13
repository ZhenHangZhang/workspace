package com.example.zhzlistviewtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts.Data;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private String[] data = {"apple","banana","orange","apple","banana","orange","apple","banana","orange","apple","banana","orange"};
	
	
	private List<Fruit>fruitList = new ArrayList<Fruit>();
 	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initFruit();
		FruitAdapt fruitAdapt = new FruitAdapt(MainActivity.this, R.layout.fruit_item,fruitList);
		
//		ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,data);
		ListView listView = (ListView)findViewById(R.id.list_view);
		listView.setAdapter(fruitAdapt);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
				// TODO Auto-generated method stub
				
				
				Fruit fruit = fruitList.get(position);
				
				
				Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
				
				
			}
		});
		
	}

	private void initFruit() {
		
		
		Fruit apple = new Fruit("apple", R.drawable.icon_cyxhb);
		fruitList.add(apple);
		
		Fruit banana = new Fruit("banana", R.drawable.icon_cyxhb);
		fruitList.add(banana);
		Fruit orange = new Fruit("orange", R.drawable.icon_cyxhb);
		fruitList.add(orange);
		Fruit watet = new Fruit("watet", R.drawable.icon_cyxhb);
		fruitList.add(watet);
		Fruit pear = new Fruit("pear", R.drawable.icon_cyxhb);
		fruitList.add(pear);
		Fruit grape = new Fruit("grape", R.drawable.icon_cyxhb);
		fruitList.add(grape);
		Fruit pine = new Fruit("pine", R.drawable.icon_cyxhb);
		fruitList.add(pine);
		Fruit straw = new Fruit("straw", R.drawable.icon_cyxhb);
		fruitList.add(straw);
		Fruit cherry = new Fruit("cherry", R.drawable.icon_cyxhb);
		fruitList.add(cherry);
		Fruit mango = new Fruit("mango", R.drawable.icon_cyxhb);
		fruitList.add(mango);
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
