import java.io.File;
import java.io.IOException;
import java.util.*;
//comment for test

public class Main {
    public static void main(String[] args) throws IOException {
        //get data from user
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter address of directory, where files will be sorted: ");
        String mainPath = scan.next();
        System.out.println("How many file expansions will be used? :");
        int countOfExpansions = scan.nextInt();
        Map<Integer, String> expansions = new HashMap<>();
        Map<Integer, String> folders = new HashMap<>();
        for(int i = 1; i <= countOfExpansions; i++) {
            System.out.println("Enter an expansion of file: ");
            expansions.put(i, scan.next());
            System.out.println("Enter a name of folder (not address), where file will be located after sorting: ");
            folders.put(i, scan.next());
        }
        //sorting files
        File dir = new File(mainPath);
        File tempDir;
        File[] files = dir.listFiles();
        int index;
        String expansion;
        for(int i = 0; i < files.length; i++) {
            index = files[i].getName().indexOf('.');
            expansion = files[i].getName().substring(index + 1);
            for(Integer j = 1; j <= countOfExpansions; j++) {
                if(expansion.equals(expansions.get(j))) {
                    tempDir = new File(mainPath + "\\" + folders.get(j), files[i].getName());
                    tempDir.createNewFile();
                    files[i].delete();
                    break;
                }
            }
        }
        System.out.println("All files were successfully sorted");
    }
}
