package SimulationConcrete.Fourmille;

public class ComportementExploratrice implements Comportement {
    
    @Override
    public void agir(Agent agent) {
        int x = agent.getPosition().getX();
        int y = agent.getPosition().getY();
        int borneX = agent.getEnvironnement().getTailleX();
        int borneY = agent.getEnvironnement().getTailleY();

        int deplacementX = (int) (Math.random() * 3) - 1;
        int deplacementY = (int) (Math.random() * 3) - 1;

        
    }
}
