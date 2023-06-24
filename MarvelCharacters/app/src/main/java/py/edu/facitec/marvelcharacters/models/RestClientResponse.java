package py.edu.facitec.marvelcharacters.models;

import java.io.Serializable;

public class RestClientResponse implements Serializable {
    private Long code;
    private String status;
    private String copyright;
    private String attributionText;
    private RestClientData data;

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

    public RestClientData getData() {
        return data;
    }

    public void setData(RestClientData data) {
        this.data = data;
    }

    public RestClientResponse() {
    }

    public RestClientResponse(Long code, String status, String copyright, String attributionText, RestClientData data) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestClientResponse{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", attributionText='" + attributionText + '\'' +
                ", data=" + data +
                '}';
    }
}
