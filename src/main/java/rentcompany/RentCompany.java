package rentcompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {

    private static final String NEWLINE = System.getProperty("line.separator");
    private final List<Car> carList = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public String generateReport() {
        return carList.stream()
            .map(Car::report)
            .collect(Collectors.joining(NEWLINE)) + NEWLINE;
    }
}
