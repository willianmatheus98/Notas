package com.example.notas;

import android.content.Context;
import android.content.res.AssetManager;

import java.util.ArrayList;

public class Nota {
    private int id;
    private String titulo;
    private String descricao;
    public static Context c;

    public Nota(){

    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return c.getString(R.string.titulo) + " " + getTitulo();
    }


}
