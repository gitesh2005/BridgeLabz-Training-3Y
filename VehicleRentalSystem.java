// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Getters and Setters (Encapsulation)
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }
}

// Interface for Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car subclass
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days; // simple daily rate
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate as insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: " + calculateInsurance();
    }
}

// Bike subclass
class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // slightly discounted
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.02; // 2% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: " + calculateInsurance();
    }
}

// Truck subclass
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // extra fixed charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: " + calculateInsurance();
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Car("CAR123", 2000);
        Vehicle v2 = new Bike("BIKE456", 500);
        Vehicle v3 = new Truck("TRUCK789", 3000);

        Vehicle[] vehicles = { v1, v2, v3 };

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Type: " + v.getType());
            System.out.println("Rental Cost (5 days): " + v.calculateRentalCost(5));
            
            if (v instanceof Insurable) {
                System.out.println(((Insurable) v).getInsuranceDetails());
            }
            System.out.println("---------------------------");
        }
    }
}
