package za.ac.cput.domain;

public class User {

    private String userId;

    private String name;

    private String address;

    private String contactNumber;

    private User() {

    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "user{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    public static class Builder {
        private String userId;

        private String name;

        private String address;

        private String contactNumber;


        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.userId;
            this.name = user.name;
            this.address = user.address;
            this.contactNumber = user.contactNumber;
            return this;
        }

        public User build() {return new User(this);
        }
    }
}
