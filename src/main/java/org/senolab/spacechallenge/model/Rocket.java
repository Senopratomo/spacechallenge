package org.senolab.spacechallenge.model;

/**
 * Rocket class which implement Spaceship interface
 *
 */
public class Rocket implements Spaceship {
    //variable that store the cost of the rocket
    int cost;
    //variable that store the weight of the rocket
    int weight;
    //variable that store the maximum weight the rocket can carry
    int maxWeight;

    /**
     * Method that return whether the rocket launch successfully
     * To be implemented by the child class
     * @return boolean true
     */
    public boolean launch() {
        return true;
    }

    /**
     * Method that return whether the rocket land successfully
     * To be implemented by the child class
     * @return boolean true
     */
    public boolean land() {
        return true;
    }

    /**
     * Method that return whether the rocket can carry this item
     *
     *
     * @param item the item to be loaded to the rocket
     * @return boolean true/false true = can carry this item, false = cannot carry this item
     */
    public boolean canCarry(Item item) {
        return maxWeight >= (weight+item.getWeight());
    }

    /**
     * Method that load the item to the rocket and add the Item weight to the rocket's weight
     *
     * @param item the item loaded to the rocket
     */
    public void carry(Item item) {
        weight+=item.getWeight();
    }

    /**
     * Method that return the cost of the rocket
     * @return int cost of the rocket (in million of dollar)
     */
    public int getCost() {
        return cost;
    }

    /**
     * Method that return the current total weight of the rocket (including all item which has been loaded)
     * @return int the current total weight of the rocket (in ton)
     */
    public int getCurrentWeight() {
        return weight;
    }
}
