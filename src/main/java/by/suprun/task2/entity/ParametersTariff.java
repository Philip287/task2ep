package by.suprun.task2.entity;

import java.util.Objects;
import java.util.OptionalInt;

public class ParametersTariff {
    private OptionalInt preferredNumber;
    private boolean cost12secCollin;
    private boolean cost60secCollin;
    private OptionalInt costCollin;
    private OptionalInt costConnect;

    public ParametersTariff(OptionalInt preferredNumber, boolean cost12secCollin,
                            boolean cost60secCollin, OptionalInt costCollin, OptionalInt costConnect) {
        this.preferredNumber = preferredNumber;
        this.cost12secCollin = cost12secCollin;
        this.cost60secCollin = cost60secCollin;
        this.costCollin = costCollin;
        this.costConnect = costConnect;
    }

    public OptionalInt getPreferredNumber() {
        return preferredNumber;
    }

    public void setPreferredNumber(OptionalInt preferredNumber) {
        this.preferredNumber = preferredNumber;
    }

    public Boolean getCost12secCollin() {
        return cost12secCollin;
    }

    public void setCost12secCollin(Boolean cost12secCollin) {
        this.cost12secCollin = cost12secCollin;
    }

    public Boolean getCost60secCollin() {
        return cost60secCollin;
    }

    public void setCost60secCollin(Boolean cost60sec) {
        this.cost60secCollin = cost60sec;
    }

    public OptionalInt getCostCollin() {
        return costCollin;
    }

    public void setCostCollin(OptionalInt costCollin) {
        this.costCollin = costCollin;
    }

    public OptionalInt getCostConnect() {
        return costConnect;
    }

    public void setCostConnect(OptionalInt costConnect) {
        this.costConnect = costConnect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametersTariff that = (ParametersTariff) o;
        return cost12secCollin == that.cost12secCollin && cost60secCollin == that.cost60secCollin
                && Objects.equals(preferredNumber, that.preferredNumber)
                && Objects.equals(costCollin, that.costCollin)
                && Objects.equals(costConnect, that.costConnect);
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + getPreferredNumber().getAsInt()
                + getCost12secCollin().hashCode() + getCost60secCollin().hashCode() + getCostConnect().getAsInt()
                + getCostCollin().getAsInt() * 2;
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Parameters tariff{");
        sb.append("preferred number ='").append(preferredNumber);
        sb.append(", cost 12 sec collin=").append(cost12secCollin);
        sb.append(", cost 60 sec collin=").append(cost60secCollin);
        sb.append(", cost collin=").append(costCollin);
        sb.append(", cost connect=").append(costConnect);
        sb.append('}');
        return sb.toString();
    }
}
