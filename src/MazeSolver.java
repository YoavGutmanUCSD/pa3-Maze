/* Class to implement a Maze solver */

import java.util.ArrayList;

public class MazeSolver {

    public static Square solve(Maze maze, SearchWorklist wl){
        if(maze.start == null || maze.finish == null) return null;
        maze.start.visit();
        wl.add(maze.start);

        while(!wl.isEmpty()){
            Square current = wl.remove();
            if(current == maze.finish) {
                System.out.println("DONE");
                return current;
            }
            addToWorklist(atOffset(current, new int[]{1, 0}, maze), current, wl);
            addToWorklist(atOffset(current, new int[]{-1, 0}, maze), current, wl);
            addToWorklist(atOffset(current, new int[]{0, 1}, maze), current, wl);
            addToWorklist(atOffset(current, new int[]{0, -1}, maze), current, wl);
            // System.out.format("Previous is: %s\n", current.getPrevious());
        }
        System.out.println("You weren't supposed to do that.");
        return null;
    }
    /*
     * recursively examine worklist until finished square found.
     * this one technically works, but returns null every time 
     * this is because all the trees it generates don't stop going
     * the last one to finish will eventually be null 9 times out of 10
     */
    // public static Square solve(Maze maze, SearchWorklist wl) {
    //     if(maze.start == null || maze.finish == null) return null;
    //     maze.start.visit();
    //     wl.add(maze.start);
    //     return solveWorklist(maze, wl);
    // }
    // private static Square solveWorklist(Maze maze, SearchWorklist wl){
    //     if(wl.isEmpty()){
    //         System.out.println("EMPTY");
    //         return null;
    //     }
    //     Square current = wl.remove();
    //     if(current == maze.finish) {
    //         System.out.println("DONE");
    //         return current;
    //     }
    //     addToWorklist(atOffset(current, new int[]{1, 0}, maze), current, wl);
    //     addToWorklist(atOffset(current, new int[]{-1, 0}, maze), current, wl);
    //     addToWorklist(atOffset(current, new int[]{0, 1}, maze), current, wl);
    //     addToWorklist(atOffset(current, new int[]{0, -1}, maze), current, wl);
    //     // System.out.println(current.toString());
    //     return solveWorklist(maze, wl);
    // }
    // adds non-null squares to worklist
    private static void addToWorklist(Square sq, Square prev, SearchWorklist wl) {
        if(sq == null) return;
        // System.out.format("Added %s\n", sq.toString());
        sq.setPrevious(prev);
        sq.visit();
        wl.add(sq);
        // System.out.format("Set previous to %s\n", sq.getPrevious().toString());
    }

    // returns square at coordinate offset
    public static Square atOffset(Square sq, int[] offset, Maze maze){
        int[] coords = {sq.getRow() + offset[0], sq.getCol() + offset[1]};
        return atCoords(coords, maze);
    }

    // return square at coordinates
    public static Square atCoords(int[] coords, Maze maze) {
        if(isValid(coords, maze)){
            return maze.contents[coords[0]][coords[1]];
        }
        return null;
    }

    // return "do these coordinates refer to a valid square?"
    public static boolean isValid(int[] coords, Maze maze){
        boolean validInputForMaze = coords[0] < maze.contents.length & 
            coords[1] < maze.contents[0].length & 
            coords.length == 2 & 
            coords[0] >= 0 &
            coords[1] >= 0; 
        if(!validInputForMaze) return false;
        Square sqAtCoords = maze.contents[coords[0]][coords[1]];
        return !sqAtCoords.getIsWall() & !sqAtCoords.isVisited();
    }
}
