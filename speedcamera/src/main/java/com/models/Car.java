package com.models;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The {@code Car} class represents a car which is a type of vehicle.
 * It extends the {@code Vehicle} class and provides a specific implementation
 * for displaying the car and updating its speed label.
 */
public class Car extends Vehicle {
    private Label label;

    /**
     * Constructs a new {@code Car} with the specified lane, color, speed before, and current speed.
     *
     * @param lane the lane in which the car is driving
     * @param color the color of the car
     * @param speedBefore the speed of the car before the current speed
     * @param speed the current speed of the car
     */
    @SuppressWarnings("exports")
    public Car(int lane, Color color, int speed,int time) {
        super(lane, color, speed,time);
        this.label = new Label(String.format("Car-%d\n  %d", getId(), getSpeed()));
        setWidth(50);
        setHeight(70);
    }

    /**
     * Displays the car as a {@code StackPane} containing a rectangle and a label.
     * <p>
     * This method creates a graphical representation of the car using a rectangle
     * to represent the car's body and a label to display the car's ID and speed.
     * </p>
     *
     * @return a {@code StackPane} containing a rectangle representing the car and a label displaying the car's ID and speed
     */
    @SuppressWarnings("exports")
    public StackPane displayVehicle() {
        Rectangle car = new Rectangle(getWidth(), getHeight());
        car.setFill(this.getColor());
        car.setStrokeWidth(2);
        car.setStroke(Color.BLACK);

        StackPane stack = new StackPane();
        stack.getChildren().addAll(car, label);

        return stack;
    }

    /**
     * Updates the speed label of the car.
     * <p>
     * This method updates the speed label of the car to reflect the current speed.
     * The label displays the car's ID and current speed.
     * </p>
     */
    public void updateSpeedLabel() {
        label.setText(String.format("Car-%d\n  %d", getId(), getSpeed()));
    }
}
