package system.model;




import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "component")
public class Component implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "necessity")
    private boolean necessity;

    @Column(name = "amount")
    private int amount;

    public Component() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNecessity() {
        return necessity;
    }

    public void setNecessity(boolean necessity) {
        this.necessity = necessity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
