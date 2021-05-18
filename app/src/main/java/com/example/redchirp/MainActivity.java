package com.example.redchirp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain2Activity();

            }


        });
    }

    private void openMain2Activity() {
        Intent intent= new Intent(this,Main2Activity.class);
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("Text/Plain");
                String shareBody= "Link Here";
                String shareSubjet="Subjet Here";

                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareBody);

                sharingIntent.putExtra(Intent.EXTRA_TEXT,shareSubjet);
                startActivity(Intent.createChooser(sharingIntent,"share use"));
              break;

        }
        return super.onOptionsItemSelected(item);
    }
}



