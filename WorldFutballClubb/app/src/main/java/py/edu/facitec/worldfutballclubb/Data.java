package py.edu.facitec.worldfutballclubb;

import java.io.Serializable;
import java.util.List;

public class Data  implements Serializable {
    private List<Pais> table;

    public List<Pais> getTable() {
        return table;
    }

    public void setTable(List<Pais> table) {
        this.table = table;
    }

    public Data(List<Pais> table) {
        this.table = table;
    }
}
