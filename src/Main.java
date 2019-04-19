import Domain.InvoiceValidator;
import Repository.InMemoryRepository;
import Service.InvoiceService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller =  fxmlLoader.getController();

        InvoiceValidator validator = new InvoiceValidator();
        InMemoryRepository repository = new InMemoryRepository(validator);
        InvoiceService service = new InvoiceService(repository);

        service.insert("1",20,"gas","22.11.2013");
        service.insert("2",20,"cosmetics","20.11.2013");
        service.insert("3",20,"food","21.11.2013");
        service.insert("4",20,"city break","20.11.2013");
        service.insert("5",20,"taxes","20.11.2013");
        service.insert("6",20,"electricity","19.11.2013");

        controller.setServices(service);


        primaryStage.setTitle("Invoice Manager");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
