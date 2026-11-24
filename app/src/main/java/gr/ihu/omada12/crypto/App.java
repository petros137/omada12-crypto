package gr.ihu.omada12.crypto;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

// Υλοποιεί: APP-01 (σημείο εκκίνησης JavaFX)

/** Εκκινεί τη γραφική εφαρμογή και αναθέτει τη σύνθεση των υπηρεσιών στο AppStartup. */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new AppStartup(stage).start();
    }
}
