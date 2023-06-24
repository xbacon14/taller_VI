package py.edu.facitec.marvelcharacters.models;

import java.io.Serializable;
import java.util.List;

public class Comic implements Serializable {
    private Long avaiable;
    private Long returned;
    private String collectionURI;
    private List<ItemComic> items;

    public Long getAvaiable() {
        return avaiable;
    }

    public void setAvaiable(Long avaiable) {
        this.avaiable = avaiable;
    }

    public Long getReturned() {
        return returned;
    }

    public void setReturned(Long returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<ItemComic> getItems() {
        return items;
    }

    public void setItems(List<ItemComic> items) {
        this.items = items;
    }

    public Comic() {
    }

    public Comic(Long avaiable, Long returned, String collectionURI, List<ItemComic> items) {
        this.avaiable = avaiable;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }
}

