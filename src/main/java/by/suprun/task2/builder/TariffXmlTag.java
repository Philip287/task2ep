package by.suprun.task2.builder;

public enum TariffXmlTag {

    TARIFFS("tariffs"),
    INTERNET_TARIFF("internet-tariff"),
    CALLING_TARIFF("calling-tariff"),
    ID("id"),
    OPERATOR_NAME("operator-name"),
    TARIFF_NAME("tariff-name"),
    MONTH_PAY_ROLL("month-pay-roll"),
    SMS_PRISE("sms-prise"),
    DATE_CONNECTING_TARIFF("date-connecting-tariff"),
    COST_CONNECT("cost-connect"),
    COST_IN_NETWORK_CALLS("cost-in-network-calls"),
    PREFERRED_NUMBER("preferred-number"),
    COST_OFF_NETWORK_CALLS("cost-off-network-calls"),
    COST_LANDLINE_PHONE_CALLS("cost-landline-phone-calls"),
    NUMBER_FREE_MEGABYTES("number-free-megabytes"),
    COST_MEGABYTES_AFTER_FREE("cost-megabytes-after-free"),
    COST_ROAMING_MEGABYTES("cost-roaming-megabytes"),
    NUMBER_FREE_MEGABYTES_SOCIAL_NETWORKS("number-free-megabytes-social-networks");

    private String value;

    TariffXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
