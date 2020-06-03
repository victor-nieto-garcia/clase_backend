package com.clase.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clase.springboot.app.entity.Factura;
import com.clase.springboot.app.repository.IFacturaRepository;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	IFacturaRepository repo;
	
	@Override
	public Factura create(Factura factura) {
		
		return repo.save(factura);
	}

	@Override
	public Factura update(Factura factura) {
		
		return repo.save(factura);
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);

	}

	@Override
	public List<Factura> listar() {
		
		return repo.findAll();
	}

	@Override
	public Factura read(Long id) {
		
		return repo.findById(id).get();
	}

}
