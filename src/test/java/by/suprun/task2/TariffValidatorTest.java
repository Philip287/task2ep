package by.suprun.task2;

import by.suprun.task2.validator.TariffXmlValidator;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class TariffValidatorTest {
    private static final String XML_FILE = "data\\test\\tariffs.xml";
    private static final String XML_FILE_WRONG = "data\\test\\wrong.xml";

    @Test
    public void testIsValidXML() {
        boolean expected = true;
        boolean actual = TariffXmlValidator.validateXml(XML_FILE);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsNotValidXML() {
        boolean expected = false;
        boolean actual = TariffXmlValidator.validateXml(XML_FILE_WRONG);
        assertEquals(expected, actual);
    }

}