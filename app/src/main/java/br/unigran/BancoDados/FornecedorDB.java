package br.unigran.BancoDados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.Entidades.Fornecedor;

public class FornecedorDB {
    private DBHelper db;
    private SQLiteDatabase conexao;
    public FornecedorDB(DBHelper db){
        this.db=db;
    }
    public void inserir(Fornecedor fornecedor){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome",fornecedor.getNome());
        valores.put("telefone",fornecedor.getTelefone());
        conexao.insertOrThrow("fornecedor",null,valores);
        conexao.close();
    }
    public void atualizar(Fornecedor fornecedor){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nome",fornecedor.getNome());
        valores.put("telefone",fornecedor.getTelefone());
        conexao.update("fornecedor",valores, "id=?", new String[]{fornecedor.getId().toString()});
        conexao.close();
    }
    public void remover(int id){
        conexao=db.getWritableDatabase();
        conexao.delete("fornecedor","id=?",
                new String[]{id+""});
    }
    public void lista(List dados){
        dados.clear();
        conexao=db.getReadableDatabase();
        String names[]={"id","nome","telefone"};
        Cursor query = conexao.query("fornecedor", names,
                null, null, null,
                null, "nome");
        while (query.moveToNext()){
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(Integer.parseInt(
                    query.getString(0)));
            fornecedor.setNome(
                    query.getString(1));
            fornecedor.setTelefone(
                    query.getString(2));
            dados.add(fornecedor);
        }
        conexao.close();
    }
}
