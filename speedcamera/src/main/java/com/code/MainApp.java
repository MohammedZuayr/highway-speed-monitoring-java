package com.code;

import java.util.ArrayList;

import com.models.Vehicle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The {@code MainApp} class serves as the entry point for the Road Speeding simulation application.
 * It initializes the main application window and starts the simulation.
 */
public class MainApp extends Application {
    private int sampleSize = 50;
    private VehicleSampler vehiclesampler = new VehicleSampler(this.sampleSize);
    private ArrayList<Vehicle> vehicles = new ArrayList<>(this.vehiclesampler.getVehicles());
    private double carFrequency = 3;
    private AtomicInteger currentIndex = new AtomicInteger(0);

    private Timeline timeline;

    private SpeedingController controller;

    /**
     * Initializes the main application window and starts the simulation.
     *
     * @param primaryStage the primary stage for this application,
     *                     used to display the application's user interface.
     * @throws Exception if an error occurs while loading the FXML file or initializing the controllers.
     */
    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) throws Exception {
        // Load the FXML file and get the root layout and controller instance.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RoadSpeeding.fxml"));
        Parent root = loader.load();
        this.controller = loader.getController();

        // Initialize the vehicle animator and set its controller.
        VehicleAnimator vehicleAnimator = new VehicleAnimator((Pane) root);
        
        this.controller.initAnimator(vehicleAnimator);
        vehicleAnimator.initController(this.controller);

        // Set the primary stage title and scene, and show the stage.
        primaryStage.setTitle("Road Speeding");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // Initialize the simulation using the controller instance.
        initializeMainLoop();
    }

    /**
     * Initializes the simulation using the controller instance.
     *
     */
    private void initializeMainLoop() {
        // Create a new Timeline object with a carFrequency interval
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(this.carFrequency), event -> {
            // Generate a new car and add it to the simulation
            int index = this.currentIndex.get();
            if (index < this.vehicles.size()) {
                this.controller.generateCar(this.vehicles.get(index));
                index = this.currentIndex.getAndIncrement();
            }
        }));
    
        // Set the cycle count of the Timeline to match the size of the vehicles list
        this.timeline.setCycleCount(Timeline.INDEFINITE);
    
        // Start the simulation by playing the Timeline
        this.timeline.play();
    }

    /**
     * The main entry point of the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        // This method is the entry point of the JavaFX application.
        // It initializes the JavaFX application and starts the main application window.
        // The {@code launch} method is called to start the application.
        launch(args);
    }
}
