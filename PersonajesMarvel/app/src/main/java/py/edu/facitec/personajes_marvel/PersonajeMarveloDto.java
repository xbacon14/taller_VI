package py.edu.facitec.personajes_marvel;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class PersonajeMarveloDto {
    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField
    private String name;
    @DatabaseField
    private String description;
    @DatabaseField
    private Date dtCreated;

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

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public PersonajeMarveloDto(Long id, String name, String description, Date dtCreated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dtCreated = dtCreated;
    }

    public PersonajeMarveloDto() {
    }
}
