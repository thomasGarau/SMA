package Core;

public class Environement {
    // create a 10x10 grid of fragments
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private Fragment[][] fragments = new Fragment[WIDTH][HEIGHT];

    public Environement() {
    }

    public Fragment getFragment(int positionX, int positionY) {
        return this.fragments[positionX][positionY];
    }

    public void setFragment(Fragment fragment, int positionX, int positionY) {
        this.fragments[positionX][positionY] = fragment;
    }

    public void MoveAgent(Agent agent, int newX, int newY) {
        //check if the new position is within the bounds of the environment
        if (newX < 0 || newX >= WIDTH || newY < 0 || newY >= HEIGHT) {
            throw new IllegalArgumentException("New position is out of bounds.");
        }
        Fragment oldFragment = this.getFragment(agent.getPosition().getPositionX(), agent.getPosition().getPositionY());
        Fragment newFragment = this.getFragment(newX, newY);
        if (newFragment != null) {
            agent.setPosition(new Position(newX, newY));
            oldFragment.removeObserver(agent);
            newFragment.addObserver(agent);
        }
    }


}