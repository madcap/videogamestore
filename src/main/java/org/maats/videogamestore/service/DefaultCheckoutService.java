package org.maats.videogamestore.service;

import org.maats.videogamestore.domain.checkout.CheckoutResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.*;

@Service
public class DefaultCheckoutService implements CheckoutService {

    // faking databases, in a real application we'd have a real databases backing these
    // this is not safe for concurrent access...
    private static final Map<String, Integer> INVENTORY_DATABASE = new HashMap<>();
    static {
        INVENTORY_DATABASE.put("3030-89235", 5); // helldivers 2
        INVENTORY_DATABASE.put("3030-69787", 3); // risk of rain 2
        INVENTORY_DATABASE.put("3030-59383", 4);  // slay the spire
        // TODO - add more games here
    }

    private static final List<CheckoutResult> CHECKOUTS = new ArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCheckoutService.class);


    // very not thread safe!
    @Override
    public CheckoutResult checkOutGame(String guid) throws NoInventoryException {

        LOG.info("attempting to checkout game: [{}]", guid);

        Integer inventory = INVENTORY_DATABASE.get(guid);
        if(inventory == null || inventory <= 0) {
            LOG.warn("the store has no copies of game [{}] available for checkout", guid);
            throw new NoInventoryException("there are no copies available for guid: " + guid);
        }

        CheckoutResult result = new CheckoutResult();
        result.setTransactionId(UUID.randomUUID().toString());
        result.setDueDateTime(ZonedDateTime.now().plusDays(14).toString());
        result.setGuid(guid);

        // persist the checkout to the "database"
        CHECKOUTS.add(result);

        // update current inventory in the "database"
        INVENTORY_DATABASE.put(guid, inventory - 1);

        LOG.info("remaining inventory for game [{}] is {}", guid, inventory - 1);
        LOG.info("there are currently {} games checked out", CHECKOUTS.size());

        return result;
    }




}
