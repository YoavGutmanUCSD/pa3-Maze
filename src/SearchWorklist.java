import java.util.ArrayList;
import java.util.Stack;
/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */

class StackWorklist implements SearchWorklist {
	Stack<Square> localStorage;
	public StackWorklist () {
		localStorage = new Stack<Square>();
	}
	@Override
	public void add(Square c) {
		localStorage.push(c);
	}
	@Override
	public Square remove() {
		return localStorage.pop();
	}
	@Override
	public boolean isEmpty(){
		return localStorage.empty();
	}
        @Override
        public int size() {
            return localStorage.size();
        }
}

class QueueWorklist implements SearchWorklist {
	ArrayList<Square> localStorage;
	public QueueWorklist() {
		this.localStorage = new ArrayList<Square>();
	}
	@Override
	public void add(Square c){
		localStorage.add(localStorage.size(), c);
	}
	@Override
	public Square remove(){
		return localStorage.remove(0);
	}
	@Override
	public boolean isEmpty(){
		return localStorage.size() == 0;
	}
        @Override
        public int size() {
            return localStorage.size();
        }
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
        int size();
}
