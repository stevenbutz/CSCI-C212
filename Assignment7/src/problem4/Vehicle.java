package problem4;

public class Vehicle {
    private int gear;
    private int speed;

    public Vehicle(int gear, int speed) throws IllegalArgumentException{
        if (gear<0){
            this.gear = 0;
        }
        else{
            this.gear = gear;
        }
        if (speed < 0){
            this.speed = 0;}
        else{
            this.speed = speed;
        }

    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) throws IllegalArgumentException{
        if (gear<0){
            this.gear = 0;
//            throw new IllegalArgumentException("Vehicle gear is 0 or more");
        }
        else{
            this.gear = gear;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) throws IllegalArgumentException{
        if (speed < 0) {
            this.speed = 0;
//            throw new IllegalArgumentException("Speed between -60 and 764 unless attempting world record");
        }
        else{
            this.speed = speed;
        }
    }

    public void accelerate(int increment) throws IllegalArgumentException{

        this.speed += increment;

    }

    public void brake(int decrement) throws IllegalArgumentException{
        if(this.speed-decrement<0){
            this.speed = 0;
        }
        else{
            this.speed -= decrement;
        }


    }

    @Override
    public String toString() {
        return "Vehicle [gear=" + gear + ", speed=" + speed + "]";
    }
}
