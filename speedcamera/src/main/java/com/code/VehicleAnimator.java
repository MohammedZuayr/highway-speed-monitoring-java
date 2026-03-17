package com.code;

import com.models.TableRecord;
import com.models.Vehicle;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 * The {@code VehicleAnimator} class handles animations of vehicles on wires.
 * It provides methods to animate vehicles on wires and manage their transitions.
 */
public class VehicleAnimator {

    private Pane root;
    private SpeedingController controller;

    /**
     * Constructs a new {@code VehicleAnimator} with the specified root pane.
     *
     * @param root The root pane on which the vehicles will be animated.
     */
    @SuppressWarnings("exports")
    public VehicleAnimator(Pane root) {
        this.root = root;
    }

    /**
     * Initializes the controller for the animator.
     *
     * @param controller The controller to be initialized.
     */
    public void initController(SpeedingController controller) {
        this.controller = controller;
    }

    /**
     * Animates a vehicle on two wires over two durations, then adds a record and removes the vehicle from the root.
     *
     * @param vehicle The vehicle to be animated.
     * @param wire1 The first wire on which the vehicle will be animated.
     * @param wire2 The second wire on which the vehicle will be animated.
     * @param initialSpeed The initial speed of the vehicle's animation.
     * @param finalSpeed The final speed of the vehicle's animation.
     * @param record The record to be added after the vehicle's animation is complete.
     */
    @SuppressWarnings("exports")
    public void animateVehicleOnWires(Vehicle vehicle, Line wire1, Line wire2, Duration finalSpeed, TableRecord record) {
        StackPane renderedVehicle = vehicle.displayVehicle();

        root.getChildren().add(renderedVehicle);

        renderedVehicle.setLayoutX(wire1.getEndX() + vehicle.getWidth() + 30);
        renderedVehicle.setLayoutY(wire1.getEndY() - vehicle.getHeight() - 10);

        animateVehicle(renderedVehicle, wire1, finalSpeed, Interpolator.LINEAR, () -> {
            animateVehicleOnSecondWire(vehicle, renderedVehicle, wire2, finalSpeed, () -> {
                controller.addRecord(record);
                root.getChildren().remove(renderedVehicle);
                this.controller.incrementDeservedTotal();
            });
        });
    }

    /**
     * Animates a vehicle on a single wire over a specified duration, then calls the provided onFinished Runnable.
     *
     * @param vehicle The vehicle to be animated.
     * @param wire The wire on which the vehicle will be animated.
     * @param duration The duration of the vehicle's animation.
     * @param interpolator The interpolator to be used for the animation.
     * @param onFinished The Runnable to be called when the animation is finished.
     */
    private void animateVehicle(StackPane vehicle, Line wire, Duration duration, Interpolator interpolator, Runnable onFinished) {
        PathTransition transition = new PathTransition();
        transition.setNode(vehicle);
        transition.setPath(wire);

        transition.setDuration(duration);
        transition.setCycleCount(1);
        transition.setAutoReverse(false);
        transition.setInterpolator(interpolator);

        transition.setOnFinished(event -> {
            if (onFinished != null) {
                onFinished.run();
            }
        });

        transition.play();
    }

    /**
     * Animates a vehicle on a second wire over a specified duration, then calls the provided onFinished Runnable.
     *
     * @param vehicleObj The vehicle to be animated.
     * @param vehicle The rendered vehicle to be animated.
     * @param wire The wire on which the vehicle will be animated.
     * @param duration The duration of the vehicle's animation.
     * @param onAnimationFinished The Runnable to be called when the animation is finished.
     */
    private void animateVehicleOnSecondWire(Vehicle vehicleObj, StackPane vehicle, Line wire, Duration duration, Runnable onAnimationFinished) {
        vehicleObj.updateSpeedLabel();
        animateVehicle(vehicle, wire, duration, Interpolator.LINEAR, onAnimationFinished);
    }
}
