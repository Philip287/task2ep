package by.suprun.task2.entity;

import java.time.LocalDate;
import java.util.OptionalInt;


public class MtsCompanyTariffs extends AbstractTariff {
    public MtsCompanyTariffs() {
        super();
    }

    public MtsCompanyTariffs(String id, String tariffName, OperatorName operatorName, OptionalInt monthPayRoll,
                             CallPrice callprice, OptionalInt smsPrise, ParametersTariff parameters,
                             LocalDate dateСonnectTariff) {
        super(id, tariffName, operatorName, monthPayRoll, callprice, smsPrise, parameters, dateСonnectTariff);
    }

    public static MtsCompanyTariffs setNewMtsCompany(AbstractTariff tariff){
        return new MtsCompanyTariffs();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
