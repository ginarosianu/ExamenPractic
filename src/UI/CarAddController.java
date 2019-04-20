package UI;

import Service.CarService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Service.CarService;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CarAddController {


    public Spinner spnId;
    public TextField txtCarModel;
    public TextField txtCarKilometers;
    public TextField txtCarPrice;
    public Button btnAddCar;
    public Button btnCancel;

    private CarService service;

    public void setService(CarService service) {
        this.service = service;
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf( spnId.getValue() );
            String model = txtCarModel.getText();
            int kilometers = Integer.parseInt( txtCarKilometers.getText() );
            int price = Integer.parseInt( txtCarPrice.getText() );
            service.insert( id, model, kilometers, price );
            btnCancelClick( actionEvent );
        } catch (RuntimeException rex) {
            Common.showValidationError( rex.getMessage() );
        }

    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
