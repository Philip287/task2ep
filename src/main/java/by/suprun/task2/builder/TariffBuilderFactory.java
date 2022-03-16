package by.suprun.task2.builder;


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

    public AbstractTariffBuilder createTariffBuilder(ParserType type) {
        switch (type) {
            case SAX -> {
                return new TariffSaxBuilder();
            }

            case DOM -> {
                return new TariffDomBuilder();
            }

            case STAX -> {
                return new TariffStaxBuilder();
            }
            default -> {
                logger.info("Constant is not present in enum" + type + "i build default SAX builder ");
                return new TariffSaxBuilder();
            }

        }
    }
}
