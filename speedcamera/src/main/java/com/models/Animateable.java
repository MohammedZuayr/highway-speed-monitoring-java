package com.models;

import javafx.scene.layout.StackPane;

/**
 * The {@code Animateable} interface provides methods for displaying and
 * updating the visual representation of a vehicle.
 * <p>
 * Implementing classes should provide the logic for rendering the vehicle
 * in a graphical user interface and updating the displayed speed information.
 * </p>
 */
public interface Animateable {

    /**
     * Displays the vehicle in a {@code StackPane}.
     * <p>
     * This method should return a {@code StackPane} containing the graphical
     * representation of the vehicle.
     * </p>
     *
     * @return a {@code StackPane} representing the vehicle
     */
    @SuppressWarnings("exports")
    StackPane displayVehicle();

    /**
     * Updates the speed label displayed on the vehicle's graphical representation.
     * <p>
     * This method should update the speed label to reflect the current speed
     * of the vehicle.
     * </p>
     */
    void updateSpeedLabel();
}
