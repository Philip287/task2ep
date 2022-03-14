package by.suprun.task2.builder;

import by.suprun.task2.entity.AbstractTariff;
import by.suprun.task2.entity.InternetTariff;
import by.suprun.task2.entity.OperatorName;
import by.suprun.task2.entity.СallingTariff;
import by.suprun.task2.exception.TariffException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class TariffStaxBuilder extends AbstractTariffBuilder {
    private static final Logger logger = LogManager.getLogger();
    private static final char UNDERSCORE = '_';
    private static final char HYPHEN = '-';
    private XMLInputFactory inputFactory;

    public TariffStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildTariffs(String path) throws TariffException {
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(path);

        XMLStreamReader reader;
        String name;

        File file;
        try (FileInputStream inputStream = new FileInputStream(resource.getFile())) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(TariffXmlTag.CALLING_TARIFF.getValue())
                            || name.equals(TariffXmlTag.INTERNET_TARIFF.getValue())) {
                        AbstractTariff tariff = buildTariff(reader);
                        tariffs.add(tariff);
                    }
                }

            }
        } catch (IOException | XMLStreamException e) {
            logger.error("stax error", e);
        }
    }

    private AbstractTariff buildTariff(XMLStreamReader reader) throws XMLStreamException {
        String temp = reader.getLocalName();
        AbstractTariff currentTariff = temp.equals(TariffXmlTag.INTERNET_TARIFF.getValue()) ? new InternetTariff()
                : new СallingTariff();

        currentTariff.setId(reader.getAttributeValue(null, TariffXmlTag.ID.getValue()));

        OperatorName operatorName = OperatorName.valueOf(null, TariffXmlTag.OPERATOR_NAME.getValue());
        if (operatorName == null) {
            currentTariff.setOperatorName(OperatorName.valueOf("MTS"));
        } else {
            currentTariff.setTariffName(operatorName.toString());
        }
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            ;
            switch (type) {
                case XMLStreamConstants.START_ELEMENT -> {
                    name = reader.getLocalName().toUpperCase().replace(HYPHEN, UNDERSCORE);
                    buildTariffProperties(reader, name, currentTariff);
                }
                case XMLStreamConstants.END_ELEMENT -> {
                    name = reader.getLocalName();
                    if (name.equals(TariffXmlTag.INTERNET_TARIFF.getValue())
                            || name.equals(TariffXmlTag.CALLING_TARIFF.getValue())) {
                        return currentTariff;
                    }
                }
            }
        }
        throw new XMLStreamException("unknown tag");
    }

    private void buildTariffProperties(XMLStreamReader reader, String name, AbstractTariff currentTariff) throws XMLStreamException {
        String data = getXMLText(reader);
        switch (TariffXmlTag.valueOf(name)) {
            case ID -> currentTariff.setId(data);
            case TARIFF_NAME -> currentTariff.setTariffName(data);
            case OPERATOR_NAME -> currentTariff.setOperatorName(OperatorName.getNameFromString(data));
            case MONTH_PAY_ROL -> currentTariff.setMonthPayRoll(Integer.parseInt(data));
            case SMS_PRISE -> currentTariff.setSmsPrise(Integer.parseInt(data));
            case COST_CONNECT -> currentTariff.setCostConnect(Integer.parseInt(data));
            case DATE_CONNECTING_TARIFF -> currentTariff.setDateСonnectingTariff(LocalDate.parse(data));
            case COST_IN_NETWORK_CALLS -> {
                СallingTariff temp = (СallingTariff) currentTariff;
                temp.setCostInNetworkCalls(Integer.parseInt(data));
            }
            case PREFERRED_NUMBER -> {
                СallingTariff temp = (СallingTariff) currentTariff;
                temp.setPreferredNumber(Integer.parseInt(data));
            }
            case COST_OFF_NETWORK_CALLS -> {
                СallingTariff temp = (СallingTariff) currentTariff;
                temp.setCostOffNetworkCalls(Integer.parseInt(data));
            }
            case COST_LANDLINE_PHONE_CALLS -> {
                СallingTariff temp = (СallingTariff) currentTariff;
                temp.setCostLandlinePhoneCalls(Integer.parseInt(data));
            }
            case NUMBER_FREE_MEGABYTES -> {
                InternetTariff temp = (InternetTariff) currentTariff;
                temp.setNumberFreeMegabytes(Integer.parseInt(data));
            }
            case COST_MEGABYTES_AFTER_FREE -> {
                InternetTariff temp = (InternetTariff) currentTariff;
                temp.setCostMegabytesAfterFree(Integer.parseInt(data));
            }
            case COST_ROAMING_MEGABYTES -> {
                InternetTariff temp = (InternetTariff) currentTariff;
                temp.setCostRoamingMegabytes(Integer.parseInt(data));

            }
            case NUMBER_FREE_MEGABYTES_SOCIAL_NETWORKS -> {
                InternetTariff temp = (InternetTariff) currentTariff;
                temp.setNumberFreeMegabytesSocialNetworks(Integer.parseInt(data));
            }
            default -> {
                logger.error("Unknown tag");
            }
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
