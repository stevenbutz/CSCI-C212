package problem3;

public class Instructor implements Performance{
    private String name;
    private String rating;

    public Instructor(String name, String rating){
        if (name == null) {
            this.name = "";
        }
        else{
            this.name = name;
        }
        if (rating ==null){
            this.rating = "";
        }
        else{
            this.rating = rating;
        }

    }

    public String getName() {
        return name;
    }
    public void setName(String name) throws IllegalArgumentException{
        if (name == null) {
            this.name = "";
//            throw new IllegalArgumentException("Invalid input: Name cannot be null");
        }
        else{
            this.name = name;
    }}

    public String getRating() {
        return rating;
    }

    public void setRating(String rating)throws IllegalArgumentException {
        String inputRating = rating; // Replace this with the user's input

        String[] validRatings = {"Excellent","Good","Average","Bad","Worst"};
        if(rating ==null){
            this.rating="";
        }
        else{
        boolean isValid = false;
        for (String ratings : validRatings) {
            if (inputRating.toUpperCase().equals(ratings.toUpperCase())) {
                isValid = true;
                break;
            }
        }
        if (isValid) {
            this.rating = rating;
        } else {
            this.rating = "";
//            throw new IllegalArgumentException("Rating is not valid");
        }
    }}

    @Override
    public double getPerformance() {
        return switch (rating) {
            case "Excellent" -> 5.0;
            case "Good" -> 4.0;
            case "Average" -> 3.0;
            case "Bad" -> 2.0;
            case "Worst" -> 1.0;
            default -> 0.0;
        };
    }
}
