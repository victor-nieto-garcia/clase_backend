package com.clase.springboot.app.services;

import java.util.List;

import com.clase.springboot.app.entity.Factura;


public interface IFacturaService {
	public Factura create(Factura factura); // crear
	public Factura update(Factura factura); // editar
	public void delete(Long id); //eliminar
	public List<Factura> listar(); // listar
	public Factura read(Long id); //Consultar o Buscar
}
