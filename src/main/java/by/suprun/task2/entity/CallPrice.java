package by.suprun.task2.entity;

import java.util.Objects;
import java.util.OptionalInt;

public class CallPrice {
    private Integer costInNetworkCalls;
    private Integer costOffNetworkCalls;
    private Integer costLandlinePhoneCalls;

    public Integer getCostInNetworkCalls() {
        return costInNetworkCalls;
    }

    public void setCostInNetworkCalls(Integer costInNetworkCalls) {
        this.costInNetworkCalls = costInNetworkCalls;
    }

    public Integer getCostOffNetworkCalls() {
        return costOffNetworkCalls;
    }

    public void setCostOffNetworkCalls(Integer costOffNetworkCalls) {
        this.costOffNetworkCalls = costOffNetworkCalls;
    }

    public Integer getCostLandlinePhoneCalls() {
        return costLandlinePhoneCalls;
    }

    public void setCostLandlinePhoneCalls(Integer costLandlinePhoneCalls) {
        this.costLandlinePhoneCalls = costLandlinePhoneCalls;
    }

    public CallPrice(Integer costInNetworkCalls, Integer costOffNetworkCalls, Integer costLandlinePhoneCalls) {
        this.costInNetworkCalls = costInNetworkCalls;
        this.costOffNetworkCalls = costOffNetworkCalls;
        this.costLandlinePhoneCalls = costLandlinePhoneCalls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CallPrice callPrice = (CallPrice) o;
        return Objects.equals(costInNetworkCalls, callPrice.costInNetworkCalls) && Objects.equals(costOffNetworkCalls,
                callPrice.costOffNetworkCalls) && Objects.equals(costLandlinePhoneCalls, callPrice.costLandlinePhoneCalls);
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + getCostInNetworkCalls()
                + getCostOffNetworkCalls() + getCostLandlinePhoneCalls() * 2;
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CallPrice{");
        sb.append("cost in network calls ='").append(costInNetworkCalls);
        sb.append(", cost off network  calls=").append(costOffNetworkCalls);
        sb.append(", cost land line phone calls=").append(costLandlinePhoneCalls);
        sb.append('}');
        return sb.toString();
    }
}
