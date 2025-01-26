package Core;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private int tick = 0;
    private int timePerTick = 1000; // 1 seconde per tick  
    protected Environement environment;
    private int maxTicks;

    public Simulation(Environement environment, int maxTicks) {
        this.environment = environment;
        this.maxTicks = maxTicks;
    }

    // Start the simulation
    public void start() {
        System.out.println("Simulation started.");

        while (tick < maxTicks) {
            tick();
            try {
                Thread.sleep(timePerTick); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Simulation interrupted", e);
            }
        }

        System.out.println("Simulation ended after " + maxTicks + " ticks.");
    }

    private void tick() {
        tick++;
        System.out.println("Tick: " + tick);
        updateEnvironment();
    }

    // update the environement at each tick
protected void updateEnvironment() {
    for (int i = 0; i < Environement.WIDTH; i++) {
        for (int j = 0; j < Environement.HEIGHT; j++) {
            Fragment fragment = environment.getFragment(i, j);

            // Crée une copie de la liste des agents pour éviter les modifications concurrentes
            List<Agent> agents = new ArrayList<>(fragment.getAgents());

            // Parcours la copie pour exécuter l'action de chaque agent
            for (Agent agent : agents) {
                agent.action(environment);
            }
        }
    }
}

}
