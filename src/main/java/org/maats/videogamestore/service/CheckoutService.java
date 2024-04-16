package org.maats.videogamestore.service;

import org.maats.videogamestore.domain.checkout.CheckoutResult;

public interface CheckoutService {

    CheckoutResult checkOutGame(String guid) throws NoInventoryException;

}
