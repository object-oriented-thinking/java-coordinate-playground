package coordinate.fake;

import coordinate.domain.CoordinateInputClient;

public class FakeCoordinateInputClient implements CoordinateInputClient {
    @Override
    public String inputString() {
        return "(10,10)-(14,15)";
    }
}
