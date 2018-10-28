package javapractise;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

public Person(String firstName, String lastName, int age){
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
}
    public String getFirstName() {
        return firstName;
    }
public void setFirstName(String firstName){

    this.firstName=firstName;
}
public String getLastName(){
    return lastName;
}

public void setLastName(String lastName){
    this.lastName = lastName;

}
public void setAge(int age){
    this.age=age;
        }
        public int getAge(){
    return age;
        }

        @Override
public String toString(){
    return "Person[First Name :" +firstName+ "Last Name :" +lastName+ "Age :"+age+"]";
}
}
