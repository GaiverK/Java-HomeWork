package ObjectsEquals;

import java.util.Objects;

public class Human implements Cloneable {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if(!(o instanceof Human)){
            return false;
        }

        Human human = (Human) o;
        return Objects.equals(name, human.name) &&
                Objects.equals(age, human.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
