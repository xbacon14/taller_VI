package py.edu.facitec.personajes_marvel;

import java.io.Serializable;
import java.util.List;

public class PersonajeMarvelComic  implements Serializable {
    private Long available;
    private Long returned;
    private String collectionURI;
    private List<PersonajeMarvelComicItem> items;

    public Long getAvaiable() {
        return available;
    }

    public void setAvaiable(Long avaiable) {
        this.available = avaiable;
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

    public List<PersonajeMarvelComicItem> getItems() {
        return items;
    }

    public void setItems(List<PersonajeMarvelComicItem> items) {
        this.items = items;
    }

    public PersonajeMarvelComic() {
    }

    public PersonajeMarvelComic(Long available, Long returned, String collectionURI, List<PersonajeMarvelComicItem> items) {
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }
}
