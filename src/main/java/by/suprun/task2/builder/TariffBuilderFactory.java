package by.suprun.task2.builder;


import by.suprun.task2.exception.TariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TariffBuilderFactory {

    private static final Logger logger = LogManager.getLogger();
    private static final TariffBuilderFactory instance = new TariffBuilderFactory();

    private TariffBuilderFactory() {

    }

    public static TariffBuilderFactory getInstance() {
        return instance;
    }

    public AbstractTariffBuilder createTariffBuilder(ParserType type) throws TariffException {
        switch (type) {
            case SAX -> {
                return new TariffSaxBuilder();
            }

            case DOM -> {
                return new TariffDomBuilder();
            }

            case STAX -> {
                return  new TariffStaxBuilder();
            }
            default -> {
                throw new TariffException("Constant is not present in enum" + type);
            }

        }
    }
}
