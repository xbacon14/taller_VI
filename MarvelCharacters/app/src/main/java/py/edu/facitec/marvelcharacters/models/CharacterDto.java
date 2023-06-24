package py.edu.facitec.marvelcharacters.models;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class CharacterDto {
    @DatabaseField(generatedId = false)
    private Long id;
    @DatabaseField
    private String nombre;
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private Date dtGuardado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getDtGuardado() {
        return dtGuardado;
    }

    public void setDtGuardado(Date dtGuardado) {
        this.dtGuardado = dtGuardado;
    }

    public CharacterDto() {
    }

    public CharacterDto(Long id, String nombre, String descripcion, Date dtGuardado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dtGuardado = dtGuardado;
    }
}
