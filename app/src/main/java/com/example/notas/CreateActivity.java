package com.example.notas;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


    }

    public void addItems(View v){
        EditText titulo = (EditText) findViewById(R.id.tituloInput);
        EditText descricao = (EditText) findViewById(R.id.descricaoInput);

        if(titulo.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Preencha o titulo", Toast.LENGTH_SHORT).show();
            titulo.requestFocus();
            return;
        }

        if(descricao.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Preencha a descrição", Toast.LENGTH_SHORT).show();
            descricao.requestFocus();
            return;
        }

        Nota n = new Nota();
        n.setTitulo(titulo.getText().toString());
        n.setDescricao(descricao.getText().toString());

        MainActivity.notas.add(n);

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
