package com.example.notas;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class NotaDAO {
    public static void insert(Nota n){

        //Classe que vai preencher as colunas da linha a ser inserida na tabela Notas
        ContentValues ct = new ContentValues();
        ct.put("Descricao", n.getDescricao()); //DESCRICAO
        ct.put("Titulo", n.getTitulo()); //TITULO

        //Insert na tabela Notas
        MainActivity.mConection.insertOrThrow("Notas", null, ct);
    }
    public void remove(int id){ }

    public void alter(Nota n){ }

    public static ArrayList<Nota> listNotas(){
        ArrayList<Nota> notas = new ArrayList<Nota>();

        //Retorna todas as linhas da tabela Notas
        Cursor result = MainActivity.mConection.rawQuery(ScriptDLL.getNotas(), null);
        //Se tiver linhas retornadas
        if (result.getCount() > 0){
            //vai para a primeira linha
            result.moveToFirst();

            //percorre todas as linhas retornadas
            do{

                //cria uma nova instância que vai ser preenchida para item retornado pela query
                Nota n = new Nota();
                n.setId(result.getInt(result.getColumnIndexOrThrow("ID")));
                n.setTitulo(result.getString(result.getColumnIndexOrThrow("Titulo")));
                n.setDescricao(result.getString(result.getColumnIndexOrThrow("Descricao")));

                //adiciona na lista que vai ser retornada pelo método
                notas.add(n);

            }while(result.moveToNext()); //vai para o proximo registro
        }

        //retorna a lista com ou sem registros
        return  notas;
    }

    public Nota getNota(int id){return null; }
}
