package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class SalaryGUIFX extends Application {
	Pane pane = null;                    
	TextField outputField = null;
	TextField inputField = null;
	int hourlyWage;
	int yearlySalary;
   @Override
   public void start(Stage applicationStage) {
      Button button = new Button("Update Salary Figures");
      
      pane = new Pane();                              
      VBox vBox = new VBox(pane);
      Scene scene = new Scene(vBox, 360, 200);
            
      hourlyWage = 50;
      yearlySalary = hourlyWage * 40 * 50;
      
      inputField = new TextField();
      outputField = new TextField();
      outputField.setText("An hourly wage of $" + hourlyWage + "/hr " + "yields $" + yearlySalary + "/yr.");
      outputField.setEditable(false);      
      
      button.setOnAction(event -> {
    	  try {
    		  hourlyWage = Integer.parseInt(inputField.getText());
    		  yearlySalary = hourlyWage * 40 * 50;
    		  outputField.setText("An hourly wage of $" + hourlyWage + "/hr " + "yields $" + yearlySalary + "/yr.");
    		  outputField.setEditable(false);       
    	  } catch (Exception err) {
    		  System.out.println("There has been an error");
    		  System.out.println(err);
    		  outputField.setText("An error occured during calculation, confirm valid integer is being supplied.");
    		  outputField.setEditable(false);  
    	  }
      });
      
      pane.getChildren().addAll(inputField, button, outputField);
      vBox.getChildren().addAll(inputField, button, outputField);
      vBox.setSpacing(10);
      
      applicationStage.setScene(scene);   
      applicationStage.setTitle("Simple Salary Calculation"); 
      applicationStage.show();             
   }
   
   public static void main(String [] args) {
      launch(args); 
   }
}