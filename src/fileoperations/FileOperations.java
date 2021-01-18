package fileoperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class FileOperations {



    public static void main(String[] args ) throws Exception{
        Scanner scanner = new Scanner( System.in );
        File newFile = new File("test.txt");
        if( newFile.exists() ){
            System.out.println("File Already Exists! Do you want to overwrite(YES/NO)? ");
            String overWriteFile = scanner.nextLine();
            if(overWriteFile.toUpperCase().equals("YES")) {
                writeFile(newFile);
            }else {
                System.out.println("Do you want to append to the existing file(YES/NO)? " );
                String isAppend = scanner.nextLine();
                if(isAppend.toUpperCase().equals( "YES" )){
                    appendFile( newFile );
                }
            }
            System.out.println("Exit the program!!");
            System.exit(0);

        }
        writeFile(newFile);

        System.out.println(newFile.getAbsoluteFile() + "\tcreated successfully");

    }

    private static void writeFile(File newFile) throws FileNotFoundException {
        System.out.println("Creating a new File!!!!");
        PrintWriter writer = new PrintWriter(newFile);
        writer.print("S B");
        writer.print("\nY A");
        writer.close();
    }
    private static void appendFile(File newFile) throws Exception{
        System.out.println("Appending to the file!!!!");
        Path path = Paths.get(newFile.getAbsolutePath());
        Files.write( path, "\nR Y A".getBytes(), StandardOpenOption.APPEND );
    }
}
