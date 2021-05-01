package application;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;

public class UserInterfaceTwo extends Application {
	// Create new variables outside of start so they can be modified with lambda event handlers
	TextField dateAndTime = null;
	Pane pane = null;
	Paint myColor = null;
	
	// get a random hue of green for 3rd menu item event handler
	public void getColor() {
		Color myArray[] = new Color[]{Color.LIME, Color.GREEN, Color.rgb(204, 255, 51), Color.rgb(204, 255, 204), Color.rgb(102, 255, 153)};
		Random generator = new Random();
		int randomIndex = generator.nextInt(myArray.length);
		myColor = myArray[randomIndex];
	}
	
	// override start as required for JavaFX application
	@Override
	public void start(Stage interfaceStage) {
		// create new menu bar to hold menu items, create new pane, create new vbox with pane and menubar, create new scene
		MenuBar menuBar = new MenuBar();
		pane = new Pane();
        VBox vBox = new VBox(menuBar, pane);
        Scene scene = new Scene(vBox, 360, 200);
        
        // add title to menu
        Menu menuInterface = new Menu("User Interface Menu");
        menuBar.getMenus().add(menuInterface);
        
        // add four new menu items and add them to menu interface
        MenuItem menuItem1 = new MenuItem("Get Date and Time (UTC)");
        MenuItem menuItem2 = new MenuItem("Save Date and Time");
        MenuItem menuItem3 = new MenuItem("Green Color Hue");
        MenuItem menuItem4 = new MenuItem("Exit Program");
        menuInterface.getItems().add(menuItem1);
        menuInterface.getItems().add(menuItem2);
        menuInterface.getItems().add(menuItem3);
        menuInterface.getItems().add(menuItem4);
        
        // add text field and placeholder for date and time, make so user cannot edit
        dateAndTime = new TextField();
        dateAndTime.setText("Date and Time (UTC)");
        dateAndTime.setEditable(false); 
	    
        // add text field and place date placeholder towards bottom
        pane.getChildren().add(dateAndTime);
        vBox.getChildren().addAll(dateAndTime);
        vBox.setSpacing(70);
        
        // set up action for menu item 1, which changes date placeholder to current date and time string in UTC format
        menuItem1.setOnAction(event -> {
        	  dateAndTime.setText(java.time.Clock.systemUTC().instant().toString());
        });
          
        // set up action for menu item 2, which logs date and time UTC to log.txt file
        menuItem2.setOnAction(event -> {
       	  try {
       		  FileWriter fileWriter = new FileWriter("C:/projects/log.txt");
       		  PrintWriter printWriter = new PrintWriter(fileWriter); 
			  printWriter.print("Logging new date and time (UTC) instance:\n");
 			  printWriter.print(dateAndTime.getText());
 		      printWriter.close();
       	  } catch (Exception e) {
       		  System.out.println("An error occured, see below for details");
       		  System.out.println(e);
       	  }
        });
        
        // set up action for menu item 3, which changes background color of vbox to random hue of green
        menuItem3.setOnAction(event -> {
        	  getColor();
        	  vBox.setBackground(new Background(new BackgroundFill(myColor, null, null)));
        });
          
        // set up action for menu item 4, which closes program on selection
        menuItem4.setOnAction(event -> {
        	  System.exit(0);
        });
        
        // add scene to stage, add title to application, make stage visible
	    interfaceStage.setScene(scene);    
	    interfaceStage.setTitle("Simple User Interface"); 
	    interfaceStage.show();             
	}

	// attempt to launch program, log error on fail
	public static void main(String [] args) {
		try {
			launch(args); 	
		} catch (Exception e) {
			System.out.println("An error occured.. " + e);
			System.out.println(e);
		}
    }
}
