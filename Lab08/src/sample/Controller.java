package sample;



import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import java.io.*;
import java.util.*;


public class Controller {

    private File currentFilename;
    @FXML
    private TableView<StudentRecord> tableView;
    @FXML
    private TableColumn<Object,Object> studentID;
    @FXML
    private TableColumn<Object,Object> assignments;
    @FXML
    private TableColumn<Object,Object> midterms;
    @FXML
    private TableColumn<Object,Object> finalExam;
    @FXML
    private TableColumn<Object,Object> finalMark;
    @FXML
    private TableColumn<Object,Object> letterGrade;


    public void initialize(){

        studentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        assignments.setCellValueFactory(new PropertyValueFactory<>("assignments"));
        midterms.setCellValueFactory(new PropertyValueFactory<>("midterm"));
        finalMark.setCellValueFactory(new PropertyValueFactory<>("finalMark"));
        finalExam.setCellValueFactory(new PropertyValueFactory<>("finalExam"));
        letterGrade.setCellValueFactory(new PropertyValueFactory<>("letterGrade"));

        tableView.setItems(DataSource.getAllMarks());


    }
    public void save(){

        System.out.println("saved");
    }

    public void New(){

    }


    public void exit(){
        System.exit(0);
    }

}

