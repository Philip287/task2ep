package by.suprun.task2.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TariffXmlValidator {

    private static final Logger logger = LogManager.getLogger();
    private static final String VALIDATION_SCHEME = "data/tariffs.xsd";

    public static boolean validateXml(String pathToXml) {
        ClassLoader loader = TariffXmlValidator.class.getClassLoader();
        URL xsdPath = loader.getResource(VALIDATION_SCHEME);
        File scheme = new File(xsdPath.getFile());
        URL xmlPath = loader.getResource(pathToXml);
        String path = new File(xmlPath.getFile()).getPath();
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        boolean result = true;
        try {
            Schema schema = factory.newSchema(scheme);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(path);
            validator.validate(source);
        } catch (SAXException e) {
            logger.warn("XML is invalid" + path, e);
            result = false;
        } catch (IOException e) {
            result = false;
            logger.error("Can`t read file" + path, e);
        }
        return result;
    }
}
