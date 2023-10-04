package com.viewnext.kidaprojects.microserviceproducto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viewnext.kidaprojects.microserviceproducto.exception.StockInsuficienteException;
import com.viewnext.kidaprojects.microserviceproducto.model.Producto;
import com.viewnext.kidaprojects.microserviceproducto.repository.ProductoRepository;
import jakarta.persistence.EntityNotFoundException;

/**
 * La clase {@code ProductoServiceImpl} implementa la interfaz {@code ProductorService} y proporciona
 * la lógica de negocio relacionada con los productos.
 *
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 3 de Octubre de 2023
 */
@Service
public class ProductoServiceImpl implements ProductorService {

	@Autowired
    private ProductoRepository productoRepository;

    /**
     * Obtiene una lista de todos los productos disponibles.
     *
     * @return Una lista de productos.
     * @throws EntityNotFoundException Si no se encuentran productos en la base de datos.
     */
    @Override
    public List<Producto> showAll() throws EntityNotFoundException {
        List<Producto> listaProductos = productoRepository.findAll();

        if (listaProductos.isEmpty()) {
            throw new EntityNotFoundException();
        }
        return listaProductos;
    }

    /**
     * Actualiza el stock de un producto en la base de datos y lanza una excepción si el stock es insuficiente.
     *
     * @param codigo       El código del producto a actualizar.
     * @param cantidad La cantidad de stock a actualizar.
     * @throws EntityNotFoundException    Si el producto con el ID especificado no se encuentra en la base de datos.
     * @throws StockInsuficienteException Si el stock es insuficiente para la actualización.
     */
    @Override
    public void updateStock(int codigo, int cantidad) throws EntityNotFoundException, StockInsuficienteException {
        Optional<Producto> optionalProducto = productoRepository.findById(codigo);

        if (optionalProducto.isEmpty()) {
            throw new EntityNotFoundException();
        }

        Producto producto = optionalProducto.get();

        if (producto.getStock() < cantidad) {
            throw new StockInsuficienteException();
        }

        producto.setStock(producto.getStock() - cantidad);

        productoRepository.save(producto);
    }

    /**
     * Obtiene el precio de un producto por su ID.
     *
     * @param codigo El código del producto del cual se desea obtener el precio.
     * @return El precio del producto.
     * @throws EntityNotFoundException Si el producto con el ID especificado no se encuentra en la base de datos.
     */
    @Override
    public double getPrecio(int codigo) throws EntityNotFoundException {
        Optional<Producto> optionalProducto = productoRepository.findById(codigo);

        if (optionalProducto.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return optionalProducto.get().getPrecioUnidad();
    }
}
