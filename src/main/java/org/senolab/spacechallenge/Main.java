package org.senolab.spacechallenge;

import org.senolab.spacechallenge.controller.Simulation;
import org.senolab.spacechallenge.model.Item;
import org.senolab.spacechallenge.model.Rocket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    /**
     * Main method which is the entry point to this app
     * It accept one String argument (args[0]) which is the type of the rocket to simulate
     * @param args arguments pass to the main method (see above for acceptable argument)
     */
    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            System.out.println("Please specify 3 arguments: \n" +
                    "- Name of the rocket to run simulation on.\n" +
                    "- Full absolute path of the phase 1 file containing items to load.\n" +
                    "- Full absolute path of the phase 2 file containing items to load.\n" +
                    "\n" +
                    "Example:\n" +
                    "java -jar target\\runsimulation.jar U1 /home/user/phase-1.txt home/user/phase-2.txt");
            System.exit(0);
        }
        var totalBudgetForAllPhases = 0;
        try {
            switch (args[0]) {
                case "U1":
                    for(var i=1; i < args.length; i++) {
                        totalBudgetForAllPhases += simulate("U1", args[i]);
                    }
                    break;
                case "U2":
                    for(var i=1; i < args.length; i++) {
                        totalBudgetForAllPhases += simulate("U2", args[i]);
                    }
                    break;
                default:
                    System.out.println("Unidentified rocket model! Please try again with the correct rocket model!");
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("The file containing the load is not found");
            System.out.println(fnfe.getStackTrace());
        }
        System.out.println("Total Budget for all phases: "+totalBudgetForAllPhases+" million dollars");

    }

    /**
     * Method which will run simulation on specific rocket type
     * @param rocketType type of rocket to run simulation on
     * @throws FileNotFoundException throw exception when the "Phase" file doesn't exist
     */
    private static int simulate(String rocketType, String filePath) throws FileNotFoundException {
        System.out.println("Creating simulation....");
        Simulation simulation = new Simulation();
        System.out.println("Loading item from "+filePath+" .....");
        var phaseItems = simulation.loadItems(new File(filePath));
        System.out.println(phaseItems.size()+" items loaded!");
        System.out.println("Preparing fleet of "+ rocketType +" rockets for the phase....");
        var RocketFleetPhase = new ArrayList<Rocket>();
        if (rocketType.equalsIgnoreCase("U1")) {
            RocketFleetPhase = simulation.loadU1(phaseItems);
            System.out.println(RocketFleetPhase.size()+" rockets loaded for this phase");
        } else if (rocketType.equalsIgnoreCase("U2")) {
            RocketFleetPhase = simulation.loadU2(phaseItems);
            System.out.println(RocketFleetPhase.size()+" rockets loaded for this phase");
        }
        System.out.println("Run simulation for "+rocketType+" rocket for this phase....");
        var totalCostForPhase = simulation.runSimulation(RocketFleetPhase);
        System.out.println("Total cost for this phase: "+totalCostForPhase+" million dollars");
        return totalCostForPhase;
    }

}
