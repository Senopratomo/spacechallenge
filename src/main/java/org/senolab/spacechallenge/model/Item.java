package org.senolab.spacechallenge.model;

public class Item {
    //variable to store name of the Item
    private String name;
    //variable to store the weight of the Item
    private int weight;

    /**
     * Item constructor to create instance of Item class with 'name' and 'weight' specified
     * @param name name of the item
     * @param weight weight of the item
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Method that return the name of the Item
     * @return String name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Method that set the name of the Item
     * @param name String which will be the name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that return the weight of the Item
     * @return int weight of the Item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Method that set the weight of the Item
     * @param weight int the weight to be assigned to the Item
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
