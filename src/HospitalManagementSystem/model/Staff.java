package HospitalManagementSystem.model;

public abstract class Staff {
    protected static int id;
    protected String fullName;
    protected int age;
    protected String phone;

    public Staff(int id, String fullName, int age, String phone) {
        setId(id);
        setFullName(fullName);
        setAge(age);
        setPhone(phone);
    }

    public abstract void work();

    public abstract String getRole();

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be positive");
        this.id = id;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.fullName = fullName;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.trim().isEmpty())
            throw new IllegalArgumentException("Phone cannot be empty");
        this.phone = phone;
    }
    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }


    @Override
    public  String toString() {
        return "ID: " + id +
                "\nName: " + fullName +
                "\nAge: " + age +
                "\nPhone: " + phone;
    }


}
