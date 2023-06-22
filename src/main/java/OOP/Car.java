package OOP;

public class Car {
    private String vinNumber = "AY1911";
    public String carPlate = "hyg 6778";
    protected String enginePower= "650ghp";


    public String getEnginePower()
    {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
}
