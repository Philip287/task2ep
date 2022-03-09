package by.suprun.task2.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.OptionalInt;

public abstract class AbstractTariff {
    private String id;
    private String tariffName;
    private OperatorName operatorName;
    private Integer monthPayRoll;
    private CallPrice callprice;
    private Integer smsPrise;
    private ParametersTariff parameters;
    private LocalDate dateСonnectTariff;

    public AbstractTariff() {
    }

    public AbstractTariff(String id, String tariffName, OperatorName operatorName, Integer monthPayRoll,
                          CallPrice callprice, Integer smsPrise, ParametersTariff parameters,
                          LocalDate dateСonnectTariff) {
        this.id = id;
        this.tariffName = tariffName;
        this.operatorName = operatorName;
        this.monthPayRoll = monthPayRoll;
        this.callprice = callprice;
        this.smsPrise = smsPrise;
        this.parameters = parameters;
        this.dateСonnectTariff = dateСonnectTariff;
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

    public Integer getMonthPayRoll() {
        return monthPayRoll;
    }

    public void setMonthPayRoll(Integer monthPayRoll) {
        this.monthPayRoll = monthPayRoll;
    }

    public CallPrice getCallprice() {
        return callprice;
    }

    public void setCallprice(CallPrice callprice) {
        this.callprice = callprice;
    }

    public Integer getSmsPrise() {
        return smsPrise;
    }

    public void setSmsPrise(Integer smsPrise) {
        this.smsPrise = smsPrise;
    }

    public ParametersTariff getParameters() {
        return parameters;
    }

    public void setParameters(ParametersTariff parameters) {
        this.parameters = parameters;
    }

    public LocalDate getDateСonnectTariff() {
        return dateСonnectTariff;
    }

    public void setDateСonnectTariff(LocalDate dateСonnectTariff) {
        this.dateСonnectTariff = dateСonnectTariff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTariff tariff = (AbstractTariff) o;
        return Objects.equals(id, tariff.id) && Objects.equals(tariffName, tariff.tariffName)
                && operatorName == tariff.operatorName && Objects.equals(monthPayRoll, tariff.monthPayRoll)
                && Objects.equals(callprice, tariff.callprice) && Objects.equals(smsPrise, tariff.smsPrise)
                && Objects.equals(parameters, tariff.parameters)
                && Objects.equals(dateСonnectTariff, tariff.dateСonnectTariff);
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + getId().hashCode() + getTariffName().hashCode() + getOperatorName().hashCode()
                + getMonthPayRoll() + getCallprice().hashCode() + getSmsPrise()
                + getParameters().hashCode() + getDateСonnectTariff().hashCode() * 2;
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractTariff by{" + AbstractTariff.class);
        sb.append(": id ='").append(id);
        sb.append(", operator name =").append(operatorName);
        sb.append(", month pay roll=").append(monthPayRoll);
        sb.append(", call price=").append(callprice);
        sb.append(", sms prise=").append(smsPrise);
        sb.append(", parameters=").append(parameters);
        sb.append(", date connect tariff=").append(dateСonnectTariff);
        sb.append('}');
        return sb.toString();
    }


}
