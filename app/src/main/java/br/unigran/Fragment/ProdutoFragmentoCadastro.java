package br.unigran.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.unigran.BancoDados.DBHelper;
import br.unigran.BancoDados.ProdutoDB;
import br.unigran.Entidades.Produto;
import br.unigran.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProdutoFragmentoCadastro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdutoFragmentoCadastro extends Fragment {
    EditText nome;
    EditText marca;
    EditText quantidade;
    Button btnsalvar;

    DBHelper db;
    ProdutoDB produtoDB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProdutoFragmentoCadastro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment produtoFragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static ProdutoFragmentoCadastro newInstance(String param1, String param2) {
        ProdutoFragmentoCadastro fragment = new ProdutoFragmentoCadastro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public boolean verificar() {
        String nomeProduto = nome.getText().toString();
        String marcaProduto = marca.getText().toString();
        String quantidadeProduto = quantidade.getText().toString();

        if ((nomeProduto.equals(null) || nomeProduto.equals(null) || marcaProduto.equals(null))
                || (marcaProduto.equals("")) || quantidadeProduto.equals(null) || quantidadeProduto.equals(null)) {
            Toast.makeText(getActivity(), "Preencha os dados corretamente", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public void salvar() {
        if (verificar()) {
            Produto produto = new Produto();

            produto.setNome(nome.getText().toString());
            produto.setMarca(marca.getText().toString());

            produtoDB.inserir(produto);
            Toast.makeText(getActivity(), "Dados salvos", Toast.LENGTH_SHORT).show();


        }
    }
    private void limpar() {
        nome.setText("");
        marca.setText("");
        quantidade.setText("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produto_cadastro, container, false);
        db = new DBHelper(getActivity());
        produtoDB = new ProdutoDB(db);
        nome = view.findViewById(R.id.nomeid);
        marca = view.findViewById(R.id.marcaid);
        quantidade = view.findViewById(R.id.quantidadeid);
        btnsalvar = view.findViewById(R.id.salvarId);

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
                limpar();
            }
        });
        return view;
    }
}