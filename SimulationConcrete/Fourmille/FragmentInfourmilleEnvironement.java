package SimulationConcrete.Fourmille;

import Core.Fragment;

public class FragmentInfourmilleEnvironement extends Fragment {
    private Nourriture[] nourriture;
    private Pheromone pheromone;

    public FragmentInfourmilleEnvironement(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public void ajouterNourriture(Nourriture nourriture) {
        this.nourriture[this.nourriture.length] = nourriture;
    }

    public Nourriture[] getNourriture() {
        return nourriture;
    }

    public Pheromone getPheromone() {
        return pheromone;
    }

    public void setPheromone(Pheromone pheromone) {
        this.pheromone = pheromone;
    } 

    public void retirerNouriture(FourmiOuvriere fourmi) {
        int valeurRecolte = 0;
        int maxIteration = 100;
        int i = 0;
        while (valeurRecolte < 2 && i < this.nourriture.length || i >= maxIteration) {
            if (this.nourriture[i].getValeurNutritive() > 0) {
                valeurRecolte += Math.min(2 - valeurRecolte, this.nourriture[i].getValeurNutritive());
                this.nourriture[i].retirerValeurNutritive(valeurRecolte);
                if(this.nourriture[i].getValeurNutritive() <= 0) {
                    this.nourriture[i] = null;
                    i--;
                }
            }
            i++;
        }
        fourmi.addNourtirure(valeurRecolte);
    }
    
    
}
