package p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeBinaryApp {
    public static void main(String[] args) {
        Scanner le = new Scanner(System.in);
        Tree arv = new Tree();
        int opcao;
        System.out.print("\n Trabalho de Final de Curso - Análise e desenvolvimento de sistemas");
        System.out.print("\n Estrutura de dados - Prof° Jaime");
        System.out.print("\n Aluno: Lucas da Cruz");
        do {
            System.out.print("\n***********************************");
            System.out.print("\nDIGITE O NUMERO DA OPCAO DESEJADA:");
            System.out.print("\n ----1: Inserir pessoa");
            System.out.print("\n ----2: Excluir pessoa");
            System.out.print("\n ----3: Pesquisar pessoa");
            System.out.print("\n ----4: Exibir detalhes da base de dados");
            System.out.print("\n ----5: Sair do programa");
            System.out.print("\n***********************************");
            System.out.print("\n-> ");
            opcao = le.nextInt();
            switch(opcao) {
                case 1: {
                    Pessoa x = new Pessoa();
                    System.out.print("\n Informe um id -> ");
                    long item = le.nextLong();
                    x.item = item;

                    System.out.print("\n Informe um Nome -> ");
                    String nome = le.next();
                    x.nome = nome;

                    List<Endereco> enderecos = new ArrayList<Endereco>();
                    char condicaoEnderecos = 's';
                    while(condicaoEnderecos != 'n'){
                        System.out.print("\n Deseja adicionar endereço? (s - sim) (n - não) -> ");
                        condicaoEnderecos = le.next().charAt(0);
                        if(condicaoEnderecos == 's'){
                            System.out.print("\n Digite o endereço -> ");
                            String enderecoTemp = le.next();
                            enderecos.add(new Endereco(enderecoTemp));
                        }
                    }
                    x.enderecos = enderecos;

                    List<Veiculo> veiculos = new ArrayList<Veiculo>();
                    char condicaoVeiculos = 's';
                    while(condicaoVeiculos != 'n'){
                        System.out.print("\n Deseja adicionar veículo? (s - sim) (n - não) -> ");
                        condicaoVeiculos = le.next().charAt(0);
                        if(condicaoVeiculos == 's'){
                            System.out.print("\n Digite o veículo -> ");
                            String veiculosTemp = le.next();
                            veiculos.add(new Veiculo(veiculosTemp));
                        }
                    }
                    x.veiculos = veiculos;

                    arv.inserir(x);
                    System.out.print("\n Registro inserid0 com sucesso");
                    break;
                }
                case 2: {
                    System.out.print("\n Informe o id para ser excluído -> ");
                    int id_excluir = le.nextInt();
                    if (arv.remover(id_excluir)){
                        System.out.print("\n Registro excluído da base de dados!");;
                    } else {
                        System.out.print("\n Registro nao encontrado!");
                    }
                    break;
                }
                case 3: {
                    System.out.print("\n Informe o id para ser pesquisado -> ");
                    int id_pesquisa = le.nextInt();
                    if( arv.buscar(id_pesquisa) != null ){
                        Pessoa buscada = arv.buscar(id_pesquisa);
                        System.out.println("Id: " + buscada.item);
                        System.out.println("Nome: " + buscada.nome);
                        if(!buscada.getEnderecos().isEmpty()){
                            for(Endereco endereco : buscada.getEnderecos() ){
                                System.out.println("Endereco: " + endereco.getNameEndereco());
                            }
                        }

                        if(!buscada.getVeiculos().isEmpty()){
                            for(Veiculo veiculo : buscada.getVeiculos() ){
                                System.out.println("Veiculo: " + veiculo.getNameVeiculo());
                            }
                        }
                    } else {
                        System.out.print("\n Registro nao encontrado!");
                    }
                    break;
                }
                case 4: {
                    arv.caminhar();
                    break;
                }
            } // fim switch
        } while(opcao != 5);
    }
}
