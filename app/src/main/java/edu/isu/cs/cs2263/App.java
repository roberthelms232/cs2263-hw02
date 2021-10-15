/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs.cs2263;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;

public class App extends Application {
    private static volatile App singleton;

    private App(){}
    public App instance(){
        App local = singleton;
        if(local==null){
            synchronized (this){
                local = singleton;
                if(local==null){
                    singleton = local = new App();
                }
            }
        }
        return singleton;
    }

    public void start(Stage stage)throws Exception{
        stage.setTitle("Course View");

        Label sLabel = new Label("Students");
        Label cLabel = new Label("Courses");
        Label isTaking = new Label("Is Taking");

        ListView<Student> stuListView = new ListView<>();
        ListView<Course> courListView = new ListView<>();

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                IOManager io = new IOManager();
                ObservableList<Student> stuList = FXCollections.observableArrayList(io.readData("jsonData.txt"));
                stuListView.setItems(stuList);
                stuListView.setOnMouseClicked(evtHandler);
            }
            EventHandler<MouseEvent>evtHandler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent evt) {
                    IOManager io = new IOManager();
                    if(stuListView.getSelectionModel().getSelectedIndex() ==0){
                        courListView.setItems(FXCollections.observableList(io.readData("jsonData.txt").get(stuListView.getSelectionModel().getSelectedIndex()).getCourList()));
                    }
                    else if(stuListView.getSelectionModel().getSelectedIndex() ==1){
                        courListView.setItems(FXCollections.observableList(io.readData("jsonData.txt").get(stuListView.getSelectionModel().getSelectedIndex()).getCourList()));
                    }
                    else if(stuListView.getSelectionModel().getSelectedIndex()==2){
                        courListView.setItems(FXCollections.observableList(io.readData("jsonData.txt").get(stuListView.getSelectionModel().getSelectedIndex()).getCourList()));
                    }
                }
           };
        };

        Button load = new Button("Load Data");
        load.setOnMouseClicked(eventHandler);


        //Create the Layout
        GridPane layout = new GridPane();

        layout.add(sLabel, 0,0,1,1);
        layout.add(stuListView,0,1,2,2);
        layout.add(isTaking,2,2,1,1);
        layout.add(cLabel,3,0,1,1);
        layout.add(courListView,3,1,2,2);
        layout.add(load, 4,4,1,1);

        Scene scene = new Scene(layout, 600, 500);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        ArrayList<Student> stList = new ArrayList<>();
        IOManager io = new IOManager();

        Course CS1181 = new Course(1181,"CS","Intro to Programming");
        Course CS2263 = new Course(2263, "CS", "Advanced OO Programming");
        Course CS4423 = new Course(4423, "CS", "Software Evolution");

        ArrayList<Course> courList1 = new ArrayList<>();
        courList1.add(CS1181);
        courList1.add(CS2263);
        courList1.add(CS4423);

        ArrayList<Course> courList2 = new ArrayList<>();
        courList2.add(CS1181);
        courList2.add(CS2263);

        ArrayList<Course> courList3 = new ArrayList<>();
        courList3.add(CS4423);

        Student stu1 = new Student("Isaac","Griffith",courList1);
        Student stu2 = new Student("Bob","Sampson",courList2);
        Student stu3 = new Student("Sarah","James",courList3);

        stList.add(stu1);
        stList.add(stu2);
        stList.add(stu3);

        io.writeData("jsonData.txt", stList);

        Application.launch(args);
    }
}
