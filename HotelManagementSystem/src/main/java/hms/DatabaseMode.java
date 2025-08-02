package hms;

public enum DatabaseMode {
    MEMORY,
    MYSQL;

    public static DatabaseMode fromString(String mode) {
        if (mode == null) return MEMORY;
        switch (mode.toLowerCase()) {
            case "mysql": return MYSQL;
            case "memory":
            default: return MEMORY;
        }
    }
}
