package p2;

import java.io.Serializable;
import java.util.List;

public class Pessoa implements Serializable {
    public static final long serialVersionUID = 1234L;

    public Pessoa(){
    }

    public Pessoa(long item, String nome, List<Endereco> enderecos, List<Veiculo> veiculos) {
        this.item = item;
        this.nome = nome;
        this.enderecos = enderecos;
        this.veiculos = veiculos;
    }

    public Pessoa(Pessoa p) {
        this.item = p.item;
        this.dir = p.dir;
        this.esq = p.esq;
        this.nome = p.nome;
        this.enderecos = p.enderecos;
        this.veiculos = p.veiculos;
    }

    public long item;
    public Pessoa dir;
    public Pessoa esq;
    public String nome;
    public List<Endereco> enderecos;
    public List<Veiculo> veiculos;
}
