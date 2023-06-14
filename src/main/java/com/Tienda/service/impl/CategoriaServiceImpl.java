package com.Tienda.service.impl;

import com.Tienda.dao.CategoriaDao;
import com.Tienda.domain.Categoria;
import com.Tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//SIEMPRE HAY QUE PONER SERVICE EN LOS IMPL
@Service
public class CategoriaServiceImpl implements CategoriaService {

    //Anotacion que permite crear instancia de un elemento
    @Autowired
    CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true) //Transaccion solo de lectura, NO BLOQUEA LA TABLA
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria> categorias = categoriaDao.findAll();
        
        if(activos){
            categorias.removeIf(x -> !x.isActivo());
        }
        
        return categorias;
    }
    
}
