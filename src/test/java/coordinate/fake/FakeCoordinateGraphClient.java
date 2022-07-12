package coordinate.fake;

import coordinate.domain.Coordinate;
import coordinate.domain.CoordinateGraphClient;

public class FakeCoordinateGraphClient implements CoordinateGraphClient {
    @Override
    public boolean displayGraph(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        return firstCoordinate.getDistance(secondCoordinate) < 5;
    }
}
