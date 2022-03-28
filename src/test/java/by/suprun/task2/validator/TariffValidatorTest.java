package by.suprun.task2.validator;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TariffValidatorTest {
    private static final String XML_FILE = "data/test/tariffs.xml";
    private static final String XML_FILE_WRONG = "data/test/wrong.xml";

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