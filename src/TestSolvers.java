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
    public void testWorklist(SearchWorklist wl, Square[] contents, Square expectedRemove){
        for(Square content: contents){
            wl.add(content);
        }
        Square removed = wl.remove();
        assertEquals(removed, expectedRemove);
        if(contents.length == 1) assertTrue(wl.isEmpty());
        else assertFalse(wl.isEmpty());
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
    public void mazeTestQueue(){
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

    @Test
    public void mazeTestStack(){
        StackWorklist wl = new StackWorklist();
        Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
        // this is incredibly stupid
        String[] stackSol = {
            "#___",
            "__F*",
            "S##*",
            "****"
        };
        checkMaze(wl, m, stackSol);
    }
    @Test
    public void mazeTestBigQueue(){
        QueueWorklist wl = new QueueWorklist();
        Maze m = new Maze(new String[] {
            "##########",
            "S_________",
            "_########_",
            "_________F"
        });
        String[] sol = {
            "##########",
            "S_________",
            "*########_",
            "*********F"
        };
        checkMaze(wl, m, sol);
    }
    @Test
    public void mazeTestBigStack(){
        StackWorklist wl = new StackWorklist();
        Maze m = new Maze(new String[] {
            "##########",
            "S_________",
            "_########_",
            "_________F"
        });
        String[] sol = {
            "##########",
            "S*********",
            "_########*",
            "_________F"
        };
        checkMaze(wl, m, sol);
    }
    @Test
    public void mazeTestUnequalPathwaysQueue(){
        QueueWorklist wl = new QueueWorklist();
        Maze m = new Maze(new String[] {
            "##############",
            "S_____________",
            "_############_",
            "_________F____"
        });
        String[] sol = {
            "##############",
            "S_____________",
            "*############_",
            "*********F____"
        };
        checkMaze(wl, m, sol);

    }
    @Test
    public void mazeTestUnequalPathwaysStack(){
        StackWorklist wl = new StackWorklist();
        Maze m = new Maze(new String[] {
            "##############",
            "S_____________",
            "_############_",
            "_________F____"
        });
        String[] sol = {
            "##############",
            "S*************",
            "_############*",
            "_________F****"
        };
        checkMaze(wl, m, sol);

    }
    // worklist tests
    @Test
    public void testQueueWorklist(){
        Square[] contents = {new Square(1,1,false), new Square(2,2,true), new Square(3,3,false)};
        Square expectedRemove = contents[0];
        testWorklist(new QueueWorklist(), contents, expectedRemove);
    } 

    @Test
    public void testStackWorklist(){
        Square[] contents = {new Square(1,1,false), new Square(2,2,true), new Square(3,3,false)};
        Square expectedRemove = contents[contents.length-1];
        testWorklist(new StackWorklist(), contents, expectedRemove);
    } 
    // solver tests


    // isValid tests
    // @Test
    // public void testWallInvalid(){
    //     Maze m = new Maze(new String[] {
    //         "#___",
    //             "__F_",
    //             "S##_",
    //             "____"
    //     });
    //     int[] coords = {0,0};
    //     assertFalse(MazeSolver.isValid(coords, m));
    // }
    // @Test
    // public void testTooBigRow(){
    //     Maze m = new Maze(new String[] {
    //         "#___",
    //             "__F_",
    //             "S##_",
    //             "____"
    //     });
    //     int[] coords = {m.contents.length,0};
    //     assertFalse(MazeSolver.isValid(coords, m));
    // }
    // @Test
    // public void testTooBigCol(){
    //     Maze m = new Maze(new String[] {
    //         "#___",
    //             "__F_",
    //             "S##_",
    //             "____"
    //     });
    //     int[] coords = {0,m.contents[0].length};
    //     assertFalse(MazeSolver.isValid(coords, m));
    // }
    // @Test
    // public void testCoordsTooSmall(){
    //     Maze m = new Maze(new String[] {
    //         "#___",
    //             "__F_",
    //             "S##_",
    //             "____"
    //     });
    //     int[] coords = {-1,-1};
    //     assertFalse(MazeSolver.isValid(coords, m));
    // }
    // @Test
    // public void testIsValid(){
    //     Maze m = new Maze(new String[] {
    //         "#___",
    //             "__F_",
    //             "S##_",
    //             "____"
    //     });
    //     int[] coords = {1,0};
    //     assertTrue(MazeSolver.isValid(coords, m));
    // }
}



