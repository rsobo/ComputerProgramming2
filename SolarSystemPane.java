package panes;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import solarsystem.Moon;
import solarsystem.Planet;
import solarsystem.Star;

public class SolarSystemPane extends Pane{
	
	public SolarSystemPane() {
		setBackground(new Background(new BackgroundFill(Color.BLACK,  CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	//adds a star to the pane at (0, 0)
	public void addStar(Star star) {
		getChildren().add(star);
	}
	
	//adds a planet to the pane and draws orbit path
	public void addPlanet(Planet planet, double distance) {
		planet.setCenterX(distance);
		planet.setCenterY(distance);
		Circle orbit = new Circle();
		orbit.setFill(Color.TRANSPARENT);
		orbit.setMouseTransparent(true);
		orbit.setStroke(Color.GREY);
		orbit.setRadius(Math.sqrt(Math.pow(planet.getOrbit().getLayoutX() - distance, 2) + Math.pow(planet.getOrbit().getLayoutY() - distance,2)));
		getChildren().add(orbit);
		getChildren().add(planet);
	}
	
	//adds a moon to the pane and draws orbit path
	//returns the orbit for animation purposes
	public Circle addMoon(Moon moon, double distance) {
		moon.setCenterX(moon.getOrbit().getCenterX() + distance);
		moon.setCenterY(moon.getOrbit().getCenterY() - distance);
		Circle orbit = new Circle();
		orbit.setCenterX(moon.getOrbit().getCenterX());
		orbit.setCenterY(moon.getOrbit().getCenterX());
		orbit.setFill(Color.TRANSPARENT);
		orbit.setMouseTransparent(true);
		orbit.setStroke(Color.GREY);
		orbit.setRadius(Math.sqrt(Math.pow(moon.getOrbit().getLayoutX() - distance, 2)+ Math.pow(moon.getOrbit().getLayoutY() - distance,2)));
		getChildren().add(orbit);
		getChildren().add(moon);
		return orbit;
	}
	
}
