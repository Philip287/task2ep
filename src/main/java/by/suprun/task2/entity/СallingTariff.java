package by.suprun.task2.entity;

import java.time.LocalDate;
import java.util.OptionalInt;

public class СallingTariff extends AbstractTariff {
    private int preferredNumber;
    private int costInNetworkCalls;
    private int costOffNetworkCalls;
    private int costLandlinePhoneCalls;

    public СallingTariff() {
        super();
    }

    public СallingTariff(String id, String tariffName, OperatorName operatorName, int monthPayRoll, int smsPrise,
                         int costConnect, LocalDate dateСonnectingTariff, int preferredNumber, int costInNetworkCalls,
                         int costOffNetworkCalls, int costLandlinePhoneCalls, Roaming roaming) {
        super(id, tariffName, operatorName, monthPayRoll, smsPrise, costConnect, dateСonnectingTariff, roaming);
        this.preferredNumber = preferredNumber;
        this.costInNetworkCalls = costInNetworkCalls;
        this.costOffNetworkCalls = costOffNetworkCalls;
        this.costLandlinePhoneCalls = costLandlinePhoneCalls;
    }

    public int getPreferredNumber() {
        return preferredNumber;
    }

    public void setPreferredNumber(int preferredNumber) {
        this.preferredNumber = preferredNumber;
    }

    public int getCostInNetworkCalls() {
        return costInNetworkCalls;
    }

    public void setCostInNetworkCalls(int costInNetworkCalls) {
        this.costInNetworkCalls = costInNetworkCalls;
    }

    public int getCostOffNetworkCalls() {
        return costOffNetworkCalls;
    }

    public void setCostOffNetworkCalls(int costOffNetworkCalls) {
        this.costOffNetworkCalls = costOffNetworkCalls;
    }

    public int getCostLandlinePhoneCalls() {
        return costLandlinePhoneCalls;
    }

    public void setCostLandlinePhoneCalls(int costLandlinePhoneCalls) {
        this.costLandlinePhoneCalls = costLandlinePhoneCalls;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        СallingTariff that = (СallingTariff) obj;
        if (getId() != that.getId()) {
            return false;
        }
        if (getMonthPayRoll() != that.getMonthPayRoll()) {
            return false;
        }
        if (getSmsPrise() != that.getSmsPrise()) {
            return false;
        }
        if (getCostConnect() != that.getCostConnect()) {
            return false;
        }
        if (!getTariffName().equals(that.getTariffName())) {
            return false;
        }
        if (!getOperatorName().equals(that.getOperatorName())) {
            return false;
        }
        if (!getDateСonnectingTariff().equals(that.getDateСonnectingTariff())) {
            return false;
        }
        if (getPreferredNumber() != that.getPreferredNumber()) {
            return false;
        }
        if (getCostInNetworkCalls() != that.getCostInNetworkCalls()) {
            return false;
        }
        if (getCostOffNetworkCalls() != that.getCostOffNetworkCalls()) {
            return false;
        }
        if (getCostLandlinePhoneCalls() != that.getCostLandlinePhoneCalls()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode() + preferredNumber + costInNetworkCalls +
                +costOffNetworkCalls + costLandlinePhoneCalls * 2;
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Calling price by{" + AbstractTariff.class);
        sb.append(": id ='").append(getId());
        sb.append(": tariff name ='").append(getTariffName());
        sb.append(", operator name =").append(getOperatorName());
        sb.append(", month pay roll=").append(getMonthPayRoll());
        sb.append(", sms prise=").append(getSmsPrise());
        sb.append(", cost connect=").append(getCostConnect());
        sb.append(", preferred number=").append(preferredNumber);
        sb.append(", cost in network calls=").append(costInNetworkCalls);
        sb.append(", cost off network calls=").append(costOffNetworkCalls);
        sb.append(", cost landline phone calls=").append(costLandlinePhoneCalls);
        sb.append(", roaming").append(getRoaming());
        sb.append('}');
        return sb.toString();
    }
}
