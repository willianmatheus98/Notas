package com.example.notas;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class NotaDAO {
    public static void insert(Nota n){
        ContentValues ct = new ContentValues();
        ct.put("Descricao", n.getDescricao());
        ct.put("Titulo", n.getTitulo());

        MainActivity.mConection.insertOrThrow("Notas", null, ct);
    }
    public void remove(int id){ }
    public void alter(Nota n){ }
    public static ArrayList<Nota> listNotas(){
        ArrayList<Nota> notas = new ArrayList<Nota>();
        Cursor result = MainActivity.mConection.rawQuery(ScriptDLL.getNotas(), null);
        if (result.getCount() > 0){
            result.moveToFirst();
            do{
                Nota n = new Nota();
                n.setId(result.getInt(result.getColumnIndexOrThrow("ID")));
                n.setTitulo(result.getString(result.getColumnIndexOrThrow("Titulo")));
                n.setDescricao(result.getString(result.getColumnIndexOrThrow("Descricao")));
                notas.add(n);
            }while(result.moveToNext());
        }

        return  notas;
    }
    public Nota getNota(int id){return null; }
}
