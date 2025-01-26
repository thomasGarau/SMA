package SimulationConcrete.Fourmille;

import Core.Environement;

public class EnvironnementFourmi extends Environement {
    private TerrierFragment terrier;

    public EnvironnementFourmi() {
        // Appel au constructeur parent
        super();

        // Initialise tous les fragments comme FragmentInfourmilleEnvironement
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                this.setFragment(new FragmentInfourmilleEnvironement(i, j), i, j);
            }
        }

        // Remplace le fragment en (0, 0) par un terrier
        this.terrier = new TerrierFragment(0, 0);
        this.setFragment(this.terrier, 0, 0);
    }

    public TerrierFragment getTerrier() {
        return this.terrier;
    }
}
