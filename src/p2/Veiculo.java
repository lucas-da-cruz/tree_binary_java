package p2;

import java.io.Serializable;

public class Veiculo implements Serializable {
    public static final long serialVersionUID = 1234L;

    private String nameVeiculo;

    public Veiculo(String nameVeiculo) {
        this.nameVeiculo = nameVeiculo;
    }

}
