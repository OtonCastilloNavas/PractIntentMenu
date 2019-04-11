package com.cam.practintentmenu;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> nombreList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textview1);
        registerForContextMenu(textView);
    }

    public void onClick(View v)
    {
        EditText etNombre = findViewById(R.id.etNombre);
        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("valor",etNombre.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mnMostrado:
                //Toast.makeText(this, "Mostrado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TerceraActivity.class);
                //startActivity(intent);
                startActivityForResult(intent,4444);
                break;
            case R.id.mnOpcion1:
                Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnOpcion2:
                Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnPrueba:
                Toast.makeText(this, "Prueba", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnSaludo:
                Toast.makeText(this, "Saludo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnTiempo:
                Toast.makeText(this, "Tiempo", Toast.LENGTH_SHORT).show();
                break;
        }
        //Toast.makeText(this, "Menus", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
      if(requestCode==4444)
      {
        if(resultCode==RESULT_CANCELED)
            Toast.makeText(this, "Cancelo", Toast.LENGTH_SHORT).show();
        else {
            String valor =  data.getExtras().getString("valor");
            Toast.makeText(this, "Ok " + valor, Toast.LENGTH_SHORT).show();
        }
      }
      //else if(requestCode==7858)
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextual,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
