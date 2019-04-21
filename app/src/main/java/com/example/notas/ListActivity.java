package com.example.notas;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listaNotas = (ListView) findViewById(R.id.lista);

        ArrayAdapter<Nota> adapter = new ArrayAdapter<Nota>(this,
                android.R.layout.simple_list_item_1, MainActivity.notas);

        listaNotas.setAdapter(adapter);

        listaNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView <?> parentAdapter, View view, int position,
                                    long id) {
                Nota n = MainActivity.notas.get(position);

                AlertDialog.Builder builderSingle = new AlertDialog.Builder(ListActivity.this);

                builderSingle.setTitle(R.string.selecione);

                AlertDialog.Builder builderInner = new AlertDialog.Builder(ListActivity.this);
                builderInner.setMessage(n.getDescricao());
                builderInner.setTitle(R.string.titulo);
                DialogInterface dialog = new DialogInterface() {
                    @Override
                    public void cancel() {

                    }

                    @Override
                    public void dismiss() {

                    }
                };
                builderInner.show();
                //  Place code here with the action

            }
        });
    }

}
