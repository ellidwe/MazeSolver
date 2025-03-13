import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }

    public static void main(String[] args)
    {
        GuyInMaze guy = new GuyInMaze(getMaze("src/maze"));
        int retraceCounter = 0;

        while (!guy.getPos().equals("(" + (guy.getMaze()[0].length - 1) + "," + (guy.getMaze().length - 1) + ")"))
        {
            System.out.print(guy.getPos());
            System.out.print("--->");
            if(guy.checkDown())
            {
                guy.goToDown();
                retraceCounter = 0;
            }
            else if (guy.checkRight())
            {
                guy.goToRight();
                retraceCounter = 0;
            }
            else if(guy.checkLeft())
            {
                guy.goToLeft();
                retraceCounter = 0;
            }
            else if(guy.checkUp())
            {
                guy.goToUp();
                retraceCounter = 0;
            }
            else
            {
                guy.returnToVisited(retraceCounter);
                retraceCounter++;
            }
        }
        System.out.println(guy.getPos());
    }
}