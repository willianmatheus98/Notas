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

        //Obriga o preenchimento de titulo
        if(titulo.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), R.string.tituloObrigatorio, Toast.LENGTH_SHORT).show();
            titulo.requestFocus();
            return;
        }

        //Obriga o preenchimento da descrição
        if(descricao.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), R.string.descricaoObrigatorio, Toast.LENGTH_SHORT).show();
            descricao.requestFocus();
            return;
        }

        //Cria uma nova instância e preenche os atributos
        Nota n = new Nota();
        n.setTitulo(titulo.getText().toString());
        n.setDescricao(descricao.getText().toString());

        //insere no banco
        NotaDAO.insert(n);

        //adiciona na lista que é exibida
        MainActivity.notas.add(n);

        //vai para a activity de lista
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
