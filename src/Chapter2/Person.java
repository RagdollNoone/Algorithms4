package Chapter2;

public class Person implements
Comparable<Person> {
    public String name;
    public int age;

    public Person() {
        name = "";
        age = -1;
    }

    public int compareTo(Person that) {
        if (this.name.compareTo(that.name) > 0) return 1;
        if (this.name.compareTo(that.name) < 0) return -1;

        if (this.age > that.age) return 1;
        if (this.age < that.age) return -1;

        return 0;
    }
}
