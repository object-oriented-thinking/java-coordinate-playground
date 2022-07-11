package rentcompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {

    private static final String NEWLINE = System.getProperty("line.separator");
    private final List<Vehicle> vehicleList = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(final Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public String generateReport() {
        return vehicleList.stream()
            .map(Vehicle::report)
            .collect(Collectors.joining(NEWLINE)) + NEWLINE;
    }
}
