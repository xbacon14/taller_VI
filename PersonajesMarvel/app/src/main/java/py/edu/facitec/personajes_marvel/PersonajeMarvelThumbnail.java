package py.edu.facitec.personajes_marvel;

import java.io.Serializable;

public class PersonajeMarvelThumbnail implements Serializable {
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

    public PersonajeMarvelThumbnail() {
    }

    public PersonajeMarvelThumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }
}
