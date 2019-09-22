package org.senolab.spacechallenge.model;

/**
 * U2 class which inherit Rocket class
 */
public class U2 extends Rocket {

    /**
     * U2 constructor class to create U2 instance and assign its property with
     * cost, weight, and maxWeight properties associated with U2 rocket
     *
     */
    public U2() {
        cost = 120;
        weight = 18;
        maxWeight = 29;
    }

    /**
     * Method that return whether the U2 rocket instance launch successfully
     * This method override the parent Rocket class
     * @return boolean true if the U2 rocket launch successfully, false if it crash during launch
     */
    @Override
    public boolean launch() {
        int randomNum = (int) (Math.random()*101);
        return (4 * (weight/maxWeight)) < randomNum;
    }

    /**
     * Method that return whether the U2 rocket land successfully
     * This method override the parent Rocket class
     * @return boolean true if the U2 rocket land successfully, false if it crash landing
     */
    @Override
    public boolean land() {
        int randomNum = (int) (Math.random()*101);
        return (8 * (weight/maxWeight)) < randomNum;
    }

}
