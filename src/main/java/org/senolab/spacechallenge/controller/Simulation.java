package org.senolab.spacechallenge.controller;

import org.senolab.spacechallenge.model.Item;
import org.senolab.spacechallenge.model.Rocket;
import org.senolab.spacechallenge.model.U1;
import org.senolab.spacechallenge.model.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public Simulation() { }


    public ArrayList<Item> loadItems(File itemFile) throws FileNotFoundException {
        ArrayList<Item> listOfItems = new ArrayList<Item>();
        Scanner scanner = new Scanner(itemFile);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] textItem = line.split("=");
            Item item = new Item(textItem[0], Integer.parseInt(textItem[1]) / 1000);
            listOfItems.add(item);
        }
        return listOfItems;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> listOfItems) {
        ArrayList<Rocket> u1Rockets = new ArrayList<Rocket>();
        int counterItem = 0;
        while(counterItem < listOfItems.size()) {
            Rocket u1 = new U1();
            while(counterItem < listOfItems.size() && u1.canCarry(listOfItems.get(counterItem))) {
                u1.carry(listOfItems.get(counterItem));
                counterItem++;
            }
            u1Rockets.add(u1);
        }
        return u1Rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> listOfItems) {
        ArrayList<Rocket> u2Rockets = new ArrayList<Rocket>();
        int counterItem = 0;
        while(counterItem < listOfItems.size()) {
            Rocket u2 = new U2();
            while(counterItem < listOfItems.size() && u2.canCarry(listOfItems.get(counterItem))) {
                u2.carry(listOfItems.get(counterItem));
                counterItem++;
            }
            u2Rockets.add(u2);
        }
        return u2Rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int rocketCounter = 0;
        int totalBudget = 0;
        while(rocketCounter < rockets.size()) {
            boolean launchedSuccessfully = rockets.get(rocketCounter).launch();
            boolean landedSuccessfully = rockets.get(rocketCounter).land();
            if(launchedSuccessfully && landedSuccessfully) {
                System.out.println("Rocket# "+rocketCounter + " launched and landed successfully with cargo!");
                totalBudget += rockets.get(rocketCounter).getCost();
                rocketCounter++;
            } else {
                if(!launchedSuccessfully && !landedSuccessfully) {
                    System.out.println("Rocket# "+rocketCounter + " crash during launch! Re-launch required");
                    totalBudget += rockets.get(rocketCounter).getCost();
                }
                if(launchedSuccessfully && !landedSuccessfully) {
                    System.out.println("Rocket# "+rocketCounter + " launched successfully, but crash during landing! Re-launch required");
                    totalBudget += rockets.get(rocketCounter).getCost();
                }
            }
        }
        return totalBudget;
    }

}
