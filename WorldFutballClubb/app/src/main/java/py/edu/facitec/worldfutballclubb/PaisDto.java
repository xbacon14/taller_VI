package py.edu.facitec.worldfutballclubb;

import java.io.Serializable;

public class PaisDto implements Serializable {
    private boolean success;
    private Data data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public PaisDto(boolean success, Data data) {
        this.success = success;
        this.data = data;
    }

    public PaisDto() {
    }
}
