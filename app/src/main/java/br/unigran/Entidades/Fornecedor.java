package br.unigran.Entidades;

public class Fornecedor {
    private String nome;
    private String telefone;
    private Integer id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", id=" + id +
                '}';
    }
}
