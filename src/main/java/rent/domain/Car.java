package rent.domain;

public abstract class Car {
    /**
     * 리터당 이동 거리. 즉, 연비
     */
    abstract public double getDistancePerLiter();

    /**
     * 여행하려는 거리
     */
    abstract public double getTripDistance();

    /**
     * 차종의 이름
     */
    abstract public String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
