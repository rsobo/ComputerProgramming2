import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MineSweeperMain extends Application{

	private static int[][] grid = createGrid();
	public static void main(String[] args) {
		//printArray(grid);
		Application.launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(20, 0, 0, 50));
		for(int i = 0; i < 16; i++) {
			ColumnConstraints column = new ColumnConstraints(75);
	        pane.getColumnConstraints().add(column);
			for(int j = 0; j < 23; j++) {
				RowConstraints row = new RowConstraints(40);
		        pane.getRowConstraints().add(row);
		        Label num;
		        if(grid[i][j] == 9) {
		        	num = new Label("   B");
		        	num.setStyle("-fx-font-weight: bold; -fx-text-fill: Red");
		        }else if(grid[i][j] == 0) {
		        	num = new Label("   " + String.valueOf(grid[i][j]));
		        	num.setStyle("-fx-font-weight: bold; -fx-text-fill: Green");
		        }else if(grid[i][j] == 1) {
		        	num = new Label("   " + String.valueOf(grid[i][j]));
		        	num.setStyle("-fx-font-weight: bold; -fx-text-fill: DodgerBlue");
		        }else if(grid[i][j] == 2) {
		        	num = new Label("   " + String.valueOf(grid[i][j]));
		        	num.setStyle("-fx-font-weight: bold; -fx-text-fill: Purple");
		        }else if(grid[i][j] == 3) {
		        	num = new Label("   " + String.valueOf(grid[i][j]));
		        	num.setStyle("-fx-font-weight: bold; -fx-text-fill: Gold");
		        }else if(grid[i][j] == 4) {
		        	num = new Label("   " + String.valueOf(grid[i][j]));
		        	num.setStyle("-fx-font-weight: bold; -fx-text-fill: Orange");
		        }else {
		        	num = new Label("   " + String.valueOf(grid[i][j]));
		        	num.setStyle("-fx-font-weight: bold; -fx-text-fill: Black");
		        }
				num.setFont(new Font("Arial", 25));
				pane.add(num, i, j);
				Rectangle rNum = new Rectangle(60, 35, Color.TRANSPARENT);
				rNum.setStroke(Color.BLACK);
				pane.add(rNum, i, j);
				Rectangle r = new Rectangle(60, 35, Color.TOMATO);
				r.setStroke(Color.BLACK);
				pane.add(r, i, j);
				r.setOnMouseClicked(e -> r.setVisible(false));
			}
		}
		Scene scene = new Scene(pane, 1300, 1000);
		stage.setTitle("Minesweeper");
		stage.setScene(scene);
		stage.show();
	}

	
	private static int[][] createGrid() {
		int[][] grid = new int[16][23];
		Random rand = new Random();
		for(int i = 0; i < 70; i++) {
			int xRand = rand.nextInt(16);
			int yRand = rand.nextInt(23);
			grid[xRand][yRand] = 9;
		}
		int count = 0;
		for(int i = 1; i < 15; i++) {
			for(int j = 1; j < 22; j++) {
				if(grid[i][j] != 9) {
					if(grid[i-1][j] == 9) {
						count++;
					}
					if(grid[i+1][j] == 9) {
						count++;
					}
					if(grid[i][j-1] == 9) {
						count++;
					}
					if(grid[i][j+1] == 9) {
						count++;
					}
				}
				else {
					count = 9;
				}
				grid[i][j] = count;
				count = 0;
			}
		}
		for(int i = 1; i < 15; i++) {
			if(grid[i][0] != 9) {
				if(grid[i+1][0] == 9) {
					count++;
				}
				if(grid[i][1] == 9) {
					count++;
				}
				if(grid[i-1][0] == 9) {
					count++;
				}
			}else {
				count = 9;
			}
			grid[i][0] = count;
			count = 0;
		}
		for(int i = 1; i < 15; i++) {
			if(grid[i][22] != 9) {
				if(grid[i+1][22] == 9) {
					count++;
				}
				if(grid[i][21] == 9) {
					count++;
				}
				if(grid[i-1][22] == 9) {
					count++;
				}
			}else {
				count = 9;
			}
			grid[i][22] = count;
			count = 0;
		}
		for(int j = 1; j < 22; j++) {
			if(grid[0][j] != 9) {
				if(grid[0][j-1] == 9) {
					count++;
				}
				if(grid[0][j+1] == 9) {
					count++;
				}
				if(grid[1][j] == 9) {
					count++;
				}
			}else {
				count = 9;
			}
			grid[0][j] = count;
			count = 0;
		}
		for(int j = 1; j < 22; j++) {
			if(grid[15][j] != 9) {
				if(grid[15][j-1] == 9) {
					count++;
				}
				if(grid[15][j+1] == 9) {
					count++;
				}
				if(grid[14][j] == 9) {
					count++;
				}
			}else {
				count = 9;
			}
			grid[15][j] = count;
			count = 0;
		}
		if(grid[0][0] != 9) {
			if(grid[0][1] == 9) {
				count++;
			}
			if(grid[1][0] == 9) {
				count++;
			}
			grid[0][0] = count;
			count = 0;
		}
		if(grid[15][0] != 9) {
			if(grid[15][1] == 9) {
				count++;
			}
			if(grid[15][0] == 9) {
				count++;
			}
			grid[15][0] = count;
			count = 0;
		}
		if(grid[0][22] != 9) {
			if(grid[0][21] == 9) {
				count++;
			}
			if(grid[1][22] == 9) {
				count++;
			}
			grid[0][22] = count;
			count = 0;
		}
		if(grid[15][22] != 9) {
			if(grid[14][22] == 9) {
				count++;
			}
			if(grid[15][21] == 9) {
				count++;
			}
			grid[15][22] = count;
			count = 0;
		}
		printArray(grid);
		return grid;
	}
	
	private static void printArray(int[][] grid) {
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 22; j++) {
				System.out.print(grid[i][j] + ", ");
			}
			System.out.println();
		}
	}

}
