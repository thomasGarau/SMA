package SimulationConcrete.Fourmille;

import java.util.ArrayList;
import java.util.List;

import Core.Agent;
import Core.Environement;
import Core.Fragment;
import Core.Simulation;

public class SimulationFourmi extends Simulation {

    public SimulationFourmi(Environement environment, int maxTicks) {
        super(environment, maxTicks);
    }

    @Override
    protected void updateEnvironment() {
        super.updateEnvironment();
        
        afficherEnvironnement();
    }

    private void afficherEnvironnement() {
        System.out.println("\n--- État de l'environnement ---");
        for (int i = 0; i < Environement.WIDTH; i++) {
            for (int j = 0; j < Environement.HEIGHT; j++) {
                Fragment fragment = super.environment.getFragment(i, j);
    
                StringBuilder contenu = new StringBuilder(); // Contenu de la case
    
                // Vérifie si le fragment est une instance de FragmentInfourmilleEnvironement
                if (fragment instanceof FragmentInfourmilleEnvironement) {
                    FragmentInfourmilleEnvironement f = (FragmentInfourmilleEnvironement) fragment;
    
                    // Ajoute les phéromones
                    if (f.getPheromone() instanceof PheromoneNourriture) {
                        contenu.append("PN"); // Phéromone de nourriture
                    } else if (f.getPheromone() instanceof PheromoneCaseVide) {
                        contenu.append("PV"); // Phéromone de case vide
                    }
    
                    // Ajoute la nourriture
                    if (f.getNourriture() != null && !f.getNourriture().isEmpty()) {
                        if (contenu.length() > 0) contenu.append("|"); // Séparateur si plusieurs éléments
                        contenu.append("N");
                    }
                }
    
                // Ajoute les agents
                if (!fragment.getAgents().isEmpty()) {
                    if (contenu.length() > 0) contenu.append("|"); // Séparateur si plusieurs éléments
                    int nbOuvrieres = (int) fragment.getAgents().stream()
                            .filter(agent -> agent instanceof FourmiOuvriere)
                            .count();
                    int nbExploratrices = (int) fragment.getAgents().stream()
                            .filter(agent -> agent instanceof FourmiExploratrice)
                            .count();
    
                    if (nbOuvrieres > 0) contenu.append("O").append(nbOuvrieres); // Ajoute le nombre d'ouvrières
                    if (nbExploratrices > 0) {
                        if (nbOuvrieres > 0) contenu.append(","); // Séparateur entre types de fourmis
                        contenu.append("E").append(nbExploratrices); // Ajoute le nombre d'exploratrices
                    }
                }
    
                // Si le fragment est un terrier
                if (fragment instanceof TerrierFragment) {
                    contenu.append("T");
                }
    
                // Si la case est vide
                if (contenu.length() == 0) {
                    contenu.append(" ");
                }
    
                // Affiche le contenu de la case
                System.out.print("[" + contenu + "]");
            }
            System.out.println();
        }
    }
    
    
}
