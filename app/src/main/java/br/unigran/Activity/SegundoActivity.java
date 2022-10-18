package br.unigran.Activity;

import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;

import br.unigran.Fragment.ClienteFragmentoCadastro;
import br.unigran.Fragment.ClienteFragmentoLista;
import br.unigran.Fragment.FornecedorFragmentoLista;
import br.unigran.Fragment.ProdutoFragmentoLista;
import br.unigran.R;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        ClienteFragmentoLista lista = new ClienteFragmentoLista();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.frameid, lista);
        transaction.commit();

    }
    public void cadastrar(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frameid,new ClienteFragmentoCadastro())
                .commit();
    }
    public void listar(){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.frameid,new ClienteFragmentoLista())
                .commit();
    }

}