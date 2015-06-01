package Week0;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Desislava
 */
public class DuplicatingFiles {
// function that compare the content of two files
    public static boolean filesCompare(String firstFile, String secondFile) throws FileNotFoundException, IOException {
        File f1 = new File(firstFile);
        File f2 = new File(secondFile);
        boolean flag = true;

        FileReader first = new FileReader(f1);
        FileReader second = new FileReader(f2);

        BufferedReader reader1 = new BufferedReader(first);
        BufferedReader reader2 = new BufferedReader(second);

        String line1 = null;
        String line2 = null;

        while ((flag == true) && ((line1 = reader1.readLine()) != null) && ((line2 = reader2.readLine()) != null)) {
            if (line1.equalsIgnoreCase(line2)) {
                flag = true;
            } else {
                flag = false;
            }

        }
        reader1.close();
        reader2.close();

        return flag;
    }
// function that give us all files in a given directory and exclude the similar
    private static void listDuplicatingFiles(String dir) {

        LinkedList<File> visitedDirs = new LinkedList<>();
        ArrayList<File> allFiles = new ArrayList<>();
        try {
            visitedDirs.add(new File(dir));
            int i = 0;
            if(visitedDirs.get(i).isDirectory()){
            while (visitedDirs.size() > 0) {
                File currentDir = visitedDirs.remove();
                if (currentDir.isFile()) {
                    allFiles.add(currentDir);

                }

                File[] children = currentDir.listFiles();
                if (children != null) {
                    for (File child : children) {
                        if (child.isDirectory() || child.isFile()) {
                            visitedDirs.add(child);
                        }
                    }
                }

            }
            }else {System.out.println("This directory doesn't exist!!!");}
            for (int k = 0; k < allFiles.size(); k++) {
                for (int t = k + 1; t < allFiles.size(); t++) {
                    if (filesCompare(allFiles.get(k).getAbsolutePath(), allFiles.get(t).getAbsolutePath())) {
                        allFiles.remove(t);
                    }
                }
            }
            for (int z = 0; z < allFiles.size(); z++) {
                System.out.println(allFiles.get(z).getName());
            }
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }

    public static void main(String[] args) {
        String dir;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a directory: ");
        dir = in.nextLine();

        listDuplicatingFiles(dir);
    }
}
