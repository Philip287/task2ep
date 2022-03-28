package by.suprun.task2.entity;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AbstractTariff {
    private String id;
    private String tariffName;
    private OperatorName operatorName;
    private int monthPayRoll;
    private int smsPrise;
    private int costConnect;
    private LocalDate dateConnectingTariff;
    private Roaming roaming;

    public AbstractTariff() {
    }

    public AbstractTariff(String id, String tariffName, OperatorName operatorName, int monthPayRoll, int smsPrise,
                          int costConnect, LocalDate dateConnectingTariff, Roaming roaming) {
        this.id = id;
        this.tariffName = tariffName;
        this.operatorName = operatorName;
        this.monthPayRoll = monthPayRoll;
        this.smsPrise = smsPrise;
        this.costConnect = costConnect;
        this.dateConnectingTariff = dateConnectingTariff;
        this.roaming = roaming;
    }

    public AbstractTariff(String id, String tariffName, OperatorName operatorName, int monthPayRoll, int smsPrise,
                          int costConnect, LocalDate dateConnectingTariff) {
        this.id = id;
        this.tariffName = tariffName;
        this.operatorName = operatorName;
        this.monthPayRoll = monthPayRoll;
        this.smsPrise = smsPrise;
        this.costConnect = costConnect;
        this.dateConnectingTariff = dateConnectingTariff;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public OperatorName getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(OperatorName operatorName) {
        this.operatorName = operatorName;
    }

    public int getMonthPayRoll() {
        return monthPayRoll;
    }

    public void setMonthPayRoll(int monthPayRoll) {
        this.monthPayRoll = monthPayRoll;
    }

    public int getSmsPrise() {
        return smsPrise;
    }

    public void setSmsPrise(int smsPrise) {
        this.smsPrise = smsPrise;
    }

    public int getCostConnect() {
        return costConnect;
    }

    public void setCostConnect(int costConnect) {
        this.costConnect = costConnect;
    }

    public LocalDate getDateConnectingTariff() {
        return dateConnectingTariff;
    }

    public void setDateConnectingTariff(LocalDate dateConnectingTariff) {
        this.dateConnectingTariff = dateConnectingTariff;
    }

    public Roaming getRoaming() {
        return this.roaming;
    }

    public void setRoaming(Roaming roaming) {
        this.roaming = roaming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTariff that = (AbstractTariff) o;
        return Objects.equals(id, that.id) && monthPayRoll == that.monthPayRoll && smsPrise == that.smsPrise
                && costConnect == that.costConnect && Objects.equals(tariffName, that.tariffName)
                && Objects.equals(operatorName, that.operatorName) &&
                Objects.equals(dateConnectingTariff, that.dateConnectingTariff) && Objects.equals(roaming, that.roaming);
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + (id != null ? getId().hashCode() : 0)
                + (tariffName != null ? getTariffName().hashCode() : 0) + (operatorName != null ? getOperatorName().hashCode() : 0)
                + getCostConnect() + getMonthPayRoll() + getSmsPrise()
                + (dateConnectingTariff != null ? getDateConnectingTariff().hashCode() : 0);
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractTariff by{" + AbstractTariff.class);
        sb.append(": id ='").append(id);
        sb.append(": tariff name ='").append(tariffName);
        sb.append(", operator name =").append(operatorName);
        sb.append(", month pay roll=").append(monthPayRoll);
        sb.append(", sms prise=").append(smsPrise);
        sb.append(", cost connect=").append(costConnect);
        sb.append(", date connect tariff=").append(dateConnectingTariff);
        sb.append(", roaming=").append(roaming);
        sb.append('}');
        return sb.toString();
    }
}