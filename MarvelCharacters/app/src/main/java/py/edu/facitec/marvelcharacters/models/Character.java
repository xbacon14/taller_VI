package py.edu.facitec.marvelcharacters.models;

import java.io.Serializable;

public class Character implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Thumbnail thumbnail;
    private String resourceURI;

    private Comic comics;

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

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Comic getComics() {
        return comics;
    }

    public void setComics(Comic comic) {
        this.comics = comic;
    }

    public Character() {
    }

    public Character(Long id, String name, String description, Thumbnail thumbnail, String resourceURI, Comic comic) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.resourceURI = resourceURI;
        this.comics = comic;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail=" + thumbnail +
                ", resourceURI='" + resourceURI + '\'' +
                ", comics=" + comics +
                '}';
    }
}
