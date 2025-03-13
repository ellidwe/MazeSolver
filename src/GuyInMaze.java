import java.util.ArrayList;

public class GuyInMaze {

    private int y;
    private int x;
    private ArrayList<String> visited = new ArrayList<>();
    private String[][] maze;

    public GuyInMaze(String[][] maze)
    {
        y = 0;
        x = 0;
        visited.add(getPos());
        this.maze = maze;
    }

    public String getPos()
    {
        return "(" + x + "," + y + ")";
    }

    public ArrayList<String> getVisited()
    {
        return visited;
    }

    public String[][] getMaze()
    {
        return maze;
    }

    public boolean unvisited(int x, int y)
    {
        return (!visited.contains("(" + x + "," + y + ")"));
    }

    public boolean checkDown()
    {
        if (!(y + 1 > maze.length - 1))
        {
            return (unvisited(x, y + 1)) && maze[y + 1][x].equals(".");
        }
        else
        {
            return false;
        }
    }

    public boolean checkRight()
    {
        if (!(x + 1 > maze[0].length - 1))
        {
            return (unvisited(x + 1, y)) && maze[y][x + 1].equals(".");
        }
        else
        {
            return false;
        }
    }

    public boolean checkLeft()
    {
        if(!(x - 1 < 0))
        {
            return (unvisited(x - 1, y)) && maze[y][x - 1].equals(".");
        }
        else
        {
            return false;
        }
    }

    public boolean checkUp()
    {
        if(!(y - 1 < 0))
        {
            return (unvisited(x, y - 1)) && maze[y - 1][x].equals(".");
        }
        else
        {
            return false;
        }
    }

    public void goToDown()
    {
        y += 1;
        visited.add(getPos());
    }

    public void goToRight()
    {
        x += 1;
        visited.add(getPos());
    }

    public void goToLeft()
    {
        x -= 1;
        visited.add(getPos());
    }

    public void goToUp()
    {
        y -= 1;
        visited.add(getPos());
    }

    public void returnToVisited(int retraceCounter)
    {
        x = Integer.parseInt(visited.get((visited.size() - 2 - retraceCounter)).substring(1, visited.get(visited.size() - 2 - retraceCounter).indexOf(",")));
        y = Integer.parseInt(visited.get((visited.size() - 2 - retraceCounter)).substring(visited.get(visited.size() - 2 - retraceCounter).indexOf(",") + 1, visited.get(visited.size() - 2 - retraceCounter).indexOf(")")));
    }
}
