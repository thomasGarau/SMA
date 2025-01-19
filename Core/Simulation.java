package Core;

public class Simulation {
    private int tick = 0;
    private int timePerTick = 1000; // 1 seconde per tick  
    private Environement environment;
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
    private void updateEnvironment() {
        for (int i = 0; i < Environement.WIDTH; i++) {
            for (int j = 0; j < Environement.HEIGHT; j++) {
                Fragment fragment = environment.getFragment(i, j);

                // make agents move and act
                for (Agent agent : fragment.getAgents()) {
                    agent.seDeplacer();
                    agent.agir(); 
                }
            }
        }
    }
}
