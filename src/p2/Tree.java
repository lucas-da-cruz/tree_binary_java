package p2;

import java.io.*;

public class Tree {
    private Pessoa root;

    public Tree() {
        root = null;
    }

    public void inserir(Pessoa p){
        //Pessoa novo = new Pessoa(p); // cria um novo Nó
        Pessoa novo = p;
        /*novo.item = p.item; // atribui o valor recebido ao item de dados do Nó*/
        novo.dir = null;
        novo.esq = null;
        root = deserializeObject();

        if (root == null) {
            root = novo;
        } else { // se nao for a raiz
            Pessoa atual = root;
            Pessoa anterior;
            while (true) {
                anterior = atual;
                if (p.item <= atual.item) { // ir para esquerda
                    atual = atual.esq;
                    if (atual == null) {
                        anterior.esq = novo;
                        serializeObject();
                        return;
                    }
                }  // fim da condição ir a esquerda
                else { // ir para direita
                    atual = atual.dir;
                    if (atual == null) {
                        anterior.dir = novo;
                        serializeObject();
                        return;
                    }
                } // fim da condição ir a direita
            } // fim do laço while
        } // fim do else não raiz

    }

    public Pessoa buscar(long chave) {
        Pessoa atual = deserializeObject();
        if(atual == null) return null;
        while (atual.item != chave) { // enquanto nao encontrou
            if(chave < atual.item ) atual = atual.esq; // caminha para esquerda
            else atual = atual.dir; // caminha para direita
            if (atual == null) return null; // encontrou uma folha -> sai
        } // fim laço while
        return atual; // terminou o laço while e chegou aqui é pq encontrou item
    }

    public Pessoa atualizar(long chave, Pessoa newPessoa) {
        //this.root = deserializeObject();
        Pessoa atual = deserializeObject();
        Pessoa inicial = deserializeObject();
        while (atual.item != chave) { // enquanto nao encontrou
            if(chave < atual.item ) atual = atual.esq; // caminha para esquerda
            else atual = atual.dir; // caminha para direita
            if (atual == null) return null; // encontrou uma folha -> sai
        } // fim laço while
        atual = newPessoa;
        return atual; // terminou o laço while e chegou aqui é pq encontrou item

    }

    public boolean remover(long v) {
        //if (root == null) return false; // se arvore vazia
        this.root = deserializeObject();
        if (root == null) return false;
        Pessoa atual = root;
        Pessoa pai = root;
        boolean filho_esq = true;

        // ****** Buscando o valor **********
        while (atual.item != v) { // enquanto nao encontrou
            pai = atual;
            if(v < atual.item ) { // caminha para esquerda
                atual = atual.esq;
                filho_esq = true; // é filho a esquerda? sim
            } else { // caminha para direita
                atual = atual.dir;
                filho_esq = false; // é filho a esquerda? NAO
            }
            if (atual == null) return false; // encontrou uma folha -> sai
        } // fim laço while de busca do valor

        // **************************************************************
        // se chegou aqui quer dizer que encontrou o valor (v)
        // "atual": contem a referencia ao No a ser eliminado
        // "pai": contem a referencia para o pai do No a ser eliminado
        // "filho_esq": é verdadeiro se atual é filho a esquerda do pai
        // **************************************************************

        // Se nao possui nenhum filho (é uma folha), elimine-o
        if (atual.esq == null && atual.dir == null) {
            if (atual == root ) root = null; // se raiz
            else if (filho_esq) pai.esq = null; // se for filho a esquerda do pai
            else pai.dir = null; // se for filho a direita do pai
        }

        // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
        else if (atual.dir == null) {
            if (atual == root) root = atual.esq; // se raiz
            else if (filho_esq) pai.esq = atual.esq; // se for filho a esquerda do pai
            else pai.dir = atual.esq; // se for filho a direita do pai
        }

        // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda
        else if (atual.esq == null) {
            if (atual == root) root = atual.dir; // se raiz
            else if (filho_esq) pai.esq = atual.dir; // se for filho a esquerda do pai
            else pai.dir = atual.dir; // se for  filho a direita do pai
        }

        // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
        else {
            Pessoa sucessor = no_sucessor(atual);
            // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No que deseja-se remover
            if (atual == root) root = sucessor; // se raiz
            else if(filho_esq) pai.esq = sucessor; // se for filho a esquerda do pai
            else pai.dir = sucessor; // se for filho a direita do pai
            sucessor.esq = atual.esq; // acertando o ponteiro a esquerda do sucessor agora que ele assumiu
            // a posição correta na arvore
        }
        serializeObject();
        return true;
    }

    public Pessoa no_sucessor(Pessoa apaga) { // O parametro é a referencia para o No que deseja-se apagar
        Pessoa paidosucessor = apaga;
        Pessoa sucessor = apaga;
        Pessoa atual = apaga.dir; // vai para a subarvore a direita

        while (atual != null) { // enquanto nao chegar no Nó mais a esquerda
            paidosucessor = sucessor;
            sucessor = atual;
            atual = atual.esq; // caminha para a esquerda
        }
        // *********************************************************************************
        // quando sair do while "sucessor" será o Nó mais a esquerda da subarvore a direita
        // "paidosucessor" será o o pai de sucessor e "apaga" o Nó que deverá ser eliminado
        // *********************************************************************************
        if (sucessor != apaga.dir) { // se sucessor nao é o filho a direita do Nó que deverá ser eliminado
            paidosucessor.esq = sucessor.dir; // pai herda os filhos do sucessor que sempre serão a direita
            // lembrando que o sucessor nunca poderá ter filhos a esquerda, pois, ele sempre será o
            // Nó mais a esquerda da subarvore a direita do Nó apaga.
            // lembrando também que sucessor sempre será o filho a esquerda do pai

            sucessor.dir = apaga.dir; // guardando a referencia a direita do sucessor para
            // quando ele assumir a posição correta na arvore
        }
        updatedSerializeObject(sucessor);
        return sucessor;
    }

    public void caminhar() {
        root = deserializeObject();
        System.out.print("\n Exibindo em ordem: ");
        inOrder(root);
        System.out.print("\n Exibindo em pos-ordem: ");
        posOrder(root);
        System.out.print("\n Exibindo em pre-ordem: ");
        preOrder(root);
        System.out.print("\n Altura da arvore: " + altura(root));
        System.out.print("\n Quantidade de folhas: " + folhas(root));
        System.out.print("\n Quantidade de Nós: " + contarNos(root));
        if (root != null ) {  // se arvore nao esta vazia
            System.out.print("\n Valor minimo: " + min().item);
            System.out.println("\n Valor maximo: " + max().item);
        }
    }

    public void inOrder(Pessoa atual) {
        if (atual != null) {
            inOrder(atual.esq);
            System.out.print(atual.item + " ");
            inOrder(atual.dir);
        }
    }

    public void preOrder(Pessoa atual) {
        if (atual != null) {
            System.out.print(atual.item + " ");
            preOrder(atual.esq);
            preOrder(atual.dir);
        }
    }

    public void posOrder(Pessoa atual) {
        if (atual != null) {
            posOrder(atual.esq);
            posOrder(atual.dir);
            System.out.print(atual.item + " ");
        }
    }

    public int altura(Pessoa atual) {
        if(atual == null || (atual.esq == null && atual.dir == null))
            return 0;
        else {
            if (altura(atual.esq) > altura(atual.dir))
                return ( 1 + altura(atual.esq) );
            else
                return ( 1 + altura(atual.dir) );
        }
    }

    public int folhas(Pessoa atual) {
        if(atual == null) return 0;
        if(atual.esq == null && atual.dir == null) return 1;
        return folhas(atual.esq) + folhas(atual.dir);
    }

    public int contarNos(Pessoa atual) {
        if(atual == null)  return 0;
        else return ( 1 + contarNos(atual.esq) + contarNos(atual.dir));
    }

    public Pessoa min() {
        Pessoa atual = root;
        Pessoa anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.esq;
        }
        return anterior;
    }

    public Pessoa max() {
        Pessoa atual = root;
        Pessoa anterior = null;
        while (atual != null) {
            anterior = atual;
            atual = atual.dir;
        }
        return anterior;
    }

    public void updatedSerializeObject(Pessoa root) {
        String filePath = "rootPessoa.ser";
        try (
                FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        ) {
            outputStream.writeObject(root);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void serializeObject() {
        String filePath = "rootPessoa.ser";
        try (
                FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        ) {
            outputStream.writeObject(root);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public Pessoa deserializeObject(){
        String filePath = "rootPessoa.ser";

        try (
                FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream inputStream = new ObjectInputStream(fis);
        ) {
            Pessoa root = (Pessoa) inputStream.readObject();
            return root;
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found: " + ex);
            return null;
        } catch (IOException ex) {
            System.err.println("IO error: " + ex);
            return null;
        }
    }
}
