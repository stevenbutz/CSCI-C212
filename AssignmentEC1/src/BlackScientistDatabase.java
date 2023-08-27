import java.util.Scanner;

public class BlackScientistDatabase {
    public static void main(String[] args) {
        String[][] scientists = new String[5][4];
        Scanner sc = new Scanner(System.in);

        // First scientist
        scientists[0][0] = "Katherine Johnson";
        scientists[0][1] = "1918";
        scientists[0][2] = "Mathematics, Aerospace engineering";
        scientists[0][3] = "Katherine Johnson did trajectory analysis for Alan Shepard’s Freedom 7 mission in 1961 which was America’s first human space flight. This was at a time when computers were not well tested and used so Katherine checked all of the computers math. Her help with calculations also helped to land Apollo 11 on the moon in 1969.";

        // Second scientist
        scientists[1][0] = "George Washington Carver";
        scientists[1][1] = "1864";
        scientists[1][2] = "Agriculture, Chemistry, Biology";
        scientists[1][3] = "George Washington Carver discovered more than 300 uses for peanuts and hundreds more uses for soybeans, pecans and sweet potatoes. He is best known for crop rotation and he developed many other products from peanuts such as soap, paper, cosmetics and cooking oils. ";

        // Third scientist
        scientists[2][0] = "Mae Jemison";
        scientists[2][1] = "1956";
        scientists[2][2] = "Astronautics, Environmental studies, Medicine";
        scientists[2][3] = "Mae Jemison became the first African American woman to go into space at 36 years old. And during space flight she conducted experiments in life sciences, material sciences and was co-investigator in bone cell research development. ";

        // Fourth scientist
        scientists[3][0] = "Neil deGrasse Tyson";
        scientists[3][1] = "1958";
        scientists[3][2] = "Astrophysics, Science communication, Science advocacy";
        scientists[3][3] = "Neil deGrasse Tyson research star formation, exploding stars, dwarf galaxies and the structure of the Milky Way. He has played an important role in popularizing astrophysical concepts and discoveries. He also contributed information to establish Pluto as a dwarf planet. ";

        // Fifth scientist
        scientists[4][0] = "Chanda Prescod-Weinstein";
        scientists[4][1] = "1980";
        scientists[4][2] = "Theoretical physics, Cosmology, Particle physics";
        scientists[4][3] = "Chanda Prescod-Weinstein research focused on various topics in cosmology and theoretical physics. Such examples include the axion as a dark matter candidate, inflation and classical and quantum fields in the early universe. ";


        System.out.println("Welcome to the database of Black scientists!" +
                " Please enter text for the following filter criteria, or press Enter to skip filtering by that criteria.");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Birth Year: ");
        String year = sc.nextLine();
        System.out.print("Research Field: ");
        String field = sc.nextLine();
        System.out.println("RESULTS");
        findScientist(scientists, name, year, field);
    }

    public static String[][] findScientist(String[][] scientists, String name, String byear, String field) {
        String[][] matches = new String[1][4];
        for (int i = 0; i < scientists.length; i++) {
            if ((name.isEmpty() || scientists[i][0].toLowerCase().contains(name.toLowerCase()))
                    && (byear.isEmpty() || Integer.parseInt(scientists[i][1]) > Integer.parseInt(byear))
                    && (field.isEmpty() || scientists[i][2].toLowerCase().contains(field.toLowerCase()))) {
                System.out.println(scientists[i][0] + ", (" + scientists[i][1] + "):\n" + "---- Field(s) of research: " + scientists[i][2] + "\n---- Contributions: " + scientists[i][3]);

            }
        }
        return matches;
    }
}
