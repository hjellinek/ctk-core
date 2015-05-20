package org.ga4gh.asserts;

import org.ga4gh.service.Confirmation;
import org.ga4gh.service.Order;

import java.util.function.BiPredicate;

/**
 * Created by Wayne Stidolph on 5/19/2015.
 */
public class Predicates {
    public BiPredicate<Confirmation,Order> customerIdPreserved =
            (Confirmation C, Order O) -> C.getCustomerId() == O.getCustomerId();

}
