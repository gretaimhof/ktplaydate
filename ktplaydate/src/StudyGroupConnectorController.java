import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class StudyGroupConnectorController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField classField;
    @FXML
    private TextField contactField;
    @FXML
    private Button submitButton;
    @FXML
    private ListView<StudyGroupEntry> listView;

    private ObservableList<StudyGroupEntry> studyGroupList = FXCollections.observableArrayList();

    public void initialize() {
        listView.setItems(studyGroupList);
        submitButton.setOnAction(e -> addEntry());
    }

    private void addEntry() {
        String name = nameField.getText();
        String className = classField.getText();
        String contact = contactField.getText();

        if (!name.isEmpty() && !className.isEmpty() && !contact.isEmpty()) {
            studyGroupList.add(new StudyGroupEntry(name, className, contact));
            nameField.clear();
            classField.clear();
            contactField.clear();
        }
    }
}
