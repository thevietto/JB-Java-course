
public class PoeticJuggler extends Juggler{

    private Poem poem;

    public PoeticJuggler(Poem poem) {
        this.poem = poem;
    }

    public PoeticJuggler(int balls, Poem poem) {
        super(balls);
        this.poem = poem;
    }

    public Poem getPoem() {
        return poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }

    @Override
    public void perform() {
        super.perform();
        poem.recite();
    }
}
