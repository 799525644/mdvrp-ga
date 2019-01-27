package MapObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.List;

public class Depot extends MapObject {
    private int maxDistance; // D: maximum duration of a route
    private int maxLoad; // Q: allowed maximum load of a vehicle
    private int maxCars; // m: maximum number of vehicles available in each depot
    private static int depotIndex;
    private Color[] colors = {Color.RED, Color.ORANGE, Color.GOLD, Color.GREEN, Color.BLUE, Color.INDIGO, Color.VIOLET};
    private Color color;
    private List<Customer> customers = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();


    public Depot(int maxDistance, int maxLoad, int maxCars) {
        super(0, 0);
        this.maxDistance = maxDistance;
        this.maxLoad = maxLoad;
        this.maxCars = maxCars;
        this.color = colors[depotIndex];

        if (depotIndex == colors.length - 1) {
            depotIndex = 0;
        } else {
            depotIndex++;
        }
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(getPixelX() - 5, getPixelY() - 5, 10, 10);
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(int maxLoad) {
        this.maxLoad = maxLoad;
    }

    public int getMaxCars() {
        return maxCars;
    }

    public void setMaxCars(int maxCars) {
        this.maxCars = maxCars;
    }

    public Paint getColor() {
        return color;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }


    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
