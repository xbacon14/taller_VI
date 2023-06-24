package py.edu.facitec.marvelcharacters.models;

import java.io.Serializable;

public class ItemComic implements Serializable {

    private String resourceURI;
    private String name;

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemComic() {
    }

    public ItemComic(String resourceURI, String name) {
        this.resourceURI = resourceURI;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemComic{" +
                "resourceURI='" + resourceURI + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
