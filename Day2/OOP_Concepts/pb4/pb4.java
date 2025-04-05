package Day2.OOP_Concepts.pb4;

import java.util.ArrayList;
import java.util.List;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Location: " + currentLocation;
    }

    abstract double calculateFare(double distance);
}

class Car extends Vehicle {
    Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Bike extends Vehicle {
    Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9;
    }
}

class Auto extends Vehicle {
    Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    double calculateFare(double distance) {
        return distance * getRatePerKm() + 10;
    }
}

class RideService {
    void printFare(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Fare for " + distance + " km: " + vehicle.calculateFare(distance));
        System.out.println("Current Location: " + vehicle.getCurrentLocation());
        System.out.println();
    }
}

public class pb4 {
    public static void main(String[] args) {
        Vehicle car = new Car("CAR101", "Alice", 15, "Downtown");
        Vehicle bike = new Bike("BIK202", "Bob", 8, "City Mall");
        Vehicle auto = new Auto("AUT303", "Charlie", 10, "Train Station");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        RideService service = new RideService();
        for (Vehicle v : vehicles) {
            service.printFare(v, 12.5);
        }
    }
}

