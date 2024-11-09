package cs1302.gallery;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import javafx.scene.layout.FlowPane;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.io.ByteArrayInputStream;
import javafx.scene.control.Alert;
import javafx.animation.KeyFrame;
import javafx.scene.layout.BorderPane;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Represents an iTunes Gallery App.
 */
public class KTPlaydateApp extends Application {

    /** HTTP client. */
    public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_2)           // uses HTTP protocol version 2 where possible
        .followRedirects(HttpClient.Redirect.NORMAL)  // always redirects, except from HTTPS to HTTP
        .build();                                     // builds and returns a HttpClient object

    /** Google {@code Gson} object for parsing JSON-formatted strings. */
    public static Gson GSON = new GsonBuilder()
        .setPrettyPrinting()                          // enable nice output when printing
        .create();                                    // builds and returns a Gson object

    private Stage stage;
    private Scene scene;
    private BorderPane root;
    private Button playPause;
    private Timeline timeline;
    private TextField searchTermField;
    private ComboBox<String> mediaTypeComboBox;
    private Label messageLabel;
    private Label statusBar;
    private FlowPane imagePane;
    private List<Image> defaultImages;

    /** 
     * Constructs a {@code GalleryApp} object.
     */
    public GalleryApp() {
        // Initializes the UI components
        this.stage = null;
        this.scene = null;
        this.root = new BorderPane();
        this.defaultImages = new ArrayList<>();
    }

    /** {@inheritDoc} */
    @Override
    public void init() {
        System.out.println("init() called");
        // Initializes timeline for updates
        EventHandler<ActionEvent> handler = event -> {
            System.out.println("Updating images at: " + LocalTime.now());
        };

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), handler);
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
    }

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {
        // Initializes UI elements and sets up event handlers
        this.stage = stage;
        this.scene = new Scene(this.root, 600, 500);
        playPause = new Button("Play");
        playPause.setPrefWidth(70);
        searchTermField = new TextField("daft punk");
        mediaTypeComboBox = new ComboBox<>();
        mediaTypeComboBox.getItems().addAll("movie", "podcast", "music", "musicVideo",
                                           "audiobook", "shortFilm", "tvShow", "software",
                                           "ebook", "all");
        mediaTypeComboBox.setValue("music");
        mediaTypeComboBox.setPrefWidth(100);
        
        // Removed 'getImages' button and functionality

        Label searchLabel = new Label("Search:");
        BorderPane.setMargin(searchLabel, new Insets(10));
        messageLabel = new Label("Type a term, select a media type.");
        messageLabel.setFont(Font.font(12));

        // Initialize the image pane
        imagePane = new FlowPane();
        imagePane.setVgap(10);
        imagePane.setHgap(10);

        // Initialize status bar
        statusBar = new Label("Status: Ready");

        VBox rootBox = new VBox(messageLabel, imagePane);
        root.setTop(new HBox(playPause, searchLabel, searchTermField,
                             mediaTypeComboBox));
        root.setCenter(rootBox);
        root.setBottom(statusBar);
        BorderPane.setAlignment(messageLabel, Pos.CENTER);
        BorderPane.setAlignment(statusBar, Pos.CENTER);
        searchTermField.setFont(Font.font(12));
        messageLabel.setFont(Font.font(12));
        searchLabel.setFont(Font.font(12));
        stage.setScene(scene);
        stage.setTitle("GalleryApp!");
        stage.show();
        playPause.setOnAction(event -> toggle());
    }

    /** 
     * Placeholder for a method to toggle play/pause functionality.
     */
    public void toggle() {
        // Toggle logic for play/pause goes here.
        System.out.println("Toggled play/pause.");
    }

    /** 
     * The main method to launch the application. 
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
