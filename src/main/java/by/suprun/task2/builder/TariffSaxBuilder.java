package by.suprun.task2.builder;

import by.suprun.task2.exception.TariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;

public class TariffSaxBuilder extends AbstractTariffBuilder {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void buildTariffs(String path) throws TariffException {
        try {
            ClassLoader loader = getClass().getClassLoader();
            URL resource = loader.getResource(path);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            TariffHandler handler = new TariffHandler();

            reader.setContentHandler(handler);
            reader.parse(resource.getFile());

            tariffs.addAll(handler.getTariffs());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("sax error", e);
            throw new TariffException("sax error", e);
        }
    }
}
