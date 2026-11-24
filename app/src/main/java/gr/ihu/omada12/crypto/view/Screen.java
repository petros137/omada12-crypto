package gr.ihu.omada12.crypto.view;

// Υλοποιεί: APP-01, APP-02, APP-11

/**
 * Οι οθόνες της εφαρμογής (κωδικοί UI-xx για τις προδιαγραφές), με το FXML, τον τίτλο
 * και το κείμενο βοήθειας του κουμπιού «?».
 */
public enum Screen {
    HOME("UI-01", "home.fxml"),
    ENCRYPTION("UI-02", "encryption.fxml");

    private final String code;
    private final String fxml;

    Screen(String code, String fxml) {
        this.code = code;
        this.fxml = fxml;
    }

    public String getCode() { return code; }

    public String getFxml() { return fxml; }

    public String getTitleKey() { return "screen." + name().toLowerCase() + ".title"; }

    public String getHelpKey() { return "help." + name().toLowerCase(); }
}
