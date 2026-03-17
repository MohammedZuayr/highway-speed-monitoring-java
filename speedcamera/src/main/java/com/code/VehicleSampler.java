package com.code;

import java.util.ArrayList;
import java.util.Random;

import com.models.*;

import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * The {@code VehicleSampler} class is responsible for generating and managing a sample of vehicles.
 * It can load vehicles, detect vehicles using a camera, generate records for vehicles, and translate vehicle speeds into durations.
 */
public class VehicleSampler {
    private ArrayList<Vehicle> vehicles;
    private Random random = new Random();
    private Color[] colors = {Color.WHITE, Color.LIGHTCORAL, Color.LIGHTSALMON, Color.LIGHTBLUE, Color.LIGHTYELLOW, Color.LIGHTGOLDENRODYELLOW};
    private int[] time = {15, 16, 20, 30, 32, 40};
    private int[] speeds = {60,75,85,120,150,160};
    private Camera camera = new Camera();

    /**
     * Constructs a new {@code VehicleSampler} with the specified sample size.
     *
     * @param sampleSize the number of vehicles to be loaded into the system
     */
    public VehicleSampler(int sampleSize) {
        loadVehicles(sampleSize);
    }

    /**
     * Loads a specified number of vehicles into the system.
     * <p>
     * The vehicles are randomly generated with different attributes such as lane, color, and speed.
     * Whether the vehicles are cars or trucks depends on the lane number chosen.
     * </p>
     *
     * @param sampleSize the number of vehicles to be loaded into the system
     */
    private void loadVehicles(int sampleSize) {
        // Initialize the ArrayList to store the vehicles
        this.vehicles = new ArrayList<>();

        // Declare variables to hold random attributes for each vehicle
        int randomLane;
        Color randomColor;
       
        int randomSpeed;
        int randomTime;

        // Declare a variable to hold the current vehicle being created
        Vehicle vehicle;

        // Loop to generate the specified number of vehicles
        for (int i = 0; i < sampleSize; i++) {
            // Generate random attributes for the vehicle
            randomLane = this.random.nextInt(4) + 1;
            randomColor = this.colors[this.random.nextInt(this.colors.length)];
            randomTime = this.time[this.random.nextInt(this.time.length)];
            
            randomSpeed = this.speeds[this.random.nextInt(this.speeds.length)];
            randomTime = this.time[random.nextInt(time.length)];
            switch(randomTime) {
            case 15:
                randomSpeed = 160;
                break;
              case 16:
            	  randomSpeed = 150;
                break;
              case 20:
            	  randomSpeed = 120;
                break;
              case 30:
            	  randomSpeed = 85;
                break;
              case 32:
            	  randomSpeed = 75;
                break;
              case 40:
            	  randomSpeed = 60;
                break;
            }
            // Determine the type of vehicle to create based on the random lane
            if (randomLane != 4) {
                // Create a car vehicle
                vehicle = new Car(randomLane, randomColor,  randomSpeed, randomTime);
            } else {
                // Create a truck vehicle
                vehicle = new Truck(randomLane, randomColor,randomSpeed, randomTime);
            }

            // Add the vehicle to the ArrayList
            vehicles.add(vehicle);
        }
    }

    /**
     * Gets the list of vehicles.
     *
     * @return an {@code ArrayList} of {@code Vehicle} objects
     */
    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /**
     * Gets the total number of tickets issued.
     *
     * @return the total number of tickets issued
     */
    public int getTicketsTotal() {
        return this.camera.getCounter();
    }

    /**
     * Detects a vehicle using the camera.
     * <p>
     * This method initiates tests on the given vehicle and returns a boolean value indicating whether a ticket should be issued.
     * </p>
     *
     * @param vehicle the vehicle to be detected by the camera
     * @return a boolean value indicating whether a ticket should be issued for the detected vehicle
     */
    public boolean detectVehicle(Vehicle vehicle) {
        return this.camera.initiateTests(vehicle);
    }

    /**
     * Generates a record for a given vehicle.
     * <p>
     * This method takes a vehicle object as input and returns a {@code TableRecord} object containing the vehicle's ID,
     * speed at the first camera, speed at the second camera, and a boolean value indicating whether a ticket should be issued.
     * </p>
     *
     * @param vehicle the vehicle for which a record is to be generated
     * @return a {@code TableRecord} object containing the vehicle's details and a boolean value for ticket issuance
     */
    public TableRecord getRecord(Vehicle vehicle) {
        return new TableRecord(
            Integer.toString(vehicle.getId()),
            Integer.toString(vehicle.getTime()),
            Integer.toString(vehicle.getSpeed()),
            Boolean.toString(detectVehicle(vehicle))
        );
    }

    /**
     * Translates a vehicle's speed into a duration.
     * <p>
     * This method takes an integer representing the vehicle's speed and returns a {@code Duration} object.
     * The duration is determined based on a switch statement that maps different speeds to specific durations.
     * </p>
     *
     * @param speed the speed of the vehicle in integers
     * @return a {@code Duration} object representing the time it takes for the vehicle to pass a certain point
     */
    @SuppressWarnings("exports")
    public Duration translateDuration(int speed) {
        switch (speed) {
            case 60:
                return Duration.seconds(3);
            case 75:
                return Duration.seconds(2.5);
            case 85:
                return Duration.seconds(2);
            case 120:
                return Duration.seconds(1.5);
            case 150:
                return Duration.seconds(1.25);
            case 160:
                return Duration.seconds(0.75);
            default:
                return Duration.seconds(0);  // Shouldn't ever happen.
        }
    }
}
