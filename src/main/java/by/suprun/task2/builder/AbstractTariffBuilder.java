package by.suprun.task2.builder;

import by.suprun.task2.entity.AbstractTariff;
import by.suprun.task2.exception.TariffException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTariffBuilder {
    protected Set<AbstractTariff> tariffs;

    public AbstractTariffBuilder() {
        tariffs = new HashSet<>();
    }

    public AbstractTariffBuilder(Set<AbstractTariff> newTariffs) {
        tariffs = newTariffs;
    }

    public Set<AbstractTariff> getTariffs() {
        return tariffs;
    }

    public abstract void buildTariffs(String path) throws TariffException;
}
