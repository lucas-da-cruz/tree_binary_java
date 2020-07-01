import java.io.*;

public class Tree {
    private No root;

    public Tree() {
        root = null;
    }

    public void serializeObject() {
        String filePath = "root.ser";
        try (
                FileOutputStream fos = new FileOutputStream(filePath);
                ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        ) {
            outputStream.writeObject(root);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public void deserializeObject(){
        String filePath = "root.ser";

        try (
                FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream inputStream = new ObjectInputStream(fis);
        ) {
            No root = (No) inputStream.readObject();
            System.out.println(root.item);
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found: " + ex);
        } catch (IOException ex) {
            System.err.println("IO error: " + ex);
        }
    }

    public void inserir(long v){
        No novo = new No(); // cria um novo Nó
        novo.item = v; // atribui o valor recebido ao item de dados do Nó
        novo.dir = null;
        novo.esq = null;

        if (root == null) {
            root = novo;
        } else { // se nao for a raiz
            No atual = root;
            No anterior;
            while (true) {
                anterior = atual;
                if (v <= atual.item) { // ir para esquerda
                    atual = atual.esq;
                    if (atual == null) {
                        anterior.esq = novo;
                        return;
                    }
                }  // fim da condição ir a esquerda
                else { // ir para direita
                    atual = atual.dir;
                    if (atual == null) {
                        anterior.dir = novo;
                        return;
                    }
                } // fim da condição ir a direita
            } // fim do laço while
        } // fim do else não raiz
    }

    public No buscar(long chave) {
        if (root == null) return null; // se arvore vazia
        No atual = root;  // começa a procurar desde raiz
        while (atual.item != chave) { // enquanto nao encontrou
            if(chave < atual.item ) atual = atual.esq; // caminha para esquerda
            else atual = atual.dir; // caminha para direita
            if (atual == null) return null; // encontrou uma folha -> sai
        } // fim laço while
        return atual; // terminou o laço while e chegou aqui é pq encontrou item
    }
}

