package ktp.ktplaydate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private ComboBox<String> className;
    private ComboBox<String> classNumber;
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
        this.scene = new Scene(this.root, 600, 500);

        // Create UI components
        playPause = new Button("Play");
        playPause.setPrefWidth(70);

        name = new TextField();
        name.setPromptText("Enter your name");

        email = new TextField();
        email.setPromptText("Enter your email");

        phoneNumber = new TextField();
        phoneNumber.setPromptText("Enter your phone number");

        // Login email field
        loginEmail = new TextField();
        loginEmail.setPromptText("Enter your email for login");

        className = new ComboBox<>();
        className.getItems().addAll("CSCI", "MIST", "STAT", "MATH", "BUSN");
        className.setValue("Select class name");
        className.setPrefWidth(100);

        classNumber = new ComboBox<>();
        classNumber.getItems().addAll("1301", "1302", "2000", "2090", "1730", "2610", "3030", "5750", "2670", "2720", "2270", "3360", "4000", "2250", "2260", "2270", "3000", "3300");
        classNumber.setValue("Select class number");
        classNumber.setPrefWidth(100);

        // Welcome message
        messageLabel = new Label("Welcome to KTPlaydate! Sign up now:");
        messageLabel.setFont(Font.font(16));

        // Sign-up Button
        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(event -> handleSignUp());

        // Login Button
        Button logInButton = new Button("Log In");
        logInButton.setOnAction(event -> handleLogin());

        // Initialize imagePane as a FlowPane (you can change it later to other layouts if needed)
        imagePane = new FlowPane();
        imagePane.setPrefSize(600, 250);

        // Layout for the sign-up form
        VBox signUpForm = new VBox(10, name, email, phoneNumber, signUpButton);
        signUpForm.setAlignment(Pos.CENTER);
        signUpForm.setPadding(new Insets(20));

        // Layout for the login form
        VBox logInForm = new VBox(10, new Label("Already a KTPeer? Log in:"), loginEmail, logInButton);
        logInForm.setAlignment(Pos.CENTER);
        logInForm.setPadding(new Insets(20));

        // Place className and classNumber at the bottom
        HBox classBox = new HBox(10, className, classNumber);
        classBox.setAlignment(Pos.CENTER);
        classBox.setPadding(new Insets(10));

        VBox bottomSection = new VBox(10, classBox, logInForm);
        bottomSection.setAlignment(Pos.CENTER);

        // Place Welcome message above the sign-up form
        VBox topSection = new VBox(10, messageLabel, signUpForm);
        topSection.setAlignment(Pos.CENTER);

        // Layout setup
        VBox rootBox = new VBox(topSection, imagePane);
        root.setTop(rootBox);
        root.setBottom(bottomSection);

        BorderPane.setAlignment(messageLabel, Pos.CENTER);

        // Style elements
        name.setFont(Font.font(12));
        email.setFont(Font.font(12));
        phoneNumber.setFont(Font.font(12));
        loginEmail.setFont(Font.font(12));
        messageLabel.setFont(Font.font(14));

        // Set up scene and stage
        stage.setScene(scene);
        stage.setTitle("KTPlaydate");
        stage.show();
    }

    // Handle Sign Up button action
    private void handleSignUp() {
        String enteredName = name.getText();
        String enteredEmail = email.getText();
        String enteredPhone = phoneNumber.getText();
        System.out.println("Sign Up: " + enteredName + ", " + enteredEmail + ", " + enteredPhone);
        // Add your sign-up handling logic here (e.g., storing user data)
    }

    // Handle Log In button action
    private void handleLogin() {
        String enteredLoginEmail = loginEmail.getText();
        System.out.println("Log In: " + enteredLoginEmail);
        // Add your login handling logic here (e.g., validating email)
    }

    public static void main(String[] args) {
        launch(args);
    }
}
