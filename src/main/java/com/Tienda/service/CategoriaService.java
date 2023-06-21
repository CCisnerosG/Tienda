package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    //Metodo para consultar las categorias. El parametro define si se muestran solo las acrivas o todas
    public List<Categoria> getCategorias (boolean activos); 
    
    //Se obtiene una categoria por su id
    public Categoria getCategoria(Categoria categoria);
    
    //Insertar: Se inserta cuando el IdCategoria esta vacio (valor 0 o null)
    //Modificar: Se modifica cuando el IdCategoria no esta vacio
    public void save(Categoria categoria);
    
    //Se elimina un registro por su IdCategoria
    public void delete(Categoria categoria);
}
