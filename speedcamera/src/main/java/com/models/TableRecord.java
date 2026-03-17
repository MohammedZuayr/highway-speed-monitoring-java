package com.models;

/**
 * The {@code TableRecord} class represents a record in a table, typically used to store
 * information about vehicles such as their ID, speeds, and ticket issuance status.
 */
public class TableRecord {
    private String id;
    private String time;
    private String speed;
    private String ticketIssued;

    /**
     * Constructs a new {@code TableRecord} with the specified ID, speed before, current speed,
     * and ticket issuance status.
     *
     * @param id the unique identifier for the record
     * @param speedBefore the speed of the vehicle before the current speed
     * @param speed the current speed of the vehicle
     * @param ticketIssued the ticket issuance status for the vehicle
     */
    public TableRecord(String id, String time, String speed, String ticketIssued) {
        this.id = id;
        this.time = time;
        this.speed = speed;
        this.ticketIssued = ticketIssued;
    }

    /**
     * Gets the unique identifier for the record.
     *
     * @return the ID of the record
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the record.
     *
     * @param id the new ID of the record
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the speed of the vehicle before the current speed.
     *
     * @return the speed before the current speed
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the speed of the vehicle before the current speed.
     *
     * @param speedBefore the new speed before the current speed
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Gets the current speed of the vehicle.
     *
     * @return the current speed
     */
    public String getSpeed() {
        return speed;
    }

    /**
     * Sets the current speed of the vehicle.
     *
     * @param speed the new current speed
     */
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    /**
     * Gets the ticket issuance status for the vehicle.
     *
     * @return the ticket issuance status
     */
    public String getTicketIssued() {
        return ticketIssued;
    }

    /**
     * Sets the ticket issuance status for the vehicle.
     *
     * @param ticketIssued the new ticket issuance status
     */
    public void setTicketIssued(String ticketIssued) {
        this.ticketIssued = ticketIssued;
    }
}
