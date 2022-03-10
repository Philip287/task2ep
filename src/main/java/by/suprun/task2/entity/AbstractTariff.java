package by.suprun.task2.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.OptionalInt;

public abstract class AbstractTariff {
    private long id;
    private String tariffName;
    private OperatorName operatorName;
    private OptionalInt monthPayRoll;
    private int smsPrise;
    private int costConnect;
    private LocalDate dateСonnectingTariff;

    public AbstractTariff() {
    }

    public AbstractTariff(long id, String tariffName, OperatorName operatorName, OptionalInt monthPayRoll, int smsPrise,
                          int costConnect, LocalDate dateСonnectingTariff) {
        this.id = id;
        this.tariffName = tariffName;
        this.operatorName = operatorName;
        this.monthPayRoll = monthPayRoll;
        this.smsPrise = smsPrise;
        this.costConnect = costConnect;
        this.dateСonnectingTariff = dateСonnectingTariff;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public OptionalInt getMonthPayRoll() {
        return monthPayRoll;
    }

    public void setMonthPayRoll(OptionalInt monthPayRoll) {
        this.monthPayRoll = monthPayRoll;
    }

    public long getSmsPrise() {
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

    public LocalDate getDateСonnectingTariff() {
        return dateСonnectingTariff;
    }

    public void setDateСonnectingTariff(LocalDate dateСonnectingTariff) {
        this.dateСonnectingTariff = dateСonnectingTariff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTariff that = (AbstractTariff) o;
        return id == that.id && monthPayRoll == that.monthPayRoll && smsPrise == that.smsPrise
                && costConnect == that.costConnect && Objects.equals(tariffName, that.tariffName)
                && operatorName == that.operatorName && Objects.equals(dateСonnectingTariff, that.dateСonnectingTariff);
    }

    @Override
    public int hashCode() {
        long hashCode = 1;
        hashCode = 31 * hashCode + getId()
                + getTariffName().hashCode() + getOperatorName().hashCode() + getCostConnect()
                + getMonthPayRoll().hashCode() + getSmsPrise() + getDateСonnectingTariff().hashCode() * 2L;
        return (int) hashCode;
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
        sb.append(", date connect tariff=").append(dateСonnectingTariff);
        sb.append('}');
        return sb.toString();
    }
}