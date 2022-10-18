package br.unigran.Activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.unigran.Fragment.ClienteFragmentoLista;
import br.unigran.Fragment.FornecedorFragmentoLista;
import br.unigran.Fragment.ProdutoFragmentoLista;
import br.unigran.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void cliente(View view){
        Intent it = new Intent(this, SegundoActivity.class);
        resultLauncher.launch(it);
    }
    public void produto(View view){
        Intent it = new Intent(this, SegundoActivity.class);
        resultLauncher.launch(it);
    }
    public void fornecedor(View view){
        Intent it = new Intent(this, SegundoActivity.class);
        resultLauncher.launch(it);
    }
    ActivityResultLauncher resultLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>(){
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if(result.getResultCode()==80)
                                Toast.makeText(getApplicationContext(),
                                        "menu",Toast.LENGTH_SHORT).show();
                        }
                    });

    public void sair(View view){
        finish();
    }
}