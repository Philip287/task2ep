package by.suprun.task2.builder;


import by.suprun.task2.entity.AbstractTariff;
import by.suprun.task2.entity.InternetTariff;
import by.suprun.task2.entity.OperatorName;
import by.suprun.task2.entity.СallingTariff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {

    private static final Logger logger = LogManager.getLogger();

    private final Set<AbstractTariff> tariffs;
    private EnumSet<TariffXmlTag> xmlTags;

    private AbstractTariff currentTariff;
    private TariffXmlTag currentXmlTag;

    public void add(AbstractTariff tariff){
        tariffs.add(tariff);
    }

    public TariffHandler() {
        tariffs = new HashSet<>();
        xmlTags = EnumSet.range(TariffXmlTag.TARIFF_NAME, TariffXmlTag.DATE_CONNECTING_TARIFF);
    }

    public Set<AbstractTariff> getTariffs(){
        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        if(qName.equals(TariffXmlTag.INTERNET_TARIFF.getValue()) ||
                qName.equals(TariffXmlTag.CALLING_TARIFF.getValue())){

            currentTariff = qName.equals(TariffXmlTag.INTERNET_TARIFF.getValue()) ? new InternetTariff() :
                    (qName.equals(TariffXmlTag.CALLING_TARIFF.getValue()) ? new СallingTariff());

            //currentTariff.setId(attributes.getValue(0));                                         todo ??????????????
            currentTariff.setOperatorName(OperatorName.getNameFromString(attributes.getValue(1)));
        }
        else{
            TariffXmlTag temp = TariffXmlTag.valueOf(qName.toUpperCase().replace("-", "_"));
            if(xmlTags.contains(temp)){
                currentXmlTag = temp;
            }
        }
    }

}
