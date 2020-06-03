package com.clase.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clase.springboot.app.entity.Factura;
import com.clase.springboot.app.entity.Item;
import com.clase.springboot.app.entity.Producto;
import com.clase.springboot.app.services.IFacturaService;
import com.clase.springboot.app.services.IProductoService;

@CrossOrigin
@RestController
@RequestMapping("/facturas")
public class FacturaController {
	@Autowired
	IFacturaService serv;
	@Autowired
	IProductoService productoService;

	@PostMapping
	public Factura save(@RequestBody Factura factura) {
		factura.setItems(cargarItems(factura.getItems()));
		factura.setValorTotal(calcularTotal(factura.getItems()));
		return serv.create(factura);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		serv.delete(id);
	}

	@GetMapping
	public List<Factura> listar() {
		return serv.listar();
	}

	@GetMapping("/{id}")
	public Factura read(@PathVariable Long id) {
		return serv.read(id);

	}

	public List<Producto> listarProductos(List<Long> idsProductos) {
		return productoService.listarProductos(idsProductos);
	}

	public List<Item> cargarItems(List<Item> items) { //cargar productos
		List<Long> idsProductos = new ArrayList();
		double total = 0.0;
		for (Item i : items) {
			idsProductos.add(i.getProducto().getId());
		}
	
		List<Producto> listarProductos = listarProductos(idsProductos);
		List<Item> nuevosItems = new ArrayList<>();
		for (Item i : items) {
			for (Producto j : listarProductos) {
				if (i.getProducto().getId() == j.getId()) {
					i.setValorTotal(i.getCantidad()*j.getPrecio());
					nuevosItems.add(i);
				}
			}
		}
		return nuevosItems;
	}
	
	public double calcularTotal(List<Item> items) { //calcular total 
		double t=0.0;
		for(Item i: items) {
			t+=i.getValorTotal();
		}
		return t;
	} 

}
