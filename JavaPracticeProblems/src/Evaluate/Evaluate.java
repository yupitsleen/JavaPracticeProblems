import algs13.Stack;
import stdlib.StdIn;
import stdlib.StdOut;

//Dijkstra's two-stack algorithm for expression evaluation

public class Evaluate {

	public static void main(String[] args) {
		
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		while (!StdIn.isEmpty()) {
			// read item, push if operator
			String s = StdIn.readString();
			if (s.contentEquals("("));
			else if (s.equals("+")) ops.push(s);
			else if (s.equals("-")) ops.push(s);
			else if (s.equals("*")) ops.push(s);
			else if (s.equals("/")) ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals(")")) {
				//pop, evaluate, and push result if item is )
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) v = vals.pop() + v;
				else if (op.equals("-")) v = vals.pop() - v;
				else if (op.equals("*")) v = vals.pop() * v;
				else if (op.equals("/")) v = vals.pop() / v;
				else if (op.equals("sqrt")) v = Math.sqrt(v);
			} //item not operator or (), push double value
			else {
				vals.push(Double.parseDouble(s));
			}
			StdOut.println(vals.pop());
		}

	}

}
