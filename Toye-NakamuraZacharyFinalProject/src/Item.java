/**
 * This class contains all the information for an item in a store,
 */
public class Item implements Comparable<Item> {
    protected String name; // The name of the item
    protected String description; // The item's description. A short blurb about the item and what it is.
    protected String itemId; // The item's id code
    protected String business; // The business/manufacturer/producer that made/produced the item
    protected double price; // The price that the item is sold to consumers before tax
    protected double buyPrice; // The price of the item that the store buys it for (there is never tax for this)
    protected int stockLeft; // The amount of items the store has left
    protected int restockAmt; // The amount of items the store restocks to when they restock

    protected boolean isTaxed; // If the item is taxed or not.
    public final int INF = (int)0x3f3f3f3f; // A return value for invalid
    

    /**
     * Creates an item with all it's attributes
     *
     * @param name The name of the item
     * @param description A short description of the item
     * @param itemId The item's id
     * @param business The business that made the item
     * @param price The price of the item
     * @param buyPrice The price the store buys the item for
     * @param restockAmt The Amount that the store buys when re-stocking
     */
    public Item(String name, String description, String itemId, String business, double price, double buyPrice,
                int restockAmt) {
        this.name = name;
        this.description = description;
        this.itemId = itemId;
        this.business = business;
        this.price = price;
        this.buyPrice = buyPrice;
        this.restockAmt = restockAmt;
        this.stockLeft = restockAmt;
        isTaxed = true;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getItemId() {
        return itemId;
    }

    public double getPrice() {
        return price;
    }

    public int getStockLeft() {
        return stockLeft;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public boolean isTaxed() {
        return isTaxed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * The store sold some amount of this item.
     * Return codes:
     * -INF if there isn't enough stock left
     * Otherwise the amount of profit made. (Tax is not profit)
     *
     * @param amount the amount of the item is bought
     * @return The net profit made by the store.
     */
    public double sell(int amount) {
        if(amount > stockLeft) return -INF;
        stockLeft -= amount;
        return amount * (price - buyPrice);
    }

    /**
     * Compares 2 items lexicographically, if they have the same name, then it compares them by item id.
     *
     * @param i the object to be compared.
     * @return 0< if this object should come before i, and >0 if i should come before this object.
     */
    @Override
    public int compareTo(Item i) {
        if (this.name.compareTo(i.name) != 0) {
            return this.name.compareTo(i.name);
        }
        return this.itemId.compareTo(i.itemId);
    }

    /**
     * Formats a string nicely for output to the user. The description of the item should always
     * be at the bottom of the information. It only displays the information a customer and/or cashier 
     * would need to see. 
     *
     * @return A string nicely formatted with all the information of the item.
     */
    @Override
    public String toString() {
        return  "Name:  " + name + "\n" +
                "Id:    " + itemId + "\n" +
                "Price: $" + price + "\n" +
                "Stock Left: " + stockLeft + "\n" +
                "Manufacturer: " + business + "\n" +
                "Description: " + description;
    }

}
