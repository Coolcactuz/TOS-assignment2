////////////////////////////////////////////////////////////////////
// [Luca] [Stocco] [1125280]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import it.unipd.tos.model.typeItem;;

public class BellaNapoli implements RestaurantBill {

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered)
            throws RestaurantBillException {
        if (itemsOrdered.size() > 20) {
            throw new RestaurantBillException();
        }

        double tot = itemsOrdered.stream()
                .mapToDouble(x -> x.getPrice()).sum();

        if (getNumPizza(itemsOrdered) > 10) {
            tot -= itemsOrdered.stream()
                    .mapToDouble(x -> x.getPrice())
                    .min().orElse(0);
        }

        if (tot > 100) {
            tot -= tot / 20;
        }

        return tot;

    }

    public int getNumPizza(List<MenuItem> itemsOrdered) {
        return (int) itemsOrdered.stream()
                .filter(x -> typeItem.PIZZA.equals(x.getItemType())).count();
    }
}
