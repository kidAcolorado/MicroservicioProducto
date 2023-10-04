package com.viewnext.kidaprojects.microserviceproducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.kidaprojects.microserviceproducto.model.Producto;

/**
 * La interfaz {@code ProductoRepository} proporciona métodos para acceder y gestionar los productos
 * almacenados en la base de datos.
 *
 * <p>
 * El autor de esta interfaz es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 3 de Octubre de 2023
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
