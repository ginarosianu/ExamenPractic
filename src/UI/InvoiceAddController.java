//package UI;
//
//import Service.CarService;
//import javafx.event.ActionEvent;
//import javafx.scene.control.Button;
//import javafx.scene.control.Spinner;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//public class InvoiceAddController {
//    public Spinner spnId;
//    public TextField txtInvoiceAmmount;
//    public TextField txtInvoiceDescription;
//    public TextField txtInvoiceDate;
//    public Button btnAddInvoice;
//    public Button btnCancel;
//
//
//    public void setService(CarService service) {
//        this.service = service;
//    }
//
//    public void btnAddClick(ActionEvent actionEvent) {
//        try {
//            String id = String.valueOf(spnId.getValue());
//            int ammount = Integer.parseInt(txtInvoiceAmmount.getText());
//            String description = txtInvoiceDescription.getText();
//            String date = txtInvoiceDate.getText();
//            service.insert(id, ammount, description, date);
//            btnCancelClick(actionEvent);
//        } catch (RuntimeException rex) {
//            Common.showValidationError(rex.getMessage());
//        }
//
//    }
//
//
//    public void btnCancelClick(ActionEvent actionEvent) {
//        Stage stage = (Stage) btnCancel.getScene().getWindow();
//        stage.close();
//    }
//}
