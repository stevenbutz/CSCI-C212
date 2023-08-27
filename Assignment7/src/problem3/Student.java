package problem3;

public class Student implements Performance {
    private final String name;
    private String grade;
    public Student(String name, String grade) {
        if (name == null) {
            this.name = "";

        }
        else{
            this.name = name;
        }
        if (grade == null){
            this.grade = "";}
        else{
            this.grade = grade;
        }
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) throws IllegalArgumentException{
        String inputGrade = grade; // Replace this with the user's input

        String[] validGrades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "E", "F"};
        if (grade == null){
            this.grade = "";
        }
        else{
        boolean isValid = false;
        for (String grades : validGrades) {
            if (inputGrade.toUpperCase().equals(grades.toUpperCase())) {
                isValid = true;
                break;
            }
        }
        if (isValid) {
            this.grade = grade;
        } else {
            this.grade = "";
//            throw new IllegalArgumentException("Grade is not valid");
        }
    }}
    @Override
    public double getPerformance() {
        return switch (grade) {
            case "A+", "A" -> 4.0;
            case "A-" -> 3.7;
            case "B+" -> 3.3;
            case "B" -> 3.0;
            case "B-" -> 2.7;
            case "C+" -> 2.3;
            case "C" -> 2.0;
            case "C-" -> 1.7;
            case "D+" -> 1.3;
            case "D" -> 1.0;
            default -> 0.0;
        };
    }
}
