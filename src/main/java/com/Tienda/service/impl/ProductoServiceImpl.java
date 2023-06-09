package com.Tienda.service.impl;

import com.Tienda.dao.ProductoDao;
import com.Tienda.domain.Producto;
import com.Tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//SIEMPRE HAY QUE PONER SERVICE EN LOS IMPL
@Service
public class ProductoServiceImpl implements ProductoService {

    //Anotacion que permite crear instancia de un elemento
    @Autowired
    ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = true) //Transaccion solo de lectura, NO BLOQUEA LA TABLA
    public List<Producto> getProductos(boolean activos) {
        List<Producto> productos = productoDao.findAll();
        
        if(activos){
            productos.removeIf(x -> !x.isActivo());
        }
        
        return productos;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
}
