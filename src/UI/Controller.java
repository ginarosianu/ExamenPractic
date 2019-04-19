package UI;

import Domain.Invoice;
import Service.InvoiceService;
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


    public TableView tableViewInvoices;
    public TableColumn tableColumnId;
    public TableColumn tableColumnAmmount;
    public TableColumn tableColumnDescription;
    public TableColumn tableColumnDate;
    public TextField txtInvoiceDateForSum;
    public Label sum;

    public InvoiceService service;


    private ObservableList<Invoice> invoices = FXCollections.observableArrayList();


    public void setServices(InvoiceService service) {
        this.service = service;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            invoices.addAll(service.getAll());
            tableViewInvoices.setItems(invoices);
        });
    }


    public void btnInvoiceAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("invoiceAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add invoice");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            InvoiceAddController controller = fxmlLoader.getController();
            controller.setService(service);
            stage.showAndWait();
            invoices.clear();
            invoices.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window: Movie update.", e);
        }

    }

    public void btnInvoicesSumClick(ActionEvent actionEvent) {
        String a = txtInvoiceDateForSum.getText();

        try {
            if (a.charAt(2) != '.' || a.charAt(5) != '.') {
                throw new RuntimeException("Date format should be dd.mm.yyy\n");
            }
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
        int sumOfAll = 0;
        List<Invoice> all = service.getAll();
        for (Invoice i : all) {
            if (i.getDate().equals(a)) {
                sumOfAll += i.getAmmount();
            }
        }
        sum.setText(sumOfAll + "");
    }
}
