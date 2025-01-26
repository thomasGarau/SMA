package SimulationConcrete.Fourmille;

import Core.Position;

public class Main {
    public static void main(String[] args) {
        // Création de l'environnement des fourmis
        EnvironnementFourmi environnement = new EnvironnementFourmi();

        // Ajout de fragments avec nourriture
        FragmentInfourmilleEnvironement fragmentAvecNourriture1 = new FragmentInfourmilleEnvironement(5, 5);
        fragmentAvecNourriture1.ajouterNourriture(new Nourriture(10));
        environnement.setFragment(fragmentAvecNourriture1, 5, 5);

        FragmentInfourmilleEnvironement fragmentAvecNourriture2 = new FragmentInfourmilleEnvironement(8, 3);
        fragmentAvecNourriture2.ajouterNourriture(new Nourriture(15));
        environnement.setFragment(fragmentAvecNourriture2, 8, 3);

        FragmentInfourmilleEnvironement fragmentAvecNourriture3 = new FragmentInfourmilleEnvironement(4, 2);
        fragmentAvecNourriture3.ajouterNourriture(new Nourriture(15));
        environnement.setFragment(fragmentAvecNourriture3, 4, 2);

        FragmentInfourmilleEnvironement fragmentAvecNourriture4 = new FragmentInfourmilleEnvironement(9, 7);
        fragmentAvecNourriture4.ajouterNourriture(new Nourriture(15));
        environnement.setFragment(fragmentAvecNourriture4, 9, 7);


        // Création d'une petite colonie de fourmis
        for (int i = 0; i < 3; i++) {
            FourmiOuvriere ouvriere = new FourmiOuvriere();
            ouvriere.setPosition(new Position(1, 1 + i)); // Place chaque ouvrière sur une ligne
            environnement.getFragment(1, 1 + i).addObserver(ouvriere);
        }

        for (int i = 0; i < 7; i++) {
            FourmiExploratrice exploratrice = new FourmiExploratrice();
            exploratrice.setPosition(new Position(2 + i, 2)); // Place chaque exploratrice sur une colonne
            environnement.getFragment(2 + i, 2).addObserver(exploratrice);
        }

        // Création et lancement de la simulation
        SimulationFourmi simulation = new SimulationFourmi(environnement, 20);
        simulation.start();
    }
}
