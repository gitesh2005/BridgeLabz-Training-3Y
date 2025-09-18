// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract class
abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Encapsulation
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public void setRatePerKm(double ratePerKm) { this.ratePerKm = ratePerKm; }

    // Abstract + concrete methods
    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm);
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

// Car class
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // extra base charge
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // no base charge
    }
}

// Auto class
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // minimal base charge
    }
}

// Main class
public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle v1 = new Car("C101", "Amit", 15.0, "Downtown");
        Vehicle v2 = new Bike("B202", "Ravi", 8.0, "City Center");
        Vehicle v3 = new Auto("A303", "Sunil", 10.0, "Market Area");

        Vehicle[] vehicles = {v1, v2, v3};

        System.out.println("--- Ride Fare Calculation ---");
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Current Location: " + v.getCurrentLocation());
            System.out.println("Fare for 10 km: " + v.calculateFare(10));
            System.out.println();
        }

        // Updating location demo
        v1.updateLocation("Airport");
        System.out.println(v1.getDriverName() + " updated location to: " + v1.getCurrentLocation());
    }
}
