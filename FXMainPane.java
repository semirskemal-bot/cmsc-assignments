

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	private Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Label l1;
	TextField t1;
	HBox h1;
	HBox h2;
	
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager d1;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes

		 b1 = new Button("Hello");
		 b2 = new Button("Howdy");
		 b3 = new Button("Chinese");
		 b4 = new Button("Clear");
		 b5 = new Button("exit");
		 l1 = new Label("Feedback");
		 t1 = new TextField();
		 h1 = new HBox();
		 h2 = new HBox();
		 d1 = new DataManager();
		 
		 h1.getChildren().addAll(b1, b2,b3,b4,b5);
		 h2.getChildren().addAll(t1,l1);
		 
		  h1.setAlignment(Pos.CENTER);
	      h2.setAlignment(Pos.CENTER);

	      h1.setSpacing(10);
	      h2.setSpacing(10);

	      this.setSpacing(20);
	      this.setAlignment(Pos.CENTER);

		 this.getChildren().addAll(h1,h2);
		 ButtonHandler handler = new ButtonHandler();

		 b1.setOnAction(handler);
		 b2.setOnAction(handler);
		 b3.setOnAction(handler);
		 b4.setOnAction(handler);
		 b5.setOnAction(handler);
		 
		 

		
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
	}
	private class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub

            if (event.getTarget() == b1) {
                t1.setText(d1.getHello());
            }
            else if (event.getTarget() == b2) {
                t1.setText(d1.getHowdy());
            }
            else if (event.getTarget() == b3) {
                t1.setText(d1.getChinese());
            }
            else if (event.getTarget() == b4) {
                t1.setText("");
            }
            else if (event.getTarget() == b5) {
                Platform.exit();
                System.exit(0);
            }
		}
	}

		
	}
	//Task #4:
	//  create a private inner class to handle the button clicks

	
