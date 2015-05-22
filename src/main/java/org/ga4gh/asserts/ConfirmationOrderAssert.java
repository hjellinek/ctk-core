package org.ga4gh.asserts;

import org.ga4gh.service.Confirmation;
import org.ga4gh.service.Order;

/**
 * Assertions about Confirmation/Order pairs
 * Created by Wayne Stidolph on 5/21/2015.
 */
public class ConfirmationOrderAssert {

    Confirmation actC;
    Order actO;
    /**
     * Creates a new <code>{@link ConfirmationOrderAssert}</code> to make assertions on actual Confirmation.
     * @param actC the Confirmation we want to make assertions on.
     * @param actO the Order we want to make assertions on.
     */
    public ConfirmationOrderAssert(Confirmation actC, Order actO) {
        this.actC = actC;
        this.actO = actO;
    };

    public static ConfirmationOrderAssert assertThatPairCO(Confirmation actC, Order actO) {
        return new ConfirmationOrderAssert(actC, actO);
    }

    public ConfirmationOrderAssert hasSameCustomerId() {
        // check that actual Confirmation we want to make assertions on is not null.

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting customerId of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        Long confCustomerId = actC.getCustomerId();
        Long orderCustomerId = actO.getCustomerId();
/*        if (!Objects.areEqual(actualCustomerId, customerId)) {
            failWithMessage(assertjErrorMessage, actual, customerId, actualCustomerId);
        }*/

        // return the current assertion for method chaining
        return this;
    }
}
