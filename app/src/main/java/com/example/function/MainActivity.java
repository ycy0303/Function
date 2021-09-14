package com.example.function;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtFunction=findViewById(R.id.txtFunction);
        final CustomView customView=findViewById(R.id.plotview);

        Button buttonPlot=findViewById(R.id.buttonPlot);
        buttonPlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.NoZoom();
                if(customView!=null){
                    String strFunction=txtFunction.getText().toString();
                    customView.setStrFunction(strFunction);
                    customView.invalidate();
                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        final CustomView customView = findViewById(R.id.plotview);
        switch (item.getItemId()){
            case R.id.large:
                customView.ZoomIn();
                customView.invalidate();
                break;
            case R.id.small:
                customView.ZoomOut();
                customView.invalidate();
                break;
            default:
                break;
        }
        return true;
    }
}