package by.suprun.task2.builder;

import by.suprun.task2.entity.AbstractTariff;
import by.suprun.task2.entity.InternetTariff;
import by.suprun.task2.entity.OperatorName;
import by.suprun.task2.entity.СallingTariff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger();

    private final Set<AbstractTariff> tariffs;
    private EnumSet<TariffXmlTag> xmlTags;

    private AbstractTariff currentTariff;
    private TariffXmlTag currentXmlTag;

    public void add(AbstractTariff tariff) {
        tariffs.add(tariff);
    }

    public TariffHandler() {
        tariffs = new HashSet<>();
        xmlTags = EnumSet.range(TariffXmlTag.TARIFF_NAME, TariffXmlTag.DATE_CONNECTING_TARIFF);
    }

    public Set<AbstractTariff> getTariffs() {
        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        logger.info("Method endDocument() by TariffHandler is start.");
        if (qName.equals(TariffXmlTag.CALLING_TARIFF.getValue()) ||
                qName.equals(TariffXmlTag.INTERNET_TARIFF.getValue())) {

            if (qName.equals(TariffXmlTag.CALLING_TARIFF.getValue())) {
                currentTariff = new СallingTariff();
            } else {
                currentTariff = new InternetTariff();
            }

            currentTariff.setId(attributes.getValue(0));
            currentTariff.setOperatorName(OperatorName.getNameFromString(attributes.getValue(1)));
        } else {
            TariffXmlTag temp = TariffXmlTag.valueOf(qName.toUpperCase().replace("-", "_"));
            if (xmlTags.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String callTag = TariffXmlTag.CALLING_TARIFF.getValue();
        String internetTag = TariffXmlTag.INTERNET_TARIFF.getValue();

        if (qName.equals(callTag) || qName.equals(internetTag)) {
            tariffs.add(currentTariff);
            currentTariff = null;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case ID -> currentTariff.setId(data);
                case SMS_PRISE -> currentTariff.setSmsPrise(Integer.parseInt(data));
                case MONTH_PAY_ROL -> currentTariff.setMonthPayRoll(Integer.parseInt(data));
                case DATE_CONNECTING_TARIFF -> currentTariff.setDateСonnectingTariff(LocalDate.parse(data));
                case OPERATOR_NAME -> currentTariff.setOperatorName(OperatorName.getNameFromString(data));

                case INTERNET_TARIFF -> {
                    if (currentTariff instanceof Paper) {
                        Paper temp = (Paper) currentTariff;
                        temp.setSubsriable(Boolean.getBoolean(data));
                    } else if (currentTariff instanceof Magazine) {
                        Magazine temp = (Magazine) currentTariff;
                        temp.setSubsriable(Boolean.getBoolean(data));
                    }
                }
                case PERIODICITY -> {
                    if (currentTariff instanceof Paper) {
                        Paper temp = (Paper) currentTariff;
                        temp.setPeriodicity(Periodicity.getPeriodicityFromString(data));
                    } else if (currentTariff instanceof Magazine) {
                        Magazine temp = (Magazine) currentTariff;
                        temp.setPeriodicity(Periodicity.getPeriodicityFromString(data));
                    }
                }
            }
        }
        currentXmlTag = null;
    }
}
