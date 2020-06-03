package com.clase.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clase.springboot.app.entity.Producto;
import com.clase.springboot.app.services.IProductoService;

@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	IProductoService serv;

	@PostMapping
	public Producto save(@RequestBody Producto producto) {
		return serv.create(producto);
	}

	@PutMapping("/{id}")
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		Producto productoDb = serv.read(id);
		if (productoDb != null) {
			productoDb.setNombre(producto.getNombre());
			productoDb.setPrecio(producto.getPrecio());
		}
		return productoDb;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		serv.delete(id);
	}

	@GetMapping
	public List<Producto> listar() {
		return serv.listar();
	}
	@GetMapping("/{id}")
	public Producto read(@PathVariable Long id) {
		return serv.read(id);
		
	}
}
