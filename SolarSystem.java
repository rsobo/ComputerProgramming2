/**
 * Course COP3809C.02
 * @author Ryan Sobolewski
 * Purpose: Programming Assignment 2
 */

package solarsystem;

import exceptions.DuplicateCelestialBodyException;
import exceptions.InvalidCelestialBodyException;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import panes.ErrorPane;
import panes.SolarSystemPane;

public class SolarSystem extends Application {

	//runs program
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	//adds all bodies to the system and draws them
	public void start(Stage stage) throws Exception {
		try {
			SolarSystemPane pane = new SolarSystemPane();
			Star sun = new Star("Sun", 5778);
			Planet mercury = new Planet("Mercury", sun, Color.ORANGE, 25);
			Planet venus = new Planet("Venus", sun, Color.DARKOLIVEGREEN, 25);
			Planet earth = new Planet("Earth", sun, Color.BLUE, 30);
			Planet mars = new Planet("Mars", sun, Color.RED, 25);
			Planet jupiter = new Planet("Jupiter", sun, Color.ORANGERED, 40);
			Planet saturn = new Planet("Saturn", sun, Color.BEIGE, 40);
			Planet uranus = new Planet("Uranus", sun, Color.TEAL, 35);
			Planet neptune = new Planet("Neptune", sun, Color.PURPLE, 35);
			Moon theMoon = new Moon("Moon", earth, Color.ANTIQUEWHITE, 7);
			Moon phobos = new Moon("Phobos", mars, Color.ANTIQUEWHITE, 7);
			Moon deimos = new Moon("Deimos", mars, Color.ANTIQUEWHITE, 7);
			sun.add(mercury);
			sun.add(venus);
			sun.add(earth);
			sun.add(mars);
			sun.add(saturn);
			sun.add(jupiter);
			sun.add(uranus);
			sun.add(neptune);
			earth.add(theMoon);
			mars.add(deimos);
			mars.add(phobos);
			pane.addPlanet(mercury, 90);
			pane.addPlanet(venus, 150);
			pane.addPlanet(earth, 225);
			pane.addPlanet(mars, 300);
			pane.addPlanet(jupiter, 375);
			pane.addPlanet(saturn, 450);
			pane.addPlanet(uranus, 525);
			pane.addPlanet(neptune, 600);
			theMoon.setOrbitPath(pane.addMoon(theMoon, 40));
			phobos.setOrbitPath(pane.addMoon(phobos, 35));
			deimos.setOrbitPath(pane.addMoon(deimos, 45));
			pane.addStar(sun);
			setPath(90, mercury);
			setPath(150, venus);
			setPath(225, earth);
			setPath(300, mars);
			setPath(375, jupiter);
			setPath(450, saturn);
			setPath(525, uranus);
			setPath(600, neptune);
			setPath(265, phobos);
			setPath(255, deimos);
			setPath(185, theMoon);
			setMoonOrbitPath(225, theMoon.getOrbitPath(), new Duration(5000));
			setMoonOrbitPath(300, phobos.getOrbitPath(), new Duration(6000));
			setMoonOrbitPath(300, deimos.getOrbitPath(), new Duration(6000));
			Scene scene = new Scene(pane, 700, 700);
			stage.setScene(scene);
			stage.setTitle("Animated Solar System");
			stage.show();
		} catch (InvalidCelestialBodyException | DuplicateCelestialBodyException e) { //catches 2 exceptions
			ErrorPane errorPane = new ErrorPane(e.getStackTrace().toString());
			Stage errorStage = new Stage();
			errorStage.setTitle("Error");
			errorStage.setScene(new Scene(errorPane, 200, 250));
			errorStage.show();
		}
	}
	//animates the planets
	public void setPath(double dist, CelestialBody body) {
		Path path = new Path();
		dist = 1.38 * dist;
		path.getElements().add(new MoveTo(dist, 0));
		path.getElements().add(new CubicCurveTo(dist, 0, dist, dist, 0, dist));
		PathTransition pathTransition = new PathTransition();
		switch (body.getName()) {
		case "Mercury":
			pathTransition.setDuration(new Duration(3000));
			break;
		case "Venus":
			pathTransition.setDuration(new Duration(4000));
			break;
		case "Earth":
			pathTransition.setDuration(new Duration(5000));
			break;
		case "Mars":
			pathTransition.setDuration(new Duration(6000));
			break;
		case "Jupiter":
			pathTransition.setDuration(new Duration(7000));
			break;
		case "Saturn":
			pathTransition.setDuration(new Duration(8000));
			break;
		case "Uranus":
			pathTransition.setDuration(new Duration(9000));
			break;
		case "Neptune":
			pathTransition.setDuration(new Duration(10000));
			break;
		case "Moon":
			pathTransition.setDuration(new Duration(5000));
			break;
		default:
			pathTransition.setDuration(new Duration(6000));
			break;
		}
		pathTransition.setNode(body);
		pathTransition.setPath(path);
		pathTransition.setCycleCount(4000);
		pathTransition.setAutoReverse(false);
		pathTransition.play();
	}
	//animates the moon and moon orbit paths
	public void setMoonOrbitPath(double dist, Circle body, Duration dur) {
		Path path = new Path();
		dist = 1.38 * dist;
		path.getElements().add(new MoveTo(dist, 0));
		path.getElements().add(new CubicCurveTo(dist, 0, dist, dist, 0, dist));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(dur);
		pathTransition.setNode(body);
		pathTransition.setPath(path);
		pathTransition.setCycleCount(4000);
		pathTransition.setAutoReverse(false);
		pathTransition.play();
	}

}
