package com.code;

import com.models.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

/**
 * The {@code SpeedingController} class controls the behavior and functionality of the application's UI elements.
 * It manages the TableView for displaying ticket records, animation of vehicles, and interaction with simulation buttons.
 */
public class SpeedingController {

    @FXML
    private TableView<TableRecord> ticketsTable;

    @FXML
    private TableColumn<TableRecord, String> idColumn, timeColumn, speedColumn, ticketIssuedColumn;

    @FXML
    private Line lane1Short, lane1Long, lane2Short, lane2Long, lane3Short, lane3Long, lane4Short, lane4Long;

    @FXML
    private AnchorPane root;

    @FXML
    private Label deservedTotalLabel;

    private VehicleAnimator vehicleAnimator;

    private VehicleSampler vehicleSampler;

    /**
     * Initializes the controller's components and sets up the initial state.
     */
    @FXML
    public void initialize() {
        // Initialize the VehicleSampler with a sample size of 10
        this.vehicleSampler = new VehicleSampler(10);

        // Set the cell value factories for the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        speedColumn.setCellValueFactory(new PropertyValueFactory<>("Speed"));
        ticketIssuedColumn.setCellValueFactory(new PropertyValueFactory<>("TicketIssued"));

        // Set the initial text of the deservedTotalLabel to 0
        deservedTotalLabel.setText("0");
    }

    /**
     * Initializes the VehicleAnimator for the controller.
     *
     * @param animator The VehicleAnimator instance to be initialized.
     */
    public void initAnimator(VehicleAnimator animator) {
        this.vehicleAnimator = animator;
    }

    /**
     * Generates a car on the wires based on the provided vehicle object.
     *
     * @param vehicle The vehicle object containing information about the car.
     */
    public void generateCar(Vehicle vehicle) {
        switch (vehicle.getLane()) {
            case 1:
                vehicleAnimator.animateVehicleOnWires(
                        vehicle,
                        lane1Long,
                        lane1Short,                    
                        this.vehicleSampler.translateDuration(vehicle.getSpeed()),
                        this.vehicleSampler.getRecord(vehicle)
                );
                break;
            case 2:
                vehicleAnimator.animateVehicleOnWires(
                        vehicle,
                        lane2Long,
                        lane2Short,                        
                        this.vehicleSampler.translateDuration(vehicle.getSpeed()),
                        this.vehicleSampler.getRecord(vehicle)
                );
                break;
            case 3:
                vehicleAnimator.animateVehicleOnWires(
                        vehicle,
                        lane3Long,
                        lane3Short,                      
                        this.vehicleSampler.translateDuration(vehicle.getSpeed()),
                        this.vehicleSampler.getRecord(vehicle)
                );
                break;
            case 4:
                vehicleAnimator.animateVehicleOnWires(
                        vehicle,
                        lane4Long,
                        lane4Short,                        
                        this.vehicleSampler.translateDuration(vehicle.getSpeed()),
                        this.vehicleSampler.getRecord(vehicle)
                );
                break;
            default:
                break;
        }
    }

    /**
     * Adds a new record to the tickets table.
     *
     * @param record The TableRecord object to be added to the table.
     */
    public void addRecord(TableRecord record) {
        // Adds the provided record to the table's items list.
        ticketsTable.getItems().add(record);
    }

    /**
     * Increment the deserved total by the number of tickets issued.
     * This method updates the text of the deservedTotalLabel to reflect the new total.
     */
    public void incrementDeservedTotal() {
        deservedTotalLabel.setText(String.valueOf(this.vehicleSampler.getTicketsTotal()));
    }
}
