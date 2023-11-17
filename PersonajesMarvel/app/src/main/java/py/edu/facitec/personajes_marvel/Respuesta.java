package py.edu.facitec.personajes_marvel;

public class Respuesta {
    private Long code;
    private String status;
    private String copyright;
    private String attributionText;
    private RespuestaData data;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public RespuestaData getData() {
        return data;
    }

    public void setData(RespuestaData data) {
        this.data = data;
    }
}
