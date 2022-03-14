package by.suprun.task2.entity;

import java.time.LocalDate;
import java.util.OptionalInt;

public class InternetTariff extends AbstractTariff {
    private int numberFreeMegabytes;
    private int costMegabytesAfterFree;
    private int costRoamingMegabytes;
    private int numberFreeMegabytesSocialNetworks;

    public InternetTariff() {
        super();
    }

    public InternetTariff(String id, String tariffName, OperatorName operatorName, int monthPayRoll,
                          int smsPrise, int costConnect, LocalDate dateСonnectingTariff, int numberFreeMegabytes,
                          int costMegabytesAfterFree, int costRoamingMegabytes, int numberFreeMegabytesSocialNetworks,
                          Roaming roaming) {
        super(id, tariffName, operatorName, monthPayRoll, smsPrise, costConnect, dateСonnectingTariff, roaming);
        this.numberFreeMegabytes = numberFreeMegabytes;
        this.costMegabytesAfterFree = costMegabytesAfterFree;
        this.costRoamingMegabytes = costRoamingMegabytes;
        this.numberFreeMegabytesSocialNetworks = numberFreeMegabytesSocialNetworks;
    }

    public InternetTariff(String id, String tariffName, OperatorName operatorName,
                          int monthPayRoll, int smsPrise, int costConnect,
                          LocalDate dateСonnectingTariff, int numberFreeMegabytes,
                          int costMegabytesAfterFree, int costRoamingMegabytes,
                          int numberFreeMegabytesSocialNetworks) {
        super(id, tariffName, operatorName, monthPayRoll, smsPrise, costConnect, dateСonnectingTariff);
        this.numberFreeMegabytes = numberFreeMegabytes;
        this.costMegabytesAfterFree = costMegabytesAfterFree;
        this.costRoamingMegabytes = costRoamingMegabytes;
        this.numberFreeMegabytesSocialNetworks = numberFreeMegabytesSocialNetworks;
    }

    public int getNumberFreeMegabytes() {
        return numberFreeMegabytes;
    }

    public void setNumberFreeMegabytes(int numberFreeMegabytes) {
        this.numberFreeMegabytes = numberFreeMegabytes;
    }

    public int getCostMegabytesAfterFree() {
        return costMegabytesAfterFree;
    }

    public void setCostMegabytesAfterFree(int costMegabytesAfterFree) {
        this.costMegabytesAfterFree = costMegabytesAfterFree;
    }

    public int getCostRoamingMegabytes() {
        return costRoamingMegabytes;
    }

    public void setCostRoamingMegabytes(int costRoamingMegabytes) {
        this.costRoamingMegabytes = costRoamingMegabytes;
    }

    public int getNumberFreeMegabytesSocialNetworks() {
        return numberFreeMegabytesSocialNetworks;
    }

    public void setNumberFreeMegabytesSocialNetworks(int numberFreeMegabytesSocialNetworks) {
        this.numberFreeMegabytesSocialNetworks = numberFreeMegabytesSocialNetworks;
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
        InternetTariff that = (InternetTariff) obj;
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
        if (getNumberFreeMegabytes() != that.getNumberFreeMegabytes()) {
            return false;
        }
        if (getCostMegabytesAfterFree() != that.getCostMegabytesAfterFree()) {
            return false;
        }
        if (getCostRoamingMegabytes() != that.getCostRoamingMegabytes()) {
            return false;
        }
        if (getNumberFreeMegabytesSocialNetworks() != that.getNumberFreeMegabytesSocialNetworks()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + super.hashCode() + getNumberFreeMegabytes() + getCostMegabytesAfterFree()
                + getCostRoamingMegabytes() + getNumberFreeMegabytesSocialNetworks() * 2;
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Internet price by{" + AbstractTariff.class);
        sb.append(": id ='").append(getId());
        sb.append(": tariff name ='").append(getTariffName());
        sb.append(", operator name =").append(getOperatorName());
        sb.append(", month pay roll=").append(getMonthPayRoll());
        sb.append(", sms prise=").append(getSmsPrise());
        sb.append(", cost connect=").append(getCostConnect());
        sb.append(", date connect tariff=").append(getDateСonnectingTariff());
        sb.append(", number free megabytes=").append(numberFreeMegabytes);
        sb.append(", cost megabytes after free=").append(costMegabytesAfterFree);
        sb.append(", cost roaming megabytes=").append(costRoamingMegabytes);
        sb.append(", number free megabytes social networks=").append(numberFreeMegabytesSocialNetworks);
        sb.append(", roaming").append(getRoaming());
        sb.append('}');
        return sb.toString();
    }


}
