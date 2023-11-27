package by.teachmeskills.lesson30.Builder;

final class Flat {
    private int number;
    private int numberOfRooms;
    private String floor;
    public Flat setNumber(int number) {
        this.number = number;
        return this;
    }
    public Flat setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
        return this;
    }
    public Flat setFloor(String floor) {
        this.floor = floor;
        return this;
    }
    @Override
    public String toString() {
        return "number = " + this.number + ", number of rooms = " + this.numberOfRooms + ", floor = " + this.floor;
    }
}