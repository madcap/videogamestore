package org.maats.videogamestore.client;

public class GiantBombException extends RuntimeException {

    public GiantBombException() {
        super();
    }

    public GiantBombException(String message) {
        super(message);
    }

    public GiantBombException(String message, Throwable t) {
        super(message, t);
    }


}
