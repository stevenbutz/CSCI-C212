import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

    public String processShape(Scanner scanner) {
        String shapeType = scanner.next();
        int param1 = scanner.nextInt();
        int param2;
        if (scanner.hasNextInt()) {
            param2 = scanner.nextInt();
        } else {
            param2 = -1;
        }

        String output;
        if (shapeType.equalsIgnoreCase("Triangle")) {
            Triangle triangle = new Triangle(param1);
            output = triangle.printShape();
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            Rectangle rectangle = new Rectangle(param1, param2);
            output = rectangle.printShape();
        } else if (shapeType.equalsIgnoreCase("Rhombus")) {
            Rhombus rhombus = new Rhombus(param1);
            output = rhombus.printShape();
        } else {
            throw new IllegalArgumentException("Invalid shape type");
        }

        return output;
    }

    public void processFile(File inputFile) {
        StringBuilder outputBuilder = new StringBuilder();
        boolean errorOccurred = false;

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNext()) {
                try {
                    String shapeOutput = processShape(scanner);
                    outputBuilder.append(shapeOutput).append(System.lineSeparator());
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid input in file " + inputFile.getName() + ": " + e.getMessage());
                    errorOccurred = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + inputFile.getName());
            errorOccurred = true;
        }

        if (!errorOccurred) {
            String outputFilename = "OutputFiles/" + inputFile.getName().replace(".in", ".out");
            try (PrintWriter writer = new PrintWriter(outputFilename)) {
                writer.print(outputBuilder.toString());
            } catch (FileNotFoundException e) {
                System.err.println("Unable to write to output file: " + outputFilename);
            }
        }
    }

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        File inputFolder = new File("InputFiles");

        for (File inputFile : inputFolder.listFiles()) {
            if (inputFile.isFile() && inputFile.getName().endsWith(".in")) {
                fileHandler.processFile(inputFile);
            }
        }
    }
}
