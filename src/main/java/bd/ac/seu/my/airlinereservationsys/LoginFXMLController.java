package bd.ac.seu.my.airlinereservationsys;

import bd.ac.seu.my.airlinereservationsys.Enum.LoginAs;
import bd.ac.seu.my.airlinereservationsys.md5.HashMD5;
import bd.ac.seu.my.airlinereservationsys.model.User;
import bd.ac.seu.my.airlinereservationsys.util.SessionFactorySingleton;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LoginFXMLController implements Initializable {

    @FXML
    private ComboBox<LoginAs> loginAsBox;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text loginMessageText;

    private List<User> users;

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loginAsBox.getItems().addAll(LoginAs.values());
    }

    @FXML
    private void handleLoginAction(ActionEvent event) {

        loginMessageText.setText("");
        String username = usernameField.getText();
        String passText = passwordField.getText();
        //HashMD5 pass = new HashMD5(passText);
        String password = passText;
        String userType = loginAsBox.getSelectionModel().getSelectedItem() + "";

        User user = new User(username, password, userType);

        factory = SessionFactorySingleton.getSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

        try {
            users = session.createCriteria(User.class).list();
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e);
            transaction.rollback();
        }
        session.close();

        int loginConf = 0;

        for (User us : users) {
            if (us.getUsername().equals(username) && us.getPassword().equals(password) && us.getUserType().equals(userType)) {
                loginConf++;
                //System.err.println("If log: " + loginConf);
            }
        }

        if (loginConf == 1) {

            try {
                Parent root = null;

                if (user.getUserType().equals("Admin")) {
                    root = FXMLLoader.load(getClass().getResource("/fxml/AdminUI.fxml"));
                } else if (user.getUserType().equals("Booker")) {
                    root = FXMLLoader.load(getClass().getResource("/fxml/BookingOfficeUI.fxml"));
                }
                Scene scene = new Scene(root);

                MainApp.getMainStage().setScene(scene);
                MainApp.getMainStage().show();
            } catch (IOException ex) {
                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            loginMessageText.setText("Something Wrong Try Again!!");
        }
    }
}
