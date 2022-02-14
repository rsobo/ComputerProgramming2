package calcuator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Calculator extends Application {

	private TextField textDisp = new TextField();
	private double data = 0;
	private int op = -1;

	@Override
	public void start(Stage stage) throws Exception {
		//creates the outline of the calculator
		//ie the pane, stage, text field, etc
		BorderPane masterPane = new BorderPane();
		HBox display = new HBox();
		display.setAlignment(Pos.CENTER);
		display.setPadding(new Insets(5, 5, 5, 5));
		masterPane.setTop(display);
		textDisp.setPrefWidth(300);
		textDisp.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		display.getChildren().add(textDisp);
		masterPane.setCenter(getGrid());
		stage.setScene(new Scene(masterPane, 300, 300));
		stage.setTitle("Simple Calculator");
		stage.show();

	}

	//returns the grid for the numbers/symbols of the calc
	private GridPane getGrid() {
		GridPane grid = new GridPane();
		//makes each button to be in line
		for (int i = 0; i < 4; i++) {
			RowConstraints rc = new RowConstraints();
			rc.setFillHeight(true);
			rc.setVgrow(Priority.ALWAYS);
			grid.getRowConstraints().add(rc);
			ColumnConstraints cc = new ColumnConstraints();
			cc.setFillWidth(true);
			cc.setHgrow(Priority.ALWAYS);
			grid.getColumnConstraints().add(cc);
		}
		//creates the buttons
		for (int i = 0; i < 9; i++) {
			Button butt = createButt(Integer.toString(i + 1));
			grid.add(butt, i % 3, i / 3);
		}
		grid.add(createButt("0"), 0, 3);
		grid.add(createButt("="), 1, 3);
		grid.add(createButt("CLR"), 2, 3);
		grid.add(createButt("+"), 3, 0);
		grid.add(createButt("-"), 3, 1);
		grid.add(createButt("*"), 3, 2);
		grid.add(createButt("/"), 3, 3);
		return grid;
	}

	//returns a button representing the passed text
	private Button createButt(String text) {
		Button butt = new Button(text);
		butt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		butt.setOnAction(e -> handleButtonAction(text));
		return butt;
	}

	//handles all clicking events and the math behind them
	private void handleButtonAction(String text) {
		try {
			switch(text) {
				case "CLR":
					//reset data and operator
					textDisp.setText("");
					data = 0;
					op = -1;
					break;
				case "+":
					data = Double.parseDouble(textDisp.getText());
					op = 1; //1 = addition
					textDisp.setText("");
					break;
				case "-":
					data = Double.parseDouble(textDisp.getText());
					op = 2; //2 = subtract
					textDisp.setText("");
					break;
				case "*":
					data = Double.parseDouble(textDisp.getText());
					op = 3; //3 = multiply
					textDisp.setText("");
					break;
				case "/":
					data = Double.parseDouble(textDisp.getText());
					op = 4; //4 = divide
					textDisp.setText("");
					break;
				case "=":
					double newData = Double.parseDouble(textDisp.getText());
					switch(op) {
						case 1:
							textDisp.setText(Double.toString(data+newData));
							break;
						case 2:
							textDisp.setText(Double.toString(data-newData));
							break;
						case 3:
							textDisp.setText(Double.toString(data*newData));
							break;
						case 4:
							textDisp.setText(Double.toString(data/newData));
							break;
					}
					break;
				default: {
					textDisp.setText(textDisp.getText() + text);
					break;
				}
			}
			//handles exception if there isnt a number inserted
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
			
		}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
