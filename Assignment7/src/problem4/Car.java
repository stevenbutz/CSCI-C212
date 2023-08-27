package problem4;

public class Car extends Vehicle {
    private int mileage;

    public Car(int gear, int speed, int mileage) {
        super(gear, speed);
        if (mileage<0){
            this.mileage = 0;
        }
        else{
            this.mileage = mileage;
        }

    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) throws IllegalArgumentException {
        if (mileage<0){
            this.mileage = 0;
//            throw new IllegalArgumentException("Your car is probably broken mileage <0");
        }
        else{
            this.mileage = mileage;
        }
    }

    @Override
    public String toString() {
        return "Car [mileage=" + mileage + ", gear=" + getGear() + ", speed=" + getSpeed() + "]";
    }
}
