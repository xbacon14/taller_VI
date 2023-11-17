package py.edu.facitec.personajes_marvel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class PersonajeMarvel implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String modified;
    private PersonajeMarvelThumbnail thumbnail;
    private String resourceURI;
    private PersonajeMarvelComic comics;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public PersonajeMarvelThumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(PersonajeMarvelThumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public PersonajeMarvelComic getComics() {
        return comics;
    }

    public void setComics(PersonajeMarvelComic comics) {
        this.comics = comics;
    }

    public PersonajeMarvel() {
    }

    public PersonajeMarvel(Long id, String name, String description, String modified, PersonajeMarvelThumbnail thumbnail, String resourceURI, PersonajeMarvelComic comics) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.thumbnail = thumbnail;
        this.resourceURI = resourceURI;
        this.comics = comics;
    }
}
