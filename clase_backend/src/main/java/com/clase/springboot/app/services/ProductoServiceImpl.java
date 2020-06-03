package com.clase.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clase.springboot.app.entity.Producto;
import com.clase.springboot.app.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	IProductoRepository repo;

	@Override
	public Producto create(Producto producto) {
		
		return repo.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		return repo.save(producto);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id); 

	}

	@Override
	public List<Producto> listar() {
		
		return repo.findAll();
	}

	@Override
	public Producto read(Long id) {
		
		return repo.findById(id).get();
	}

	@Override
	public List<Producto> listarProductos(List<Long> idsProductos) {
		
		return repo.findAllById(idsProductos);
	}

}
