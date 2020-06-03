package com.clase.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clase.springboot.app.entity.Producto;

@Repository
public interface IProductoRepository  extends JpaRepository<Producto, Long>{

}
