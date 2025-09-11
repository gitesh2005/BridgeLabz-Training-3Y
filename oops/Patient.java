public class Patient {
    // Static variables shared among all patients
    private static String hospitalName;
    private static int totalPatients = 0;

    // Instance variables
    private final String patientID; // Final so it can't be changed
    private String name;
    private int age;
    private String ailment;

    // Constructor using 'this' keyword
    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;  // Increase count when new patient is created
    }

    // Static method to set hospital name
    public static void setHospitalName(String name) {
        hospitalName = name;
    }

    // Static method to get total number of patients
    public static int getTotalPatients() {
        return totalPatients;
    }

    // Method to display patient details
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("The object is not an instance of the Patient class.");
        }
    }

    // Getters (optional)
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAilment() { return ailment; }
    public String getPatientID() { return patientID; }

    // Main method to test the class
    public static void main(String[] args) {
        // Set hospital name
        Patient.setHospitalName("City Hospital");

        // Create new patients
        Patient patient1 = new Patient("Lathika", 30, "Flu", "P001");
        Patient patient2 = new Patient("Lidiya", 45, "Fracture", "P002");

        // Display total patients
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());

        // Display details
        patient1.displayPatientDetails();
        System.out.println();
        patient2.displayPatientDetails();
    }
}
