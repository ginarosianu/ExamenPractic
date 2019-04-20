package UI;

import Domain.Car;
import Service.CarService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {


    public CarService service;
    public TableView tableViewCars;
    public TableColumn tableColumnId;
    public TableColumn tableColumnModel;
    public TableColumn tableColumnKilometers;
    public TableColumn tableColumnPrice;


    private ObservableList<Car> cars = FXCollections.observableArrayList();


    public void setServices(CarService service) {
        this.service = service;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            cars.addAll(service.getAll());
            tableViewCars.setItems(cars);
        });
    }


    public void btnCarAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("carAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add invoice");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            CarAddController controller = fxmlLoader.getController();
            controller.setService(service);
            stage.showAndWait();
            cars.clear();
            cars.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Movie update.", e);
        }

    }


//    public void btnCarAddClick(ActionEvent actionEvent) {
//    }
}
