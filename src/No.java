import java.io.Serializable;

public class No implements Serializable {
    public static final long serialVersionUID = 1234L;

    public long item;
    public No dir;
    public No esq;
}
