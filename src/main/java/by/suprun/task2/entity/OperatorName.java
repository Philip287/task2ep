package by.suprun.task2.entity;

public enum OperatorName {
    LIFE("life"),
    MTS("MTS"),
    TELE2("Tele 2"),
    BILAYN("Bilayn"),
    MEGAFON("Megafon");

    private final String value;

    OperatorName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OperatorName getNameFromString(String temp) {
        for (var count : OperatorName.values()) {
            if (count.value.equalsIgnoreCase(temp)) {
                return count;
            }
        }
        return null;
    }
}
