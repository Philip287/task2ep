package by.suprun.task2.entity;

import java.time.LocalDate;
import java.util.Objects;

public class CallingTariff extends AbstractTariff {
    private int preferredNumber;
    private int costInNetworkCalls;
    private int costOffNetworkCalls;
    private int costLandlinePhoneCalls;

    public CallingTariff() {
        super();
    }

    public CallingTariff(String id, String tariffName, OperatorName operatorName, int monthPayRoll, int smsPrise,
                         int costConnect, LocalDate dateConnectingTariff, int preferredNumber, int costInNetworkCalls,
                         int costOffNetworkCalls, int costLandlinePhoneCalls, Roaming roaming) {
        super(id, tariffName, operatorName, monthPayRoll, smsPrise, costConnect, dateConnectingTariff, roaming);
        this.preferredNumber = preferredNumber;
        this.costInNetworkCalls = costInNetworkCalls;
        this.costOffNetworkCalls = costOffNetworkCalls;
        this.costLandlinePhoneCalls = costLandlinePhoneCalls;
    }

    public CallingTariff(String id, String tariffName, OperatorName operatorName,
                         int monthPayRoll, int smsPrise, int costConnect,
                         LocalDate dateConnectingTariff, int preferredNumber, int costInNetworkCalls,
                         int costOffNetworkCalls, int costLandlinePhoneCalls) {
        super(id, tariffName, operatorName, monthPayRoll, smsPrise, costConnect, dateConnectingTariff);
        this.preferredNumber = preferredNumber;
        this.costInNetworkCalls = costInNetworkCalls;
        this.costOffNetworkCalls = costOffNetworkCalls;
        this.costLandlinePhoneCalls = costLandlinePhoneCalls;
    }

    public static CallingTariff setNewCallingTariff(AbstractTariff tariff, int preferredNumber, int costInNetworkCalls,
                                                    int costOffNetworkCalls, int costLandlinePhoneCalls) {

        return new CallingTariff(tariff.getId(), tariff.getTariffName(), tariff.getOperatorName(), tariff.getMonthPayRoll(),
                tariff.getSmsPrise(), tariff.getCostConnect(), tariff.getDateConnectingTariff(),
                preferredNumber, costInNetworkCalls, costOffNetworkCalls, costLandlinePhoneCalls);
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
        CallingTariff that = (CallingTariff) obj;
        return (Objects.equals(getId(), that.getId())) && getMonthPayRoll() == that.getMonthPayRoll()
                && getSmsPrise() == that.getSmsPrise() && getCostConnect() == that.getCostConnect()
                && Objects.equals(getTariffName(), that.getTariffName()) && Objects.equals(getOperatorName(), that.getOperatorName())
                && Objects.equals(getDateConnectingTariff(), that.getDateConnectingTariff()) && getPreferredNumber() == that.getPreferredNumber()
                && getCostInNetworkCalls() == that.getCostInNetworkCalls() && getCostOffNetworkCalls() == that.getCostOffNetworkCalls()
                && getCostLandlinePhoneCalls() == that.getCostLandlinePhoneCalls() &&
                Objects.equals(getRoaming(), that.getRoaming());
    }

    @Override
    public int hashCode() {
        int hashCode = super.hashCode();
        hashCode = 31 * hashCode + preferredNumber + costInNetworkCalls +
                +costOffNetworkCalls + costLandlinePhoneCalls;
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
