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

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }

    public Pessoa getDir() {
        return dir;
    }

    public void setDir(Pessoa dir) {
        this.dir = dir;
    }

    public Pessoa getEsq() {
        return esq;
    }

    public void setEsq(Pessoa esq) {
        this.esq = esq;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
