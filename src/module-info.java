module Test_Java_GUI {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
