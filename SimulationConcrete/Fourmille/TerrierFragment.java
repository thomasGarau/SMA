package SimulationConcrete.Fourmille;

import Core.Agent;
import Core.Fragment;

public class TerrierFragment extends Fragment {
    private int nourritureStockee = 0;

    public TerrierFragment(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public void ajouterNourriture(int quantite) {
        this.nourritureStockee += quantite;
    }

    public int getNourritureStockee() {
        return nourritureStockee;
    }

    public void setNourritureStockee(int nourritureStockee) {
        this.nourritureStockee = nourritureStockee;
    }

    public void retirerNourriture(int quantite) {
        this.nourritureStockee -= quantite;
    }

}
