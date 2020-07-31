package airplane;

public class Airplane {

    private static final String COMMERCIAL_FLIGTH = "Commercial";
    private static final String PRIVATE_FLIGTH = "Private";

    private static final String MODEL_BOING = "Boing";
    private static final String MODEL_JET = "Jet";

    private String model;

    public Airplane() { }

    public Airplane(String model) {
        this.model = model;
    }

    public String getType() {
        if(model.equals(MODEL_BOING)) {
            return COMMERCIAL_FLIGTH;
        } else if (model.equals(MODEL_JET)) {
            return PRIVATE_FLIGTH;
        } else {
            throw new IllegalArgumentException("Flight Type not found");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}