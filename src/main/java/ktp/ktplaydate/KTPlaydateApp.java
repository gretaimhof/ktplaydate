package ktp.ktplaydate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;

public class KTPlaydateApp extends Application {

    private Stage stage;
    private Scene scene;
    private BorderPane root;
    private Button playPause;
    private TextField name;
    private TextField email;
    private TextField phoneNumber;
    private TextField loginEmail;
    private Label messageLabel;
    private FlowPane imagePane;

    @Override
    public void init() {
        System.out.println("init() called");
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.root = new BorderPane();
        root.setStyle("-fx-background-color: #e0eff7;");
        this.scene = new Scene(this.root, 1000, 500);

        // Create UI components
        name = new TextField();
        name.setPromptText("Enter your name");

        email = new TextField();
        email.setPromptText("Enter your email");

        phoneNumber = new TextField();
        phoneNumber.setPromptText("Enter your phone number");

        // Login email field
        loginEmail = new TextField();
        loginEmail.setPromptText("Enter your email for login");

        messageLabel = new Label("Welcome to KTPlaydate! Sign up now:");
        messageLabel.setFont(Font.font(16));

        // Create ComboBoxes for class selections (5 drop-downs)
        ComboBox<String> className1 = new ComboBox<>();
        className1.getItems().addAll("CSCI", "MIST", "STAT", "MATH", "BUSN", "N/A");
        className1.setValue("Select class name");

        ComboBox<String> classNumber1 = new ComboBox<>();
        classNumber1.getItems().addAll("1301", "1302", "2000", "2090", "1730", "2610", "3030", "5750", "2670", "2720", "2270", "3360", "4000", "2250", "2260", "2270", "3000", "3300", "N/A");
        classNumber1.setValue("Select class number");

        ComboBox<String> className2 = new ComboBox<>();
        className2.getItems().addAll("CSCI", "MIST", "STAT", "MATH", "BUSN", "N/A");
        className2.setValue("Select class name");

        ComboBox<String> classNumber2 = new ComboBox<>();
        classNumber2.getItems().addAll("1301", "1302", "2000", "2090", "1730", "2610", "3030", "5750", "2670", "2720", "2270", "3360", "4000", "2250", "2260", "2270", "3000", "3300", "N/A");
        classNumber2.setValue("Select class number");

        ComboBox<String> className3 = new ComboBox<>();
        className3.getItems().addAll("CSCI", "MIST", "STAT", "MATH", "BUSN", "N/A");
        className3.setValue("Select class name");

        ComboBox<String> classNumber3 = new ComboBox<>();
        classNumber3.getItems().addAll("1301", "1302", "2000", "2090", "1730", "2610", "3030", "5750", "2670", "2720", "2270", "3360", "4000", "2250", "2260", "2270", "3000", "3300", "N/A");
        classNumber3.setValue("Select class number");

        ComboBox<String> className4 = new ComboBox<>();
        className4.getItems().addAll("CSCI", "MIST", "STAT", "MATH", "BUSN", "N/A");
        className4.setValue("Select class name");

        ComboBox<String> classNumber4 = new ComboBox<>();
        classNumber4.getItems().addAll("1301", "1302", "2000", "2090", "1730", "2610", "3030", "5750", "2670", "2720", "2270", "3360", "4000", "2250", "2260", "2270", "3000", "3300", "N/A");
        classNumber4.setValue("Select class number");

        ComboBox<String> className5 = new ComboBox<>();
        className5.getItems().addAll("CSCI", "MIST", "STAT", "MATH", "BUSN", "N/A");
        className5.setValue("Select class name");

        ComboBox<String> classNumber5 = new ComboBox<>();
        classNumber5.getItems().addAll("1301", "1302", "2000", "2090", "1730", "2610", "3030", "5750", "2670", "2720", "2270", "3360", "4000", "2250", "2260", "2270", "3000", "3300", "N/A");
        classNumber5.setValue("Select class number");

        // Sign-up Button
        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(event -> handleSignUp(
                className1, classNumber1,
                className2, classNumber2,
                className3, classNumber3,
                className4, classNumber4,
                className5, classNumber5));

        // Create GridPane for class selection
        GridPane classSelectionGrid = new GridPane();
        classSelectionGrid.setHgap(10);
        classSelectionGrid.setVgap(10);
        classSelectionGrid.add(new Label("Class Name"), 0, 0);
        classSelectionGrid.add(new Label("Class Number"), 1, 0);
        classSelectionGrid.add(className1, 0, 1);
        classSelectionGrid.add(classNumber1, 1, 1);
        classSelectionGrid.add(className2, 0, 2);
        classSelectionGrid.add(classNumber2, 1, 2);
        classSelectionGrid.add(className3, 0, 3);
        classSelectionGrid.add(classNumber3, 1, 3);
        classSelectionGrid.add(className4, 0, 4);
        classSelectionGrid.add(classNumber4, 1, 4);
        classSelectionGrid.add(className5, 0, 5);
        classSelectionGrid.add(classNumber5, 1, 5);

        // Layout for the sign-up form
        VBox signUpForm = new VBox(10, name, email, phoneNumber, classSelectionGrid, signUpButton);
        signUpForm.setAlignment(Pos.CENTER);
        signUpForm.setPadding(new Insets(20));

        // Layout for the login form
        VBox logInForm = new VBox(10, new Label("Already a KTPeer? Log in:"), loginEmail, new Button("Log In"));
        logInForm.setAlignment(Pos.CENTER);
        logInForm.setPadding(new Insets(20));

        // Layout setup
        VBox rootBox = new VBox(signUpForm, logInForm);
        root.setTop(rootBox);

        BorderPane.setAlignment(messageLabel, Pos.CENTER);

        // Set up scene and stage
        stage.setScene(scene);
        stage.setTitle("KTPlaydate");
        stage.show();
    }

    // Handle Sign Up button action
    private void handleSignUp(ComboBox<String> className1, ComboBox<String> classNumber1,
                              ComboBox<String> className2, ComboBox<String> classNumber2,
                              ComboBox<String> className3, ComboBox<String> classNumber3,
                              ComboBox<String> className4, ComboBox<String> classNumber4,
                              ComboBox<String> className5, ComboBox<String> classNumber5) {

        // Collect the selected class details
        String selectedClass1 = className1.getValue() + " " + classNumber1.getValue();
        String selectedClass2 = className2.getValue() + " " + classNumber2.getValue();
        String selectedClass3 = className3.getValue() + " " + classNumber3.getValue();
        String selectedClass4 = className4.getValue() + " " + classNumber4.getValue();
        String selectedClass5 = className5.getValue() + " " + classNumber5.getValue();

        // Navigate to new page with peers for each class
        Scene peersPage = createPeersPage(selectedClass1, selectedClass2, selectedClass3, selectedClass4, selectedClass5);
        stage.setScene(peersPage);
    }

    private Scene createPeersPage(String selectedClass1, String selectedClass2, String selectedClass3, String selectedClass4, String selectedClass5) {
        VBox peersBox = new VBox(10, new Label("Trishika, Manasa, Shreya in " + selectedClass1),
                                 new Label("Anisha, Nanditha, Carlos in " + selectedClass2),
                new Label("Greta, Juvis, Tharushika in " + selectedClass3),
                new Label("Anjali, Dylan, Keerthana in " + selectedClass4),
                new Label("Maadhavan, Stuti, Masdon in " + selectedClass5));
        peersBox.setStyle("-fx-background-color: #e0eff7;");
        peersBox.setAlignment(Pos.CENTER);
        peersBox.setPadding(new Insets(20));

        return new Scene(peersBox, 1000, 500);
    }

    @Override
    public void stop() {
        System.out.println("stop() called");
    }

    public static void main(String[] args) {
    }
}
