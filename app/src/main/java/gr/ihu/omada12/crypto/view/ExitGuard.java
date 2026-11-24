package gr.ihu.omada12.crypto.view;

// Υλοποιεί: APP-03

/** Ζητά επιβεβαίωση πριν κλείσει η εφαρμογή. */
public final class ExitGuard {
    private ExitGuard() { }

    public static boolean confirmExit(AppContext ctx) {
        return ctx.dialogs().confirm("exit.confirm");
    }
}
