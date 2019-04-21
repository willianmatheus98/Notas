package com.example.notas;

public class ScriptDLL {
    public static String getCreateTableChecklist(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE Notas (");
        sql.append(" ID INTEGER PRIMARY KEY");
        sql.append(" NOT NULL,");
        sql.append(" Descricao TEXT (256) DEFAULT (''),");
        sql.append(" Titulo TEXT (200) DEFAULT ('')");
        sql.append(");");
        return sql.toString();
    }

    public static String getNotas(){
        StringBuilder sql = new StringBuilder();
        sql.append("Select ID,Descricao,Titulo");
        sql.append(" from Notas");
        return sql.toString();
    }
}
