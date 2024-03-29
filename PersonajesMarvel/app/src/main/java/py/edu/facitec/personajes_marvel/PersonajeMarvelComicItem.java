package py.edu.facitec.personajes_marvel;

import java.io.Serializable;

public class PersonajeMarvelComicItem  implements Serializable {
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

    public PersonajeMarvelComicItem(String resourceURI, String name) {
        this.resourceURI = resourceURI;
        this.name = name;
    }

    public PersonajeMarvelComicItem() {
    }
}
