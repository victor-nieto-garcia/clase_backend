package com.clase.springboot.app.services;

import java.util.List;

import com.clase.springboot.app.entity.Producto;

public interface IProductoService {
	
	public Producto create(Producto producto); // crear
	public Producto update(Producto producto); // editar
	public void delete(Long id); //eliminar
	public List<Producto> listar(); // listar
	public Producto read(Long id); //Consultar
	public List<Producto> listarProductos(List<Long> idsProductos); // aqui recibo id de los productos
	
	
}
