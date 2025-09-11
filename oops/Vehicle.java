public class Vehicle {
    // Static variable shared by all vehicles
    private static double registrationFee = 100.0; // Default registration fee

    // Instance variables
    private final String registrationNumber; // Final variable so it can't be changed
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this' keyword
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        if (newFee >= 0.0) {
            registrationFee = newFee;
        } else {
            System.out.println("Invalid registration fee. Please enter a non-negative value.");
        }
    }

    // Method to display vehicle registration details
    public void displayRegistrationDetails() {
        // Use 'instanceof' to check object type
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("The object is not an instance of the Vehicle class.");
        }
    }

    // Getters (optional)
    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Update the registration fee
        Vehicle.updateRegistrationFee(150.0);

        // Create vehicle objects
        Vehicle vehicle1 = new Vehicle("Honest Raj", "Sedan", "ABC123");
        Vehicle vehicle2 = new Vehicle("Price Danish", "SUV", "XYZ789");

        // Display details
        vehicle1.displayRegistrationDetails();
        System.out.println();
        vehicle2.displayRegistrationDetails();
    }
}
