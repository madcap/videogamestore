package org.maats.videogamestore.service;

public class NoInventoryException extends RuntimeException {

    public NoInventoryException(String message) {
        super(message);
    }

}
