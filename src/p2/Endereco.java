package p2;

import java.io.Serializable;

public class Endereco implements Serializable {
    public static final long serialVersionUID = 1234L;

    private String nameEndereco;

    public Endereco(String nameEndereco) {
        this.nameEndereco = nameEndereco;
    }
}
