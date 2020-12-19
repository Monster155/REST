import java.util.Objects;

public class User {
    private String name;
    private int age;
    private boolean isVip;

    public User(String name, int age, boolean isVip) {
        this.name = name;
        this.age = age;
        this.isVip = isVip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age
                && isVip == user.isVip
                && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, isVip);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isVip=" + isVip +
                '}';
    }
}
