package SimulationConcrete.Fourmille;

import Core.Agent;
import Core.Environement;
import Core.Fragment;
import Core.Position;

public class EnvironnementFourmi extends Environement {
    private TerrierFragment terrier;

    public EnvironnementFourmi() {
        super();
        // Remplace le premier fragment par un terrier
        this.terrier = new TerrierFragment(0, 0);
        super.setFragment(this.terrier, 0, 0);
    }

    public TerrierFragment getTerrier() {
        return this.terrier;
    }

}
