package com.cam.practintentmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private String recibido=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        TextView tvNombre = findViewById(R.id.tvNombre);
        Bundle extras= getIntent().getExtras();
        recibido=extras.getString("valor");
        tvNombre.setText(recibido);
    }

    public void onClick(View v)
    {
        MainActivity.nombreList.add(recibido);
    }
}
