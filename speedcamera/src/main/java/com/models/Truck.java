package com.models;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * The {@code Truck} class represents a truck which is a type of vehicle.
 * It extends the {@code Vehicle} class and provides a specific implementation
 * for displaying the truck and updating its speed label.
 */
public class Truck extends Vehicle {
    private Label label;

    /**
     * Constructs a new {@code Truck} with the specified lane, color, speed before, and current speed.
     *
     * @param lane the lane in which the truck is driving
     * @param color the color of the truck
     * @param speedBefore the speed of the truck before the current speed
     * @param speed the current speed of the truck
     */
    @SuppressWarnings("exports")
    public Truck(int lane, Color color, int speed,  int time) {
        super(lane, color, speed, time);
        this.label = new Label(String.format("Truck-%d\n    %d", getId(), getSpeed()));
        setWidth(60);
        setHeight(80);
    }

    /**
     * Displays the truck as a {@code StackPane} containing a rectangle and a label.
     * <p>
     * This method creates a graphical representation of the truck using a rectangle
     * to represent the truck's body and a label to display the truck's ID and speed.
     * </p>
     *
     * @return a {@code StackPane} containing a rectangle representing the truck and a label displaying the truck's ID and speed
     */
    @SuppressWarnings("exports")
    public StackPane displayVehicle() {
        Rectangle truck = new Rectangle(getWidth(), getHeight());
        truck.setFill(this.getColor());
        truck.setStroke(Color.BLACK);
        truck.setStrokeWidth(2);

        StackPane stack = new StackPane();
        stack.getChildren().addAll(truck, label);

        return stack;
    }

    /**
     * Updates the speed label of the truck.
     * <p>
     * This method updates the speed label of the truck to reflect the current speed.
     * The label displays the truck's ID and current speed.
     * </p>
     */
    public void updateSpeedLabel() {
        this.label.setText(String.format("Truck-%d\n    %d", getId(), getSpeed()));
    }
}
