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
import org.xml.sax.InputSource;
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
            InputSource is;
            doc = documentBuilder.parse(resource.getFile());
            Element root = doc.getDocumentElement();
            NodeList tariffList = root.getElementsByTagName("tariffs");
            for (int i = 0; i < tariffList.getLength(); i++) {
                Element e1 = (Element) tariffList.item(i);
                AbstractTariff tariff = buildTariff(e1, TariffXmlTag.valueOf("tariffs"));
                tariffs.add(tariff);
            }
        } catch (IOException | SAXException e) {
            logger.error("Error while reading", e);
        }
    }


    private AbstractTariff buildTariff(Element element, TariffXmlTag tariffXmlTag) {
        AbstractTariff tariff = new InternetTariff();

        String id = element.getAttribute(TariffXmlTag.ID.toString());
        String tariffName = element.getAttribute(TariffXmlTag.TARIFF_NAME.toString());
        OperatorName operatorName = OperatorName.valueOf(getElementTextContent(element, tariffXmlTag.OPERATOR_NAME
                .getValue().toUpperCase()));
        int monthPayRoll = Integer.parseInt(element.getAttribute(TariffXmlTag.MONTH_PAY_ROL.getValue()));
        int smsPrise = Integer.parseInt(element.getAttribute(TariffXmlTag.SMS_PRISE.getValue()));
        int costConnect = Integer.parseInt(element.getAttribute(TariffXmlTag.COST_CONNECT.getValue()));
        LocalDate dateСonnectingTariff = LocalDate.parse(element.getAttribute(TariffXmlTag.DATE_CONNECTING_TARIFF
                .getValue()));
        switch (tariffXmlTag) {
            case INTERNET_TARIFF -> {
                int numberFreeMegabytes = Integer.parseInt(element.getAttribute(TariffXmlTag.NUMBER_FREE_MEGABYTES.getValue()));
                int costMegabytesAfterFree = Integer.parseInt(element.getAttribute(TariffXmlTag.COST_MEGABYTES_AFTER_FREE.getValue()));
                int costRoamingMegabytes = Integer.parseInt(element.getAttribute(TariffXmlTag.COST_ROAMING_MEGABYTES.getValue()));
                int numberFreeMegabytesSocialNetworks = Integer.parseInt(element.getAttribute(TariffXmlTag.NUMBER_FREE_MEGABYTES_SOCIAL_NETWORKS.getValue()));
                InternetTariff temp = InternetTariff.setNewInternetTariff(tariff, numberFreeMegabytes, costMegabytesAfterFree,
                        costRoamingMegabytes, numberFreeMegabytesSocialNetworks);
                tariff = temp;
            }
            case CALLING_TARIFF -> {
                int preferredNumber = Integer.parseInt(element.getAttribute(TariffXmlTag.PREFERRED_NUMBER.getValue()));
                int costInNetworkCalls = Integer.parseInt(element.getAttribute(TariffXmlTag.COST_IN_NETWORK_CALLS.getValue()));
                int costOffNetworkCalls = Integer.parseInt(element.getAttribute(TariffXmlTag.COST_OFF_NETWORK_CALLS.getValue()));
                int costLandlinePhoneCalls = Integer.parseInt(element.getAttribute(TariffXmlTag.COST_LANDLINE_PHONE_CALLS.getValue()));
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
        tariff.setDateСonnectingTariff(dateСonnectingTariff);
        return tariff;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
