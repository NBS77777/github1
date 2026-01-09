package week4;

public class Person {
    protected int id ;
    protected String fullName;
    protected int age ;
    protected String phone ;

    public Person(int id , String fullName , int age , String phone){
        this.id = id;
        this.fullName=fullName;
        this.age=age;
        this.phone=phone;
    }

    public void work(){
        System.out.println(fullName + " is in the hospital.");
    }

    public String getRole(){
        return "Person" ;
    }

    public boolean isAdult(){
        return age >=18;
    }

    @Override
    public String toString() {
        return "[" + getRole() +"]" + fullName +
                "{" + "\nID:" + id +
                "\nAGE:" + age +
                "\nPHONE:" + phone + "}";
    }
}

