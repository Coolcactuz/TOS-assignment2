////////////////////////////////////////////////////////////////////
// [Luca] [Stocco] [1125280]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

import it.unipd.tos.model.typeItem;;

public class MenuItem {
    private typeItem itemType;
    private String name;
    private double price;

    public MenuItem(typeItem t, String n, double p) {
        itemType = t;
        name = n;
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public typeItem getItemType() {
        return itemType;
    }
}
