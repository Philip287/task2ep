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
        if (type.equals(ParserType.SAX)){
            return new TariffSaxBuilder();
        }

        if (type.equals(ParserType.DOM)){
            return new TarifDomBuilder();
        }

        if (type.equals(ParserType.STAX)){
            return new TariffStaxBuilder();
        }

        logger.error("Constant is not present in enum" + type);
        throw new TariffException("Constant is not present in enum" + type);
    }
}