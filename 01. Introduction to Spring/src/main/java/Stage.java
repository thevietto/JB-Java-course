public class Stage {

    private static Stage INSTANCE;

    public String location;

    private Stage() {
        location = "Университетская 1";
    }

    public static Stage getStage() {
        if (INSTANCE == null) {
            INSTANCE = new Stage();
        }
        return INSTANCE;
    }

}
