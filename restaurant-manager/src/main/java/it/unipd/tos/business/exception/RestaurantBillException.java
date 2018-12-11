////////////////////////////////////////////////////////////////////
// [Luca] [Stocco] [1125280]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable {

    public RestaurantBillException() {
        super("Too many orders");
    }
}
