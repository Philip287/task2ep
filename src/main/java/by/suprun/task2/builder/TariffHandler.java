package by.suprun.task2.builder;

import by.suprun.task2.entity.AbstractTariff;
import by.suprun.task2.entity.CallingTariff;
import by.suprun.task2.entity.InternetTariff;
import by.suprun.task2.entity.OperatorName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
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
        xmlTags = EnumSet.range(TariffXmlTag.TARIFF_NAME, TariffXmlTag.NUMBER_FREE_MEGABYTES_SOCIAL_NETWORKS);
    }

    public Set<AbstractTariff> getTariffs() {
        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        logger.info("Method startDocument() by TariffHandler is start.");
        if (qName.equals(TariffXmlTag.INTERNET_TARIFF.getValue()) ||
                qName.equals(TariffXmlTag.CALLING_TARIFF.getValue())) {
            currentTariff = qName.equals(TariffXmlTag.CALLING_TARIFF.getValue()) ? new CallingTariff() : new InternetTariff();

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
    public void endElement(String uri, String localName, String qName) {
        String callTag = TariffXmlTag.CALLING_TARIFF.getValue();
        String internetTag = TariffXmlTag.INTERNET_TARIFF.getValue();

        if (qName.equals(callTag) || qName.equals(internetTag)) {
            tariffs.add(currentTariff);
            currentTariff = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);

        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case ID -> currentTariff.setId(data);
                case TARIFF_NAME -> currentTariff.setTariffName(data);
                case OPERATOR_NAME -> currentTariff.setOperatorName(OperatorName.getNameFromString(data));
                case MONTH_PAY_ROLL -> currentTariff.setMonthPayRoll(Integer.parseInt(data));
                case SMS_PRISE -> currentTariff.setSmsPrise(Integer.parseInt(data));
                case COST_CONNECT -> currentTariff.setCostConnect(Integer.parseInt(data));
                case DATE_CONNECTING_TARIFF -> currentTariff.setDateConnectingTariff(LocalDate.parse(data));
                case COST_IN_NETWORK_CALLS -> {
                    if (currentTariff instanceof CallingTariff) {
                        CallingTariff temp = (CallingTariff) currentTariff;
                        temp.setCostInNetworkCalls(Integer.parseInt(data));
                    }
                }
                case PREFERRED_NUMBER -> {
                    if (currentTariff instanceof CallingTariff) {
                        CallingTariff temp = (CallingTariff) currentTariff;
                        temp.setPreferredNumber(Integer.parseInt(data));
                    }
                }
                case COST_OFF_NETWORK_CALLS -> {
                    if (currentTariff instanceof CallingTariff) {
                        CallingTariff temp = (CallingTariff) currentTariff;
                        temp.setCostOffNetworkCalls(Integer.parseInt(data));
                    }
                }
                case COST_LANDLINE_PHONE_CALLS -> {
                    if (currentTariff instanceof CallingTariff) {
                        CallingTariff temp = (CallingTariff) currentTariff;
                        temp.setCostLandlinePhoneCalls(Integer.parseInt(data));
                    }
                }
                case NUMBER_FREE_MEGABYTES -> {
                    if (currentTariff instanceof InternetTariff) {
                        InternetTariff temp = (InternetTariff) currentTariff;
                        temp.setNumberFreeMegabytes(Integer.parseInt(data));
                    }
                }
                case COST_MEGABYTES_AFTER_FREE -> {
                    if (currentTariff instanceof InternetTariff) {
                        InternetTariff temp = (InternetTariff) currentTariff;
                        temp.setCostMegabytesAfterFree(Integer.parseInt(data));
                    }
                }
                case COST_ROAMING_MEGABYTES -> {
                    if (currentTariff instanceof InternetTariff) {
                        InternetTariff temp = (InternetTariff) currentTariff;
                        temp.setCostRoamingMegabytes(Integer.parseInt(data));
                    }

                }
                case NUMBER_FREE_MEGABYTES_SOCIAL_NETWORKS -> {
                    if (currentTariff instanceof InternetTariff) {
                        InternetTariff temp = (InternetTariff) currentTariff;
                        temp.setNumberFreeMegabytesSocialNetworks(Integer.parseInt(data));
                    }
                }

            }

        }
        currentXmlTag = null;
    }
}
