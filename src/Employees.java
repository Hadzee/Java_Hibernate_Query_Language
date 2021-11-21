import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "employees")
public class Employees implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "income")
    private double income;

    public Employees() {
    }

    public Employees(int id, String name, int age, String address, double income) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.income = income;
    }
    public Employees (int id){
        this.id = id;
    }

    public Employees(int id, int age, String address, double income){
        this.id = id;
        this.age = age;
        this.address = address;
        this.income = income;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getIncome() { return income; }
    public void setIncome(float income) { this.income = income; }

    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getAge() + "\t" + getAddress() + "\t" + getIncome();
    }
}
