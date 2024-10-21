package pt.archkode.liftus.data.type;

public enum RoleType {
    USER("User", "text-primary"), 
    DRIVER("Driver", "text-yellow"), 
    ADMIN("Admin", "text-error");

    private final String label, color;

    private RoleType(String label, String color) {
        this.label = label;
        this.color = color;
    }

    public String getLabel() {
        return label;
    }

    public String getColor() {
        return color;
    }
}
