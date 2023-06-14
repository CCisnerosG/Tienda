package com.Tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table (name="categoria")
public class Categoria implements Serializable{  
    
    //La version de serializacion que se va a usar
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Si quiero asignar a algo especifico, usar este tipo de anotacion
    @Column(name="id_categoria")
    private Long idCategoria; //Se transforma en id_categoria cuando vaya a base de datos
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
}
