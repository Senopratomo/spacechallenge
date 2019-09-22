package org.senolab.spacechallenge.model;

/**
 * U1 class which inherit Rocket class
 */
public class U1 extends Rocket {

    /**
     * U1 constructor class to create U1 instance and assign its property with
     * cost, weight, and maxWeight properties associated with U1 rocket
     *
     */
    public U1() {
        weight = 10;
        cost = 100;
        maxWeight = 18;
    }

    /**
     * Method that return whether the U1 rocket instance launch successfully
     * This method override the parent Rocket class
     * @return boolean true if the U1 rocket launch successfully, false if it crash during launch
     */
    @Override
    public boolean launch() {
        int randomNum = (int) (Math.random()*101);
        return (5 * (weight/maxWeight)) < randomNum;
    }

    /**
     * Method that return whether the U1 rocket land successfully
     * This method override the parent Rocket class
     * @return boolean true if the U1 rocket land successfully, false if it crash landing
     */
    @Override
    public boolean land() {
        int randomNum = (int) (Math.random()*101);
        return (1 * (weight/maxWeight) < randomNum);
    }
}
