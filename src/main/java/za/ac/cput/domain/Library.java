package za.ac.cput.domain;

public class Library {
    private String name;
    private String location;

    private Library() {}

    private Library(Builder builder) {
        this.name = builder.name;
        this.location = builder.location;
    }


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String location;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }


        public Library build() {
            return new Library(this);
        }

    }
}
