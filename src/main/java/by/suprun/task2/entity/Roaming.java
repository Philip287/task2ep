package by.suprun.task2.entity;

public enum Roaming {
    ROAMING_ON("on"),
    ROAMING_OFF("off");

    private final String value;

    Roaming(String value) {
        this.value = value;
    }

    public String getRoaming() {
        return value;
    }

    public static Roaming getRoamingFromString(String temp) {
        for (var count : Roaming.values()) {
            if (count.value.equalsIgnoreCase(temp)) {
                return count;
            }
        }
        return null;
    }
}
