package karin;

import java.util.ArrayList;

 //SalesSlip stores all SalesItem objects in a list.

 //It can add items and compute the total sales.

public class SalesSlip {

    private ArrayList<SalesItem> items;

    public SalesSlip() {
        items = new ArrayList<SalesItem>();
    }

    // Adds one item to the slip
    public void addItem(SalesItem item) {
        items.add(item);
    }

    // Adds up totals from every SalesItem
    public double getTotalSales() {
        double total = 0.0;

        for (SalesItem item : items) {
            total = total + item.getItemTotal();
        }

        return total;
    }

    @Override
    public String toString() {
        String output = "";

        for (SalesItem item : items) {
            output = output + item.toString() + "\n";
        }

        return output;
    }
}
