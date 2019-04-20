import Domain.Car;
import Domain.CarValidator;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.CarService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CarValidator carValidator = new CarValidator();
        IRepository<Car> carIRepository = new InMemoryRepository<>(carValidator);
        CarService carService = new CarService(carIRepository);


        carService.insert("1","sedan",1110,25);
        carService.insert("2","sport",2000,30);
        carService.insert("3","camioneta",4000,50);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();
        controller.setServices(carService);


        primaryStage.setTitle("Car Manager");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


