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
import br.unigran.BancoDados.FornecedorDB;
import br.unigran.Entidades.Fornecedor;
import br.unigran.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FornecedorFragmentoCadastro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FornecedorFragmentoCadastro extends Fragment {
    EditText nome;
    EditText telefone;
    Button btnsalvar;

    DBHelper db;
    FornecedorDB fornecedorDB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FornecedorFragmentoCadastro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FornecedorFragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static FornecedorFragmentoCadastro newInstance(String param1, String param2) {
        FornecedorFragmentoCadastro fragment = new FornecedorFragmentoCadastro();
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
        String nomeFornecedor = nome.getText().toString();
        String telefoneFornecedor = telefone.getText().toString();

        if ((nomeFornecedor.equals(null) || nomeFornecedor.equals(null) || telefoneFornecedor.equals(null))
                || (telefoneFornecedor.equals(""))) {
            Toast.makeText(getActivity(), "Preencha os dados corretamente", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    public void salvar() {
        if(verificar()){
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setNome(nome.getText().toString());
            fornecedor.setTelefone(telefone.getText().toString());

            fornecedorDB.inserir(fornecedor);
            Toast.makeText(getActivity(), "Dados salvos", Toast.LENGTH_SHORT).show();


        }
    }
    private void limpar() {
        nome.setText("");
        telefone.setText("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fornecedor_cadastro, container, false);

        db = new DBHelper(getActivity());
        fornecedorDB = new FornecedorDB(db);
        nome = view.findViewById(R.id.nomeid);
        telefone = view.findViewById(R.id.telefoneid);
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