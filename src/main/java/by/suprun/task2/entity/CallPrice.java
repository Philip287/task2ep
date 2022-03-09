package by.suprun.task2.entity;

import java.util.Objects;
import java.util.OptionalInt;

public class CallPrice {
    private OptionalInt costInNetworkCalls;
    private OptionalInt costOffNetworkCalls;
    private OptionalInt costLandlinePhoneCalls;

    public OptionalInt getCostInNetworkCalls() {
        return costInNetworkCalls;
    }

    public void setCostInNetworkCalls(OptionalInt costInNetworkCalls) {
        this.costInNetworkCalls = costInNetworkCalls;
    }

    public OptionalInt getCostOffNetworkCalls() {
        return costOffNetworkCalls;
    }

    public void setCostOffNetworkCalls(OptionalInt costOffNetworkCalls) {
        this.costOffNetworkCalls = costOffNetworkCalls;
    }

    public OptionalInt getCostLandlinePhoneCalls() {
        return costLandlinePhoneCalls;
    }

    public void setCostLandlinePhoneCalls(OptionalInt costLandlinePhoneCalls) {
        this.costLandlinePhoneCalls = costLandlinePhoneCalls;
    }

    public CallPrice(OptionalInt costInNetworkCalls, OptionalInt costOffNetworkCalls, OptionalInt costLandlinePhoneCalls) {
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
        hashCode = 31 * hashCode + getCostInNetworkCalls().getAsInt()
                + getCostOffNetworkCalls().getAsInt() + getCostLandlinePhoneCalls().getAsInt() * 2;
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
