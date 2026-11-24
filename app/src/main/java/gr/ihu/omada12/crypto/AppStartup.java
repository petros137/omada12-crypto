package gr.ihu.omada12.crypto;

import gr.ihu.omada12.crypto.model.settings.AppPaths;
import gr.ihu.omada12.crypto.view.AppContext;
import gr.ihu.omada12.crypto.view.ExitGuard;
import gr.ihu.omada12.crypto.view.Navigator;
import gr.ihu.omada12.crypto.view.Screen;
import gr.ihu.omada12.crypto.view.ThemeManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Υλοποιεί: APP-01, APP-03, APP-07

/** Συνθέτει τις κοινές υπηρεσίες, την πλοήγηση και την αρχική σκηνή της εφαρμογής. */
public class AppStartup {
    private final Stage stage;

    public AppStartup(Stage stage) {
        this.stage = stage;
    }

    public void start() throws IOException {
        AppContext ctx = new AppContext(stage, AppPaths.fromSystem());
        Navigator navigator = new Navigator(ctx);
        ctx.setNavigator(navigator);
        Scene scene = new Scene(navigator.getRoot(), 1180, 780);
        stage.setScene(scene);
        new ThemeManager(scene).apply(ctx.getSettings());
        stage.setTitle(ctx.getI18n().text("app.title"));
        stage.setMinWidth(980);
        stage.setMinHeight(660);
        navigator.show(Screen.HOME);
        stage.setOnCloseRequest(event -> {
            if (!ExitGuard.confirmExit(ctx)) event.consume();
        });
        stage.show();
    }
}
