package OOP;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        Car car1 = new Chevy();

        car1.setVinNumber("gff");
        System.out.println(car1.getVinNumber());

    }
}
