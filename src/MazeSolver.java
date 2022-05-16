/* Class to implement a Maze solver */

import java.util.ArrayList;

public class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		Square current = maze.start;
		Square target = maze.finish;
		current.visit();
		wl.add(current);
		while(!wl.isEmpty()){
			current = wl.remove();
			if (target == current){
				return current;
			}
			else {
				ArrayList<Square> neighbors = new ArrayList<Square>();
				// add north
				if(current.getRow() + 1 < maze.contents.length){
					Square north = maze.contents[current.getRow()+1][current.getCol()];
					if(!north.getIsWall()){
						neighbors.add(north);
					}
				}
				// add south
				if(current.getRow() - 1 < maze.contents.length & current.getRow()-1 >-1){
					Square south = maze.contents[current.getRow()-1][current.getCol()];
					if(!south.getIsWall()){
						neighbors.add(south);
					}
				}
				// add east
				if(current.getCol() + 1 < maze.contents[0].length){
					Square east = maze.contents[current.getCol()+1][current.getCol()];
					if(!east.getIsWall()){
						neighbors.add(east);
					}
				}
				// add west
				if(current.getCol() - 1 < maze.contents[0].length & current.getCol() -1 > -1){
					Square west = maze.contents[current.getCol()-1][current.getCol()];
					if(!west.getIsWall()){
						neighbors.add(west);
					}
				}

				for(Object neighbor: neighbors.toArray()){
					neighbor.setPrevious(current);
					neighbor.visit();
					wl.add(neighbor);
				}
			}
		}
		return null;
	}

	/* Add any helper methods you want */
	// public static boolean isWall(Square sq){
		
	// }
	// private static Square[] getNeighbors(Square current, Maze maze){
	// 	ArrayList<Square> neighbors = new ArrayList<Square>();
	// 	// add north
	// 	if(current.getRow() + 1 < maze.contents.length){
	// 		Square north = maze.contents[current.getRow()+1][current.getCol()];
	// 		if(!north.getIsWall()){
	// 			neighbors.add(north);
	// 		}
	// 	}
	// 	// add south
	// 	if(current.getRow() - 1 < maze.contents.length & current.getRow()-1 >-1){
	// 		Square south = maze.contents[current.getRow()-1][current.getCol()];
	// 		if(!south.getIsWall()){
	// 			neighbors.add(south);
	// 		}
	// 	}
	// 	// add east
	// 	if(current.getCol() + 1 < maze.contents[0].length){
	// 		Square east = maze.contents[current.getCol()+1][current.getCol()];
	// 		if(!east.getIsWall()){
	// 			neighbors.add(east);
	// 		}
	// 	}
	// 	// add west
	// 	if(current.getCol() - 1 < maze.contents[0].length & current.getCol() -1 > -1){
	// 		Square west = maze.contents[current.getCol()-1][current.getCol()];
	// 		if(!west.getIsWall()){
	// 			neighbors.add(west);
	// 		}
	// 	}
	// 	Object[] neighborArray = neighbors.toArray();
	// 	return neighborArray;
		
	// }
	// public static Square chooseNextNeighbor(Square current, Maze maze){
	// 	// check north
	// 	if(current.getRow() + 1 < maze.contents.length){
	// 		Square north = maze.contents[current.getRow()+1][current.getCol()];
	// 		if(north.getIsWall()){
	// 			return north;
	// 		}
	// 	}
	// 	// check south
	// 	if(current.getRow() - 1 < maze.contents.length){
	// 		Square south = maze.contents[current.getRow()-1][current.getCol()];
	// 		if(south.getIsWall()){
	// 			return south;
	// 		}
	// 	}
	// 	// check east
	// 	if(current.getCol() + 1 < maze.contents[0].length){
	// 		Square east = maze.contents[current.getCol()+1][current.getCol()];
	// 		if(east.getIsWall()){
	// 			return east;
	// 		}
	// 	}
	// 	// check west
	// 	if(current.getCol() - 1 < maze.contents[0].length){
	// 		Square west = maze.contents[current.getCol()-1][current.getCol()];
	// 		if(west.getIsWall()){
	// 			return west;
	// 		}
	// 	}
	// 	return null;
	// }
	// public static int distance(Square x1y1, Square x2y2){
	// 	int x1, y1;
	// 	int x2, y2;

	// }
}
