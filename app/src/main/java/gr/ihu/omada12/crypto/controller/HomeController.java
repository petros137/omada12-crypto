package gr.ihu.omada12.crypto.controller;

import gr.ihu.omada12.crypto.view.AppContext;
import gr.ihu.omada12.crypto.view.ExitGuard;
import gr.ihu.omada12.crypto.view.Screen;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

// Υλοποιεί: APP-01, APP-03, NFR-07

/** Αρχική οθόνη με ενεργή πρόσβαση στις υλοποιημένες ενότητες. */
public class HomeController {
    private final AppContext ctx;

    @FXML private Button vaultTile;
    @FXML private Button signatureTile;
    @FXML private Button stegoTile;
    @FXML private Button labTile;
    @FXML private Button generalTile;

    public HomeController(AppContext ctx) {
        this.ctx = ctx;
    }

    /** Οι αντίστοιχες ενότητες ενεργοποιούνται όταν ολοκληρωθούν τα μοντέλα και οι controllers. */
    @FXML private void initialize() {
        vaultTile.setDisable(true);
        signatureTile.setDisable(true);
        stegoTile.setDisable(true);
        labTile.setDisable(true);
        generalTile.setDisable(true);
    }

    @FXML private void openEncryption() { ctx.getNavigator().show(Screen.ENCRYPTION); }

    @FXML private void openVault() { unavailable(); }

    @FXML private void openSignature() { unavailable(); }

    @FXML private void openStego() { unavailable(); }

    @FXML private void openLab() { unavailable(); }

    @FXML private void openGeneral() { unavailable(); }

    private void unavailable() {
        ctx.dialogs().info("home.moduleUnavailable");
    }

    @FXML private void exit() {
        if (ExitGuard.confirmExit(ctx)) Platform.exit();
    }
}
