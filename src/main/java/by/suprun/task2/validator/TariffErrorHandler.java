package by.suprun.task2.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class TariffErrorHandler implements ErrorHandler {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void warning(SAXParseException e) {
        logger.warn(getLineColumnNumber(e) + "-" + e.getMessage());
    }

    public void error(SAXParseException e) {
        logger.error(getLineColumnNumber(e) + "-" + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) {
        logger.fatal(getLineColumnNumber(e) + "-" + e.getMessage());
    }

    private String getLineColumnNumber(SAXParseException e) {
        return e.getLineNumber() + ":" + e.getColumnNumber();
    }


}
