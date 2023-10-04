package com.viewnext.kidaprojects.microserviceproducto.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.kidaprojects.microserviceproducto.exception.StockInsuficienteException;
import com.viewnext.kidaprojects.microserviceproducto.model.Producto;
import com.viewnext.kidaprojects.microserviceproducto.service.ProductorService;

import jakarta.persistence.EntityNotFoundException;

/**
 * La clase {@code ProductoRestController} es un controlador REST que maneja las operaciones relacionadas con los productos.
 * Permite mostrar la lista de productos, obtener el precio de un producto por su ID y actualizar el stock de un producto.
 *
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 3 de Octubre de 2023
 */
@RestController
public class ProductoRestController {

    @Autowired
    private ProductorService service;

    private static final String PRODUCTO_NOT_FOUND = "Producto/s no encontrado";

    /**
     * Obtiene la lista de todos los productos disponibles.
     *
     * @return Una respuesta HTTP con la lista de productos en formato JSON.
     */
    @GetMapping(value = "producto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> showAllProductos() {
        try {
            List<Producto> listaProductos = service.showAll();
            return ResponseEntity.ok(listaProductos);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PRODUCTO_NOT_FOUND);
        }
    }

    /**
     * Obtiene el precio de un producto por su código.
     *
     * @param codigo El código del producto del cual se desea obtener el precio.
     * @return Una respuesta HTTP con el precio del producto en formato JSON.
     */
    @GetMapping(value = "producto/precio/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPrecioProductoById(@PathVariable("codigo") int codigo) {
        try {
            double precio = service.getPrecio(codigo);
            return ResponseEntity.ok(precio);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PRODUCTO_NOT_FOUND);
        }
    }

    /**
     * Actualiza el stock de un producto en la base de datos.
     *
     * @param codigo       El código del producto a actualizar.
     * @param cantidad La cantidad de stock a actualizar.
     * @return Una respuesta HTTP indicando el resultado de la operación.
     */
    @PutMapping(value = "producto")
    public ResponseEntity<?> updateStockProducto(@RequestParam("codigo") int codigo, @RequestParam("cantidad") int cantidad) {
        try {
            service.updateStock(codigo, cantidad);

            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PRODUCTO_NOT_FOUND);
        } catch (StockInsuficienteException e) {
        	 return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
