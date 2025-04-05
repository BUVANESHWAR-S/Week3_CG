package Day2.OOP_Concepts.pb3;

import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNumber;

    Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 200.0;
    }

    public String getInsuranceDetails() {
        return "Car Insurance: Policy #" + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        if (policyNumber.length() <= 4) return "****";
        return "****" + policyNumber.substring(policyNumber.length() - 4);
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9;
    }

    public double calculateInsurance() {
        return 100.0;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance: Policy #" + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        if (policyNumber.length() <= 4) return "****";
        return "****" + policyNumber.substring(policyNumber.length() - 4);
    }
}

class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    double calculateRentalCost(int days) {
        return getRentalRate() * days + 50;
    }

    public double calculateInsurance() {
        return 300.0;
    }

    public String getInsuranceDetails() {
        return "Truck Insurance: Policy #" + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        if (policyNumber.length() <= 4) return "****";
        return "****" + policyNumber.substring(policyNumber.length() - 4);
    }
}

public class pb3 {
    public static void main(String[] args) {
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Car("CAR123", 50, "C12345678"));
        fleet.add(new Bike("BIK456", 20, "B87654321"));
        fleet.add(new Truck("TRK789", 80, "T11223344"));

        for (Vehicle v : fleet) {
            System.out.println("Vehicle: " + v.getType() + " (" + v.getVehicleNumber() + ")");
            System.out.println("Rental Cost for 3 days: " + v.calculateRentalCost(3));
            if (v instanceof Insurable) {
                Insurable insurable = (Insurable) v;
                System.out.println("Insurance Cost: " + insurable.calculateInsurance());
                System.out.println(insurable.getInsuranceDetails());
            }
            System.out.println();
        }
    }
}
