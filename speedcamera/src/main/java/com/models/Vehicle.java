package com.models;

import java.util.concurrent.atomic.AtomicInteger;
import javafx.scene.paint.Color;

/**
 * The {@code Vehicle} class represents a vehicle with various attributes such as color, id, speed, and lane.
 * This class implements the {@code Animateable} interface and provides methods to manipulate and retrieve
 * vehicle properties.
 * <p>
 * It also keeps track of unique identifiers for each vehicle using an {@code AtomicInteger}.
 * </p>
 */
public abstract class Vehicle implements Animateable {
    private Color color;
    private int id;
    private int speed;
    private int time;
    private int lane;
    private int width;
    private int height;
    private static final AtomicInteger idCounter = new AtomicInteger();

    /**
     * Constructs a new {@code Vehicle} with the specified lane, color, speed before, and current speed.
     *
     * @param lane the lane in which the vehicle is driving
     * @param color the color of the vehicle
     * @param speedBefore the speed of the vehicle before the current speed
     * @param speed the current speed of the vehicle
     */
    @SuppressWarnings("exports")
    public Vehicle(int lane, Color color, int speed,  int time) {
        this.color = color;
        this.lane = lane;
        this.speed = speed;
        this.time = time;
        this.id = idCounter.incrementAndGet();
    }

    /**
     * Gets the color of the vehicle.
     *
     * @return the color of the vehicle
     */
    @SuppressWarnings("exports")
    public Color getColor() {
        return color;
    }

    /**
     * Gets the unique identifier of the vehicle.
     *
     * @return the id of the vehicle
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the speed of the vehicle before the current speed.
     *
     * @return the speed before the current speed
     */
    public int getTime() {
        return time;
    }

    /**
     * Gets the current speed of the vehicle.
     *
     * @return the current speed
     */
    public int getSpeed() {
        return speed;
    }

    
 
    /**
     * Gets the lane in which the vehicle is driving.
     *
     * @return the lane of the vehicle
     */
    public int getLane() {
        return lane;
    }

    /**
     * Gets the width of the vehicle.
     *
     * @return the width of the vehicle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of the vehicle.
     *
     * @return the height of the vehicle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the color of the vehicle.
     *
     * @param color the new color of the vehicle
     */
    @SuppressWarnings("exports")
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Sets the unique identifier of the vehicle.
     * This method is generally not used since IDs are auto-incremented.
     *
     * @param id the new id of the vehicle
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the speed of the vehicle before the current speed.
     *
     * @param speedBefore the new speed before the current speed
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Sets the current speed of the vehicle.
     *
     * @param speed the new current speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

 
    /**
     * Sets the lane in which the vehicle is driving.
     *
     * @param lane the new lane of the vehicle
     */
    public void setLane(int lane) {
        this.lane = lane;
    }

    /**
     * Sets the width of the vehicle.
     *
     * @param width the new width of the vehicle
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the height of the vehicle.
     *
     * @param height the new height of the vehicle
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns a string representation of the vehicle, including its lane, speed before, and current speed.
     *
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return getLane() + "-" + getTime() + "-" + getSpeed();
    }
}
