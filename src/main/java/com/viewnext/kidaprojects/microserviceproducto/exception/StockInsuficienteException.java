package com.viewnext.kidaprojects.microserviceproducto.exception;

public class StockInsuficienteException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockInsuficienteException() {
        super("Stock insuficiente. No se puede realizar el pedido");
    }
}
