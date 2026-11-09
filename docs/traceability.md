# Ιχνηλασιμότητα: απαίτηση → UC → οθόνη → κλάση → test

Ομάδα 12 · Υπεύθυνος: Απόστολος Δαγκλής (Αναλυτής & Ελεγκτής) · ενημέρωση Ε5 (9/11/2026)

Κάθε λειτουργική απαίτηση του [1.3](P1/1.3-apaitiseis.md) φαίνεται εδώ μέχρι το test που την ελέγχει.
Η στήλη «Οθόνη» ακολουθεί το [`othones-UI.md`](P1/othones-UI.md) (UI-xx και καρτέλα).

**Κατάσταση στήλης «Κλάση» και «Test».** Στις 2/11 το `app/` δεν έχει ακόμη κώδικα (ούτε `pom.xml`). Γι' αυτό
όλες οι κλάσεις και τα tests είναι **προγραμματίζεται**· σε παρένθεση η κλάση/το test της βάσης (reference-app,
README §8) που είναι η πρόταση. Όταν ο Ηλίας ανεβάσει μια κλάση, το «προγραμματίζεται» αντικαθίσταται με το
πραγματικό όνομα, και το ίδιο όταν μπει το test στο `app/src/test/`.

«χειροκίνητα» = λειτουργία καθαρά διεπαφής· ελέγχεται με το χέρι ή με screenshot (2.6).


## Α. Κρυπτογράφηση (ENC)

| ID | Προτ. | UC | Οθόνη | Κλάση | Test |
|---|---|---|---|---|---|
| ENC-01 | M | UC-01 | UI-02 Κείμενο | προγραμματίζεται (TextCipher, CipherFactory, CaesarCipher, VigenereCipher, AesCipher, AesKeyCipher, TextCryptoController) | προγραμματίζεται (CipherTest, AesCipherTest, CipherFactoryTest, OfficialTestCasesTest) |
| ENC-02 | M | UC-02 | UI-02 Κείμενο | προγραμματίζεται (ίδιες με ENC-01 και Base64Text) | προγραμματίζεται (CipherTest, AesCipherTest) |
| ENC-03 | M | UC-01 | UI-02 Κείμενο | προγραμματίζεται (KeyDerivation, PasswordBox, AesCipher) | προγραμματίζεται (KeyDerivationTest, AesCipherTest) |
| ENC-04 | M | UC-03 | UI-02 Αρχεία | προγραμματίζεται (FileCryptoService, EncFileHeader, StreamCipherPump, FileCryptoController) | προγραμματίζεται (FileCryptoServiceTest) |
| ENC-05 | M | UC-04 | UI-02 Αρχεία | προγραμματίζεται (FileCryptoService, AtomicFileWriter) | προγραμματίζεται (FileCryptoServiceTest, OfficialTestCasesTest) |
| ENC-06 | S | UC-03 | UI-02 Αρχεία | προγραμματίζεται (DropZone, FileSelection, FileDialogs) | χειροκίνητα / screenshot (2.6) |
| ENC-07 | S | UC-05 | UI-02 PDF | προγραμματίζεται (PdfLocker, PdfController) | προγραμματίζεται (PdfLockerTest) |
| ENC-08 | S | UC-06 | UI-02 Κείμενο | προγραμματίζεται (KeyManager, AesKeyCipher) | προγραμματίζεται (KeyManagerTest, CipherTest) |
| ENC-09 | S | UC-01 | UI-02 Κείμενο | προγραμματίζεται (Views, TextCryptoController) | χειροκίνητα |
| ENC-10 | S | UC-03 | UI-02 Αρχεία | προγραμματίζεται (ProgressListener, StreamCipherPump, TaskRunner, ActionRunner) | προγραμματίζεται (FileCryptoServiceTest) |
| ENC-11 | C | UC-03 | UI-02 Αρχεία | προγραμματίζεται (BatchEncryptor, BatchReport) | προγραμματίζεται (BatchEncryptorTest) |

## Β. Secure Vault (VLT)

| ID | Προτ. | UC | Οθόνη | Κλάση | Test |
|---|---|---|---|---|---|
| VLT-01 | M | UC-07 | UI-03 | προγραμματίζεται (VaultManager, VaultStore, PasswordStrengthMeter, StrengthIndicator, VaultListController) | προγραμματίζεται (VaultManagerTest) |
| VLT-02 | M | UC-08 | UI-03 | προγραμματίζεται (VaultManager, VaultStore) | προγραμματίζεται (VaultTest) |
| VLT-03 | M | UC-09 | UI-04 | προγραμματίζεται (Vault, VaultCodec, VaultStore, DropZone) | προγραμματίζεται (VaultTest) |
| VLT-04 | M | UC-10 | UI-04 | προγραμματίζεται (VaultEntry, VaultController) | προγραμματίζεται (VaultTest) |
| VLT-05 | M | UC-10 | UI-04 | προγραμματίζεται (VaultFilter, ChoiceFilter) | προγραμματίζεται (VaultFilterTest) |
| VLT-06 | M | UC-11 | UI-04 | προγραμματίζεται (Vault, VaultEntryActions) | προγραμματίζεται (VaultTest) |
| VLT-07 | M | UC-13 | UI-04 | προγραμματίζεται (Vault, VaultSession, VaultController) | προγραμματίζεται (VaultTest) |
| VLT-08 | S | UC-13 | UI-04; UI-08 Ρυθμίσεις | προγραμματίζεται (InactivityTimer, VaultSession, AutoLockMonitor, ExitGuard, AppStartup) | προγραμματίζεται (VaultTimingTest) |
| VLT-09 | S | UC-12 | UI-04 | προγραμματίζεται (Vault, VaultEntryActions, Dialogs) | προγραμματίζεται (VaultTest) |
| VLT-10 | S | UC-14 | UI-04 | προγραμματίζεται (Vault, ChangePasswordDialog) | προγραμματίζεται (VaultTest) |
| VLT-11 | S | UC-15 | UI-03 | προγραμματίζεται (VaultManager, VaultInfo, VaultListController) | προγραμματίζεται (VaultManagerTest) |
| VLT-12 | S | UC-08 | UI-03 | προγραμματίζεται (LoginThrottle, VaultManager) | προγραμματίζεται (VaultManagerTest, VaultTimingTest, OfficialTestCasesTest) |
| VLT-13 | C | UC-09 | UI-04 | προγραμματίζεται (VaultEntry, Vault, VaultFilter) | προγραμματίζεται (VaultTest, VaultFilterTest) |
| VLT-14 | C | UC-10 | UI-04 | προγραμματίζεται (Vault, PreviewKind, PreviewWindow) | προγραμματίζεται (VaultTest, VaultFilterTest) |

## Γ. Ψηφιακή υπογραφή (SIG)

| ID | Προτ. | UC | Οθόνη | Κλάση | Test |
|---|---|---|---|---|---|
| SIG-01 | M | UC-16 | UI-05 Κλειδιά | προγραμματίζεται (SignatureAlgorithm, PrivateKeyStore, SigKeysController) | προγραμματίζεται (SignatureTest) |
| SIG-02 | M | UC-17 | UI-05 Υπογραφή | προγραμματίζεται (FileSigner, SignatureRecord, SignatureFileCodec, SignController) | προγραμματίζεται (SignatureTest) |
| SIG-03 | M | UC-18 | UI-05 Επαλήθευση | προγραμματίζεται (SignatureVerifier, VerificationResult, VerifyController) | προγραμματίζεται (SignatureTest, OfficialTestCasesTest) |
| SIG-04 | S | UC-16 | UI-05 Κλειδιά | προγραμματίζεται (PublicKeyPem) | προγραμματίζεται (SignatureTest) |
| SIG-05 | S | UC-19 | UI-05 Αποτύπωμα SHA-256 | προγραμματίζεται (FileHasher, Hex, HashController) | προγραμματίζεται (SignatureTest) |
| SIG-06 | C | UC-18 | UI-05 Κλειδιά; UI-05 Επαλήθευση | προγραμματίζεται (SignatureRecord, SignatureAlgorithm, VerifyController) | προγραμματίζεται (SignatureTest) |

## Δ. Στεγανογραφία (STG)

| ID | Προτ. | UC | Οθόνη | Κλάση | Test |
|---|---|---|---|---|---|
| STG-01 | M | UC-20 | UI-06 Απόκρυψη | προγραμματίζεται (StegoService, LsbCodec, StegoFrame) | προγραμματίζεται (StegoServiceTest, OfficialTestCasesTest) |
| STG-02 | M | UC-21 | UI-06 Ανάκτηση | προγραμματίζεται (StegoService, RevealedPayload, StegoRevealController) | προγραμματίζεται () |
| STG-03 | S | UC-20 | UI-06 Απόκρυψη | προγραμματίζεται (PasswordBox, PayloadKind) | προγραμματίζεται (StegoServiceTest) |
| STG-04 | S | UC-20 | UI-06 Απόκρυψη | προγραμματίζεται (StegoService, LsbCodec, StegoHideController) | προγραμματίζεται (StegoServiceTest) |
| STG-05 | C | UC-20 | UI-06 Απόκρυψη | προγραμματίζεται (StegoHideController, ImageView) | χειροκίνητα / screenshot (2.6) |
| STG-06 | C | UC-20 | UI-06 Απόκρυψη; UI-06 Ανάκτηση | προγραμματίζεται (HiddenFile, StegoService) | προγραμματίζεται (StegoServiceTest) |

## Ε. Εργαστήριο κρυπτογραφίας (LAB)

| ID | Προτ. | UC | Οθόνη | Κλάση | Test |
|---|---|---|---|---|---|
| LAB-01 | M | UC-22 | UI-07 Σύγκριση αλγορίθμων | προγραμματίζεται (BenchmarkAlgorithm, JceBenchmarkAlgorithm, AesGcmBenchmark, AesCbcBenchmark, ChaCha20Benchmark, BenchmarkCatalog, BenchmarkRunner) | προγραμματίζεται (BenchmarkTest) |
| LAB-02 | S | UC-22 | UI-07 Σύγκριση αλγορίθμων | προγραμματίζεται (BenchmarkRunner) | προγραμματίζεται (BenchmarkTest) |
| LAB-03 | S | UC-22 | UI-07 Σύγκριση αλγορίθμων | προγραμματίζεται (BenchmarkController, BarChart) | χειροκίνητα / screenshot (2.6) |
| LAB-04 | C | UC-22 | UI-07 Σύγκριση αλγορίθμων | προγραμματίζεται (BenchmarkCsv) | προγραμματίζεται (BenchmarkTest) |
| LAB-05 | M | UC-23 | UI-07 Κρυπτανάλυση Caesar | προγραμματίζεται (BruteForceAnalyzer, Candidate, CaesarLabController) | προγραμματίζεται (AnalysisTest) |
| LAB-06 | C | UC-23 | UI-07 Κρυπτανάλυση Caesar | προγραμματίζεται (FrequencyAnalyzer, CaesarLabController) | προγραμματίζεται (AnalysisTest) |
| LAB-07 | S | UC-24 | UI-07 Κωδικοί | προγραμματίζεται (PasswordStrengthMeter, PasswordStrength, CrackTime) | προγραμματίζεται (PasswordTest) |
| LAB-08 | S | UC-24 | UI-07 Κωδικοί | προγραμματίζεται (PasswordGenerator, PasswordPolicy) | προγραμματίζεται (PasswordTest) |
| LAB-09 | C | UC-23 | UI-07 Βήμα-βήμα | προγραμματίζεται (CipherStepper, CipherStep, StepperController) | προγραμματίζεται (AnalysisTest) |

## ΣΤ. Γενικές λειτουργίες (APP)

| ID | Προτ. | UC | Οθόνη | Κλάση | Test |
|---|---|---|---|---|---|
| APP-01 | M | όλες | UI-01 | προγραμματίζεται (HomeController, Screen, AppModule) | χειροκίνητα / screenshot (2.6) |
| APP-02 | M | όλες | όλες | προγραμματίζεται (Navigator) | χειροκίνητα |
| APP-03 | M | όλες (και UC-13) | όλες | προγραμματίζεται (ExitGuard, AppStartup, VaultSession) | προγραμματίζεται (VaultTimingTest) + χειροκίνητα |
| APP-04 | M | όλες | όλες | προγραμματίζεται (CryptoException, I18n, Feedback) | προγραμματίζεται (BundleConsistencyTest) |
| APP-05 | M | όλες (π.χ. UC-12, UC-15) | όλες | προγραμματίζεται (Dialogs) | χειροκίνητα |
| APP-06 | S | UC-25 | UI-08 Ρυθμίσεις | προγραμματίζεται (I18n, SettingsController) | προγραμματίζεται (BundleConsistencyTest) |
| APP-07 | S | UC-25 | UI-08 Ρυθμίσεις | προγραμματίζεται (ThemeManager) | προγραμματίζεται (SettingsRepositoryTest) + screenshot (2.6) |
| APP-08 | S | UC-25 | UI-08 Ρυθμίσεις | προγραμματίζεται (SettingsRepository, Settings) | προγραμματίζεται (SettingsRepositoryTest) |
| APP-09 | S | UC-26 | UI-08 Ιστορικό | προγραμματίζεται (HistoryService, HistoryRepository, HistoryEntry) | προγραμματίζεται (HistoryServiceTest) |
| APP-10 | S | UC-26 | UI-08 Ρυθμίσεις; UI-08 Ιστορικό | προγραμματίζεται (HistoryFilter, HistoryService, HistoryController) | προγραμματίζεται (HistoryServiceTest) |
| APP-11 | S | UC-27 | όλες (κουμπί «?») | προγραμματίζεται (Navigator, Dialogs) | προγραμματίζεται (BundleConsistencyTest) |
| APP-12 | S | UC-27 | UI-08 Ρυθμίσεις | προγραμματίζεται (TutorialDialog, AppStartup) | προγραμματίζεται (BundleConsistencyTest) + χειροκίνητα |

## Μη λειτουργικές απαιτήσεις

| ID | Κατηγορία | Πώς ελέγχεται (1.3) | Test |
|---|---|---|---|
| NFR-01 | Ασφάλεια | Κλειδί 32 bytes, IV 12 bytes· το ίδιο κείμενο με τον ίδιο κωδικό δίνει διαφορετικό κρυπτοκείμενο σε 2 εκτελέσεις | προγραμματίζεται (AesCipherTest) |
| NFR-02 | Ασφάλεια | Επαναλήψεις = 600.000, salt = 16 bytes, νέο salt σε κάθε κρυπτογράφηση | προγραμματίζεται (KeyDerivationTest) |
| NFR-03 | Ασφάλεια | Το αρχείο ιστορικού έχει μόνο 5 πεδία (ημερομηνία, ενότητα, ενέργεια, όνομα αρχείου, αποτέλεσμα)· 0 εμφανίσεις του κωδικού στα αρχεία της εφαρμογής | προγραμματίζεται (HistoryServiceTest) |
| NFR-04 | Ασφάλεια | Δεν υπάρχει λειτουργία ανάκτησης· η προειδοποίηση εμφανίζεται 1 φορά σε κάθε δημιουργία | χειροκίνητα / screenshot (2.6) |
| NFR-05 | Αξιοπιστία | Μετά από αποτυχία ή ακύρωση: αρχικό αρχείο ίδιο byte-προς-byte, 0 αρχεία εξόδου | προγραμματίζεται (FileCryptoServiceTest) |
| NFR-06 | Απόδοση | Χρονομέτρηση: < 1 s για 10.000 χαρακτήρες, < 5 s για 50 MB | προγραμματίζεται (AesCipherTest, FileCryptoServiceTest) |
| NFR-07 | Ευχρηστία | Μέτρηση κλικ για κάθε UC με λειτουργίες M: ≤ 3 | χειροκίνητα |
| NFR-08 | Ευχρηστία | Αποθήκευση ως «.jpg» δίνει αρχείο .png· είσοδος JPEG δείχνει προειδοποίηση | προγραμματίζεται (StegoServiceTest) |
| NFR-09 | Διεθνοποίηση | Τα δύο αρχεία πόρων έχουν ακριβώς τα ίδια κλειδιά· 0 κλειδιά που λείπουν | προγραμματίζεται (BundleConsistencyTest) |
| NFR-10 | Φορητότητα | Εκκίνηση και `mvn test` επιτυχή με Java 17 (σε τουλάχιστον Windows και Linux) | `mvn clean test` |
| NFR-11 | Συντηρησιμότητα | Προσθήκη αλγορίθμου = 1 νέα κλάση + 1 γραμμή στη Factory, 0 αλλαγές σε controllers/FXML | προγραμματίζεται (CipherFactoryTest) |
| NFR-12 | Ιδιωτικότητα | Όλες οι λειτουργίες δουλεύουν χωρίς σύνδεση· 0 εξαρτήσεις δικτύου ή βάσης δεδομένων | έλεγχος κώδικα |

## Περιπτώσεις χρήσης → προδιαγραφή → test cases

| UC | Προδιαγραφή | Διάγραμμα ακολουθίας (2.2) | Επίσημο TC (2.4) | Λοιπά TC (2.4) |
|---|---|---|---|---|
| UC-01 | [UC-01](P1/1.5-uc-specs/UC-01.md) | ναι (απόφαση #19) | TC-01 | TC-06, TC-07, TC-08, TC-09, TC-10, TC-11, TC-12, TC-13, TC-26, TC-62 |
| UC-02 | [UC-02](P1/1.5-uc-specs/UC-02.md) | — | TC-01 | TC-06, TC-07, TC-14, TC-15 |
| UC-03 | [UC-03](P1/1.5-uc-specs/UC-03.md) | — | — | TC-16, TC-17, TC-20, TC-21, TC-62 |
| UC-04 | [UC-04](P1/1.5-uc-specs/UC-04.md) | ναι (απόφαση #19) | TC-02 | TC-16, TC-18, TC-19 |
| UC-05 | [UC-05](P1/1.5-uc-specs/UC-05.md) | — | — | TC-22, TC-23 |
| UC-06 | [UC-06](P1/1.5-uc-specs/UC-06.md) | — | — | TC-24, TC-25 |
| UC-07 | [UC-07](P1/1.5-uc-specs/UC-07.md) | ναι (απόφαση #19) | — | TC-27, TC-28, TC-29 |
| UC-08 | [UC-08](P1/1.5-uc-specs/UC-08.md) | ναι (απόφαση #19) | TC-03 | TC-29, TC-30, TC-37 |
| UC-09 | [UC-09](P1/1.5-uc-specs/UC-09.md) | — | — | TC-29, TC-33 |
| UC-10 | [UC-10](P1/1.5-uc-specs/UC-10.md) | — | — | TC-29, TC-31, TC-32 |
| UC-11 | [UC-11](P1/1.5-uc-specs/UC-11.md) | — | — | TC-32 |
| UC-12 | [UC-12](P1/1.5-uc-specs/UC-12.md) | — | — | TC-33 |
| UC-13 | [UC-13](P1/1.5-uc-specs/UC-13.md) | — | — | TC-34, TC-60 |
| UC-14 | [UC-14](P1/1.5-uc-specs/UC-14.md) | — | — | TC-35 |
| UC-15 | [UC-15](P1/1.5-uc-specs/UC-15.md) | — | — | TC-36 |
| UC-16 | [UC-16](P1/1.5-uc-specs/UC-16.md) | — | — | TC-38, TC-39 |
| UC-17 | [UC-17](P1/1.5-uc-specs/UC-17.md) | — | TC-04 | TC-38, TC-40 |
| UC-18 | [UC-18](P1/1.5-uc-specs/UC-18.md) | ναι (απόφαση #19) | TC-04 | TC-40, TC-41 |
| UC-19 | [UC-19](P1/1.5-uc-specs/UC-19.md) | — | — | TC-42 |
| UC-20 | [UC-20](P1/1.5-uc-specs/UC-20.md) | ναι (απόφαση #19) | TC-05 | TC-43, TC-44, TC-45, TC-46, TC-48 |
| UC-21 | [UC-21](P1/1.5-uc-specs/UC-21.md) | — | TC-05 | TC-43, TC-44, TC-46, TC-47 |
| UC-22 | [UC-22](P1/1.5-uc-specs/UC-22.md) | — | — | TC-49 |
| UC-23 | [UC-23](P1/1.5-uc-specs/UC-23.md) | — | — | TC-50, TC-51 |
| UC-24 | [UC-24](P1/1.5-uc-specs/UC-24.md) | — | — | TC-52 |
| UC-25 | [UC-25](P1/1.5-uc-specs/UC-25.md) | — | — | TC-53, TC-54, TC-58 |
| UC-26 | [UC-26](P1/1.5-uc-specs/UC-26.md) | — | — | TC-55, TC-56, TC-57 |
| UC-27 | [UC-27](P1/1.5-uc-specs/UC-27.md) | — | — | TC-58, TC-61 |

Τα test cases είναι στο [2.4](P2/2.4-test-cases.md) (σχέδιο Ε5). Τα 5 επίσημα είναι η πρόταση για την απόφαση #20 του `docs/decisions.md`.

Σύνολο: 58 λειτουργικές απαιτήσεις, 12 μη λειτουργικές, 27 UC, 63 test cases.
