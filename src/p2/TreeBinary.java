package p2;

import java.util.Arrays;

public class TreeBinary {
    public static void main(String[] args) {
        Tree gerencia = new Tree();
        /*gerencia.inserir(new Pessoa(2, "Nome 2", Arrays.asList(new Endereco("Rua 2")),  Arrays.asList(new Veiculo("Honda"))));
        gerencia.inserir(new Pessoa(1, "Nome 1", Arrays.asList(new Endereco("Rua 1")),  Arrays.asList(new Veiculo("Fiat"))));
        gerencia.inserir(new Pessoa(3, "Nome 3", Arrays.asList(new Endereco("Rua 3")),  Arrays.asList(new Veiculo("Peugeot"))));
        gerencia.serializeObject();*/
        /*Boolean deletar = gerencia.remover(3);
        System.out.println(deletar);*/
        Pessoa buscar = gerencia.buscar(1);
        System.out.println(buscar.nome);
        System.out.println(buscar.item);
        Pessoa buscar3 = gerencia.buscar(3);
        System.out.println(buscar3.nome);
        System.out.println(buscar3.item);

        //gerencia.deserializeObject();
    }
}
