package tms_maven;

public class User_Builder {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String email;
    private final String phone;

    private User_Builder(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private int age;
        private String email;
        private String phone;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public User_Builder build() {
            return new User_Builder(this);
        }
    }

    @Override
    public String toString() {
        return String.format("User{firstName = %s, lastName = %s, age = %d, email = %s, phone = %s}",
                firstName, lastName, age, email, phone);
    }
}
