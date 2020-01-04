import java.util.Objects;

public class Bill {
    int id;
    String name;
    long money;
    String date;

    public Bill(int id, String name, long money, String date) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.date = date;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bill) {
            Bill newBill = (Bill) obj;
            if (((Bill) obj).id == newBill.id && ((Bill) obj).name.equals(newBill.name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
