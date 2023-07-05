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
    
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
