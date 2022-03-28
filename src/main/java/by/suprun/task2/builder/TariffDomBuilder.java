package by.suprun.task2.builder;

import by.suprun.task2.entity.AbstractTariff;
import by.suprun.task2.entity.CallingTariff;
import by.suprun.task2.entity.InternetTariff;
import by.suprun.task2.entity.OperatorName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;


public class TariffDomBuilder extends AbstractTariffBuilder {
    private static final Logger logger = LogManager.getLogger();
    private DocumentBuilder documentBuilder;

    public TariffDomBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Dom configuration encounter error", e);
        }
    }

    @Override
    public void buildTariffs(String path) {
        Document doc;
        try {
            ClassLoader loader = getClass().getClassLoader();
            URL resource = loader.getResource(path);

            doc = documentBuilder.parse(resource.getFile());
            Element root = doc.getDocumentElement();
            createTariffs(root, TariffXmlTag.CALLING_TARIFF);
            createTariffs(root, TariffXmlTag.INTERNET_TARIFF);
        } catch (IOException | SAXException e) {
            logger.error("Error while reading", e);
        }
    }

    private void createTariffs(Element root, TariffXmlTag tariffXmlTag) {
        NodeList tariffList = root.getElementsByTagName(tariffXmlTag.getValue());
        for (int i = 0; i < tariffList.getLength(); i++) {
            Element e1 = (Element) tariffList.item(i);
            AbstractTariff tariff = buildTariff(e1, tariffXmlTag);
            tariffs.add(tariff);
        }
    }


    private AbstractTariff buildTariff(Element element, TariffXmlTag tariffXmlTag) {
        AbstractTariff tariff = new CallingTariff();

        String id = element.getAttribute(TariffXmlTag.ID.getValue());
        String tariffName = getElementTextContent(element, TariffXmlTag.TARIFF_NAME.getValue());
        OperatorName operatorName = OperatorName.getNameFromString(element.getAttribute(tariffXmlTag.OPERATOR_NAME.getValue()));
        int monthPayRoll = Integer.parseInt(getElementTextContent(element, TariffXmlTag.MONTH_PAY_ROLL.getValue()));
        int smsPrise = Integer.parseInt(getElementTextContent(element, TariffXmlTag.SMS_PRISE.getValue()));
        int costConnect = Integer.parseInt(getElementTextContent(element, TariffXmlTag.COST_CONNECT.getValue()));
        LocalDate dateСonnectingTariff = LocalDate.parse(getElementTextContent(element, TariffXmlTag.DATE_CONNECTING_TARIFF
                .getValue()));
        switch (tariffXmlTag) {
            case INTERNET_TARIFF -> {
                int numberFreeMegabytes = Integer.parseInt(getElementTextContent(element, TariffXmlTag.NUMBER_FREE_MEGABYTES.getValue()));
                int costMegabytesAfterFree = Integer.parseInt(getElementTextContent(element, TariffXmlTag.COST_MEGABYTES_AFTER_FREE.getValue()));
                int costRoamingMegabytes = Integer.parseInt(getElementTextContent(element, TariffXmlTag.COST_ROAMING_MEGABYTES.getValue()));
                int numberFreeMegabytesSocialNetworks = Integer.parseInt(getElementTextContent(element, TariffXmlTag.NUMBER_FREE_MEGABYTES_SOCIAL_NETWORKS.getValue()));
                InternetTariff temp = InternetTariff.setNewInternetTariff(tariff, numberFreeMegabytes, costMegabytesAfterFree,
                        costRoamingMegabytes, numberFreeMegabytesSocialNetworks);
                tariff = temp;
            }
            case CALLING_TARIFF -> {
                int preferredNumber = Integer.parseInt(getElementTextContent(element, tariffXmlTag.PREFERRED_NUMBER.getValue()));
                int costInNetworkCalls = Integer.parseInt(getElementTextContent(element, tariffXmlTag.COST_IN_NETWORK_CALLS.getValue()));
                int costOffNetworkCalls = Integer.parseInt(getElementTextContent(element, tariffXmlTag.COST_OFF_NETWORK_CALLS.getValue()));
                int costLandlinePhoneCalls = Integer.parseInt(getElementTextContent(element, tariffXmlTag.COST_LANDLINE_PHONE_CALLS.getValue()));
                CallingTariff temp = CallingTariff.setNewCallingTariff(tariff, preferredNumber, costInNetworkCalls,
                        costOffNetworkCalls, costLandlinePhoneCalls);
                tariff = temp;
            }
        }
        tariff.setId(id);
        tariff.setTariffName(tariffName);
        tariff.setOperatorName(operatorName);
        tariff.setMonthPayRoll(monthPayRoll);
        tariff.setSmsPrise(smsPrise);
        tariff.setCostConnect(costConnect);
        tariff.setDateConnectingTariff(dateСonnectingTariff);
        return tariff;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
