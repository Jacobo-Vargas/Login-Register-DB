package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.animation.Timeline;

import java.io.InputStream;

public class MainAppController {


    @FXML
    public JFXButton btnRegister;
    @FXML
    public TextField txtUser;
    @FXML
    public TextField txtPassword;
    @FXML
    public JFXButton btnIngresar;
    @FXML
    public JFXButton btnRecuperar;
    @FXML
    public ImageView imageShow;

    @FXML
    private static final String[] IMAGES = {
            "/images/imagen4.gif",
            "/images/imagen2.gif",
            "/images/imagen2.gif"
    };
    @FXML
    private static final int SLIDE_DURATION = 20000; // 4 segundos por imagen
    @FXML
    private int currentIndex = 0;
    @FXML
    public void initialize() {
        // Cargar la primera imagen
        showImage(currentIndex);

        // Configurar el Timeline para cambiar de imagen cada cierto tiempo

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(SLIDE_DURATION), e -> {
            currentIndex = (currentIndex + 1) % IMAGES.length; // Cambiar al siguiente índice % para no desbordarse
            showImage(currentIndex);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    @FXML
    private void showImage(int index) {
        String imagePath = IMAGES[index];
        try {
            InputStream imageStream = getClass().getResourceAsStream(imagePath);
            if (imageStream != null) {
                Image image = new Image(imageStream);
                imageShow.setImage(image);

                // Añadir una transición de desvanecimiento para suavizar el cambio
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(500), imageShow);
                fadeTransition.setFromValue(0.0);
                fadeTransition.setToValue(1.0);
                fadeTransition.play();
            } else {
                System.out.println("Error: No se pudo cargar la imagen " + imagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void registrarse(ActionEvent actionEvent) {
    }
    @FXML
    public void ingresar(ActionEvent actionEvent) {
    }
    @FXML
    public void recuperarPass(ActionEvent actionEvent) {
    }
}
