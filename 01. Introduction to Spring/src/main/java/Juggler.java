
public class Juggler implements Performer {

    private int balls = 3;

    public Juggler(int balls) {
        this.balls = balls;
    }

    public Juggler() {
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public void perform() {
        System.out.println("I am jungling " + balls + " balls");
    }
}
