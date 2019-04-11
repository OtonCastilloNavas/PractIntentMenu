package com.cam.practintentmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TerceraActivity extends AppCompatActivity {

    private Spinner spNombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        //control Spinner, Origen de dato, adaptador
        //control
        spNombres = findViewById(R.id.spNombres);
        //datos
        //MainActivity.nombreList
        //adaptador
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,MainActivity.nombreList);
        //Asignar Adaptador
        spNombres.setAdapter(adapter);
    }

    public void onClick(View view)
    {
        Intent intent = new Intent();

        intent.putExtra("valor",spNombres.getSelectedItem().toString());
        //setResult(RESULT_OK);
        setResult(RESULT_OK,intent);
        finish();
    }
}
