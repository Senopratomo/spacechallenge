package org.senolab.spacechallenge.model;

/**
 * Spaceship interface which will be use as the model for Rocket and its child U1 and U2
 *
 */
public interface Spaceship {

    public boolean launch();

    public boolean land();

    public boolean canCarry(Item item);

    public void carry(Item item);
}
