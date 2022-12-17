package codedmessage;

public enum TextType {
    OUTPUT("output"),
    ATLANTA("texts/atlanta"),
    BOSTON("texts/boston"),
    HAMPTON("texts/hampton"),
    OMAHA("texts/omaha"),
    SEATTLE("texts/seattle");

    private final String path;
    TextType(String path) {
        this.path = String.format("%s.txt", path);
    }

    @Override
    public String toString() {
        return path;
    }
}
