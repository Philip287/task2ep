package by.suprun.task2.builder;

import by.suprun.task2.exception.TariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class TariffDomBuilder extends AbstractTariffBuilder {
    private static final Logger logger = LogManager.getLogger();
    private final DocumentBuilder documentBuilder;


    public TariffDomBuilder()throws TariffException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Dom configuration encounter error", e);
        }
    }
    @Override
    public void buildTariffs(String path) throws TariffException {

    }
}
