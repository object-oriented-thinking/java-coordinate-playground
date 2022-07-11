package rent.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private final List<Car> carList = new ArrayList<>();
    private static final String NEWLINE = System.getProperty("line.separator");

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public String generateReport() {
        StringBuilder result = new StringBuilder();
        for(Car c: carList){
            result.append(c.getName()).append(" : ").append((int) c.getChargeQuantity()).append("리터").append(NEWLINE);
        }
        return result.toString();
    }
}
