import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

    /* Helper method to compare two mazes */
    public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
        Square s = MazeSolver.solve(startMaze, wl);
        if(expected == null) { assertNull(s); }
        else {
            ArrayList<Square> sp = startMaze.storePath();
            String actualStr = formatMaze(startMaze.showSolution(sp));
            String expectedStr = formatMaze(expected);
            assertEquals(expectedStr, actualStr);
        }
    }	

    /* Helper method to format String[] output as String */
    public String formatMaze(String[] arr) {
        String result = "";
        for (String s: arr)
            result += "\n"+s;
        return (result+"\n");
    }

    /* Add your own Worklist tests below */

    /* ************** HINT ******************** 
     * Use the helper methods to create simple
     * tests that are easier to debug. 
     */
    /* TODO: WRITE THREE FOR EACH CATEGORY */

    // maze tests
    @Test
    public void checkMazes(){
        String[] myMaze = {
            "__##",
            "___S",
            "__#_",
            "F_#_"
        };
        Maze mazeMaze = new Maze(myMaze);
        System.out.println(formatMaze(myMaze));
    }
    @Test
    public void mazeTestGiven(){
        System.out.println("Start of mazeTestGiven");
        QueueWorklist wl = new QueueWorklist();
        Maze m = new Maze(new String[] {
            "#___",
                "__F_",
                "S##_",
                "____"
        });
        String[] queueSol = {
            "#___",
            "**F_",
            "S##_",
            "____"
        };
        checkMaze(wl, m, queueSol);

    }
    // isValid tests
    @Test
    public void testWallInvalid(){
        Maze m = new Maze(new String[] {
            "#___",
                "__F_",
                "S##_",
                "____"
        });
        int[] coords = {0,0};
        assertFalse(MazeSolver.isValid(coords, m));
    }
    @Test
    public void testTooBigRow(){
        Maze m = new Maze(new String[] {
            "#___",
                "__F_",
                "S##_",
                "____"
        });
        int[] coords = {m.contents.length,0};
        assertFalse(MazeSolver.isValid(coords, m));
    }
    @Test
    public void testTooBigCol(){
        Maze m = new Maze(new String[] {
            "#___",
                "__F_",
                "S##_",
                "____"
        });
        int[] coords = {0,m.contents[0].length};
        assertFalse(MazeSolver.isValid(coords, m));
    }
    @Test
    public void testCoordsTooSmall(){
        Maze m = new Maze(new String[] {
            "#___",
                "__F_",
                "S##_",
                "____"
        });
        int[] coords = {-1,-1};
        assertFalse(MazeSolver.isValid(coords, m));
    }
    @Test
    public void testIsValid(){
        Maze m = new Maze(new String[] {
            "#___",
                "__F_",
                "S##_",
                "____"
        });
        int[] coords = {1,0};
        assertTrue(MazeSolver.isValid(coords, m));
    }
    // @Test
    // public void testNorthOffset(){
    //     Maze m = new Maze(new String[] {
    //         "#___",
    //             "__F_",
    //             "S##_",
    //             "____"
    //     });
    //     int[] coords = {0,0};
    //     assertFalse(MazeSolver.atOffset(coords, m));
    // }
// worklist tests

// solver tests
}



