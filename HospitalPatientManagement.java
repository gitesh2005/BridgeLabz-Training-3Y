import java.util.ArrayList;
import java.util.List;

// Interface
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// Abstract class
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis; // sensitive data
    private List<String> medicalHistory = new ArrayList<>();

    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    // Encapsulation: getters & setters
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    // Abstract + Concrete methods
    public abstract double calculateBill();
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    @Override
    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }
}

// InPatient class
class InPatient extends Patient {
    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(int id, String name, int age, String diagnosis, int daysAdmitted, double roomChargePerDay) {
        super(id, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.roomChargePerDay = roomChargePerDay;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * roomChargePerDay + 500; // extra doctor charges
    }
}

// OutPatient class
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int id, String name, int age, String diagnosis, double consultationFee) {
        super(id, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee; // only consultation fee
    }
}

// Main Class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        InPatient p1 = new InPatient(101, "Alice", 30, "Fever", 3, 1000);
        OutPatient p2 = new OutPatient(102, "Bob", 25, "Cough", 500);

        p1.addRecord("Admitted for 3 days");
        p1.addRecord("Prescribed antibiotics");

        p2.addRecord("Visited OPD for cough");
        p2.addRecord("Prescribed syrup");

        Patient[] patients = {p1, p2};

        System.out.println("--- Patient Billing Details ---");
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Diagnosis: " + p.getDiagnosis());
            System.out.println("Medical Records: " + p.viewRecords());
            System.out.println("Total Bill: " + p.calculateBill());
            System.out.println();
        }
    }
}
