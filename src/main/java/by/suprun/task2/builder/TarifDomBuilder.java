package by.suprun.task2.builder;

import by.suprun.task2.exception.TariffException;
import jdk.internal.org.xml.sax.SAXException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;

public class TarifDomBuilder extends AbstractTariffBuilder {
    private static final Logger logger = LogManager.getLogger();
    private final DocumentBuilder documentBuilder;


    public TarifDomBuilder() throws TariffException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Dom configuration encounter error", e);
            throw new TariffException("Dom configuration encounter error", e);
        }
    }

    @Override
    public void buildPapers(String path) throws TariffException {
        try {
            ClassLoader loader = getClass().getClassLoader();
            URL resource = loader.getResource(path);
            Document document = documentBuilder.parse(resource.getFile());
            Element element = document.getDocumentElement();
        } catch (IOException | SAXException e) {
            logger.error("Error while reading", e);
        }
    }
}
