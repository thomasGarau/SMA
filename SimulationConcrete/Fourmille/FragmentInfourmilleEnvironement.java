package SimulationConcrete.Fourmille;

import java.util.ArrayList;
import java.util.List;

import Core.Fragment;

public class FragmentInfourmilleEnvironement extends Fragment {
    private List<Nourriture> nourriture; // Remplace le tableau par une liste
    private Pheromone pheromone;

    public FragmentInfourmilleEnvironement(int positionX, int positionY) {
        super(positionX, positionY);
        this.nourriture = new ArrayList<>(); // Initialise une liste vide
    }

    public void ajouterNourriture(Nourriture nourriture) {
        this.nourriture.add(nourriture); // Ajoute la nourriture à la liste
    }

    public List<Nourriture> getNourriture() {
        return nourriture; // Retourne la liste de nourriture
    }

    public Pheromone getPheromone() {
        return pheromone;
    }

    public void setPheromone(Pheromone pheromone) {
        this.pheromone = pheromone;
    }

    public void retirerNouriture(FourmiOuvriere fourmi) {
        int valeurRecolte = 0;
        int i = 0;

        // Parcourt la liste jusqu'à obtenir 2 unités de nourriture ou épuiser la liste
        while (valeurRecolte < 2 && i < this.nourriture.size()) {
            Nourriture aliment = this.nourriture.get(i);
            if (aliment.getValeurNutritive() > 0) {
                int aRecolter = Math.min(2 - valeurRecolte, aliment.getValeurNutritive());
                valeurRecolte += aRecolter;
                aliment.retirerValeurNutritive(aRecolter);

                // Si l'aliment est épuisé, le supprime de la liste
                if (aliment.getValeurNutritive() <= 0) {
                    this.nourriture.remove(i);
                    i--; // Reviens à l'indice précédent après suppression
                }
            }
            i++;
        }

        fourmi.addNourtirure(valeurRecolte);
    }
}
