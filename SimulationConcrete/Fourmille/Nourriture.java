package SimulationConcrete.Fourmille;

public class Nourriture {
    private int valeurNutritive;

    public Nourriture(int valeurNutritive) {
        this.valeurNutritive = valeurNutritive;
    }

    public int getValeurNutritive() {
        return this.valeurNutritive;
    }

    public void setValeurNutritive(int valeurNutritive) {
        this.valeurNutritive = valeurNutritive;
    }

    public void retirerValeurNutritive(int quantite) {
        this.valeurNutritive -= quantite;
    }
    
}