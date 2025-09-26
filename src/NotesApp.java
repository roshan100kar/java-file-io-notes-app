import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("##### Notes App #####");
            System.out.println("1 Add Note");
            System.out.println("2 View Notes");
            System.out.println("3 Exit");
            System.out.println("Choose option:-");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addNote(sc);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    System.out.println("Good Bye");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice Try again");

            }
        }
    }

    private static void addNote(Scanner sc) {
        System.out.println("Enter your note ");
        String note = sc.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("Note saved");
        }catch(IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }
    private static void viewNotes() {
        File file = new File(FILE_NAME);
        if(!file.exists()) {
            System.out.println("No notes yet");
            return;
        }
        System.out.println("##### Your notes #####");
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 1;
            while((line = reader.readLine()) != null)  {
                System.out.println(count++ + ". " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + e.getMessage());
        }
    }
}
