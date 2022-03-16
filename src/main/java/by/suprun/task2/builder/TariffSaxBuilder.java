package by.suprun.task2.builder;

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
    public void buildTariffs(String path) {
        try {
            ClassLoader loader = getClass().getClassLoader();
            URL resource = loader.getResource(path);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();
            TariffHandler handler = new TariffHandler();

            reader.setContentHandler(handler);
            reader.parse(resource.getFile());

            tariffs.addAll(handler.getTariffs());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("sax error", e);
        }
    }
}
