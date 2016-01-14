package com.example.aditya.imageeffects;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Inter extends Activity {

    ListView listView;
    Bitmap bitmap;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter);

        listView=(ListView)findViewById(R.id.listView);

        String[] effects = new String[] { "greyscale",
                "fish eye",
                "grain",
                "negative",
                "sharpen",
                "sepia",
                "temperature",
                "posterize",
                "lomoish",
                "saturate",
                "vignette",
                "autofix",
                "duotone",
                "cross",
                "blacknwhite",
                "overlay"
        };

        //set adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_view_item, effects);
        listView.setAdapter(adapter);


         i=new Intent(this,MainActivity.class);

        //bitmap=(Bitmap)getIntent().getParcelableExtra("photo"); //bitmap from damle

        // bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.selfie);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {

                 //    i.putExtra("bitmap",bitmap);
                //insert the url here.
                     i.putExtra("choice",position);

                //will start the photo activity
                 startActivity(i);

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
