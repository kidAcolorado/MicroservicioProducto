package com.viewnext.kidaprojects.microserviceproducto.service;

import java.util.List;

import com.viewnext.kidaprojects.microserviceproducto.model.Producto;

/**
 * La interfaz {@code ProductorService} proporciona métodos para interactuar con productos,
 * incluyendo la obtención de información sobre productos, actualización de stock y obtención
 * de precios.
 *
 * <p>
 * El autor de esta interfaz es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 3 de Octubre de 2023
 */
public interface ProductorService {

    /**
     * Obtiene una lista de todos los productos disponibles.
     *
     * @return Una lista de productos.
     */
    public List<Producto> showAll();

    /**
     * Actualiza el stock de un producto en la base de datos.
     *
     * @param codigo       El identificador del producto.
     * @param cantidad La cantidad de stock a actualizar.
     */
    public void updateStock(int codigo, int cantidad);

    /**
     * Obtiene el precio de un producto dado su identificador.
     *
     * @param codigo El identificador del producto.
     * @return El precio del producto.
     */
    public double getPrecio(int codigo);

}