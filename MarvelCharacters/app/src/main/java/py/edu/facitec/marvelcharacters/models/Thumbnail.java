package py.edu.facitec.marvelcharacters.models;

import java.io.Serializable;

public class Thumbnail implements Serializable {
    private String path;
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Thumbnail() {
    }

    public Thumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }
}
