package br.anhembi;

/**
 * Client
 */
public class Client {

    private String name;
    private int age;

    public Client(final String name, final int age) {
        this.name = name;
        this.age = age;
        setAge(age);
    }

    public void setAge(final int age) {
        if (age <= 0) {
            this.age = 18;
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public boolean getElderly(){
        if(this.getAge() >= 60){
            return true;
        }else{
            return false;
        }
    }

    public String toString() {
        return name + ":" + age;
    }
}
