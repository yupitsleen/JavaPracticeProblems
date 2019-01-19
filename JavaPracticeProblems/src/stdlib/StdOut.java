package stdlib;
/* ***********************************************************************
 *  Compilation:  javac StdOut.java
 *  Execution:    java StdOut
 *
 *  Writes data of various types to standard output.
 *
 *************************************************************************/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

/**
 *  <i>Standard output</i>. This class provides methods for writing strings
 *  and numbers to standard output.
 *  <p>
 *  For additional documentation, see <a href="http://introcs.cs.princeton.edu/15inout">Section 1.5</a> of
 *  <i>Introduction to Programming in Java: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 */
public final class StdOut {

	// force Unicode UTF-8 encoding; otherwise it's system dependent
	private static final String charsetName = "UTF-8";

	// assume language = English, country = US for consistency with StdIn
	private static final Locale US_LOCALE = new Locale("en", "US");

	// send output here
	private static PrintWriter out;

	// this is called before invoking any methods
	static {
		try {
			out = new PrintWriter(new OutputStreamWriter(System.out, charsetName), true);
		}
		catch (UnsupportedEncodingException e) { System.out.println(e); }
	}

	// don't instantiate
	private StdOut() { }

	// close the output stream (not required)
	/**
	 * Close standard output.
	 */
	public static void close() {
		if (doNothing) return;
		out.close();
	}

	/**
	 * Terminate the current line by printing the line separator string.
	 */
	public static void println() {
		if (doNothing) return;
		out.println();
	}

	/**
	 * Print an object to standard output and then terminate the line.
	 */
	public static void println(Object x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Print a boolean to standard output and then terminate the line.
	 */
	public static void println(boolean x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Print a char to standard output and then terminate the line.
	 */
	public static void println(char x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Print a double to standard output and then terminate the line.
	 */
	public static void println(double x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Print a float to standard output and then terminate the line.
	 */
	public static void println(float x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Print an int to standard output and then terminate the line.
	 */
	public static void println(int x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Print a long to standard output and then terminate the line.
	 */
	public static void println(long x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Print a short to standard output and then terminate the line.
	 */
	public static void println(short x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Print a byte to standard output and then terminate the line.
	 */
	public static void println(byte x) {
		if (doNothing) return;
		out.println(x);
	}

	/**
	 * Flush standard output.
	 */
	public static void print() {
		if (doNothing) return;
		out.flush();
	}

	/**
	 * Print an Object to standard output and flush standard output.
	 */
	public static void print(Object x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print a boolean to standard output and flush standard output.
	 */
	public static void print(boolean x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print a char to standard output and flush standard output.
	 */
	public static void print(char x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print a double to standard output and flush standard output.
	 */
	public static void print(double x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print a float to standard output and flush standard output.
	 */
	public static void print(float x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print an int to standard output and flush standard output.
	 */
	public static void print(int x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print a long to standard output and flush standard output.
	 */
	public static void print(long x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print a short to standard output and flush standard output.
	 */
	public static void print(short x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print a byte to standard output and flush standard output.
	 */
	public static void print(byte x) {
		if (doNothing) return;
		out.print(x);
		out.flush();
	}

	/**
	 * Print a formatted string to standard output using the specified
	 * format string and arguments, and flush standard output.
	 */
	public static void format(String format, Object... args) {
		if (doNothing) return;
		out.printf(US_LOCALE, format, args);
		out.flush();
	}
	public static void printf(String format, Object... args) { format (format, args); }

	/**
	 * Print a formatted string to standard output using the specified
	 * locale, format string, and arguments, and flush standard output.
	 */
	public static void format(Locale locale, String format, Object... args) {
		if (doNothing) return;
		out.printf(locale, format, args);
		out.flush();
	}
	public static void printf(Locale locale, String format, Object... args) { format (locale, format, args); }


	/**
	 * Redirect to a file.  This is a hack to get programs to work easily in eclipse.
	 * (Added by James Riely 2012/01/12.)
	 */
	public static void toFile(String filename) {
		if (doNothing) return;
		try {
			StdOut.out = new PrintWriter(new OutputStreamWriter(new FileOutputStream (filename), charsetName), true);
		} catch (FileNotFoundException e) {
			throw new Error (e.getMessage ());
		} catch (UnsupportedEncodingException e) {
			throw new Error (e.getMessage ());
		}
	}

	/**
	 * Makes it so that this class does nothing; handy for performance testing
	 * (Added by James Riely 2014/02/23.)
	 */
	public static void doNothing () { doNothing = true; }
	private static boolean doNothing = false;

	// This method is just here to test the class
	public static void main(String[] args) {

		// write to stdout
		StdOut.println("Test");
		StdOut.println(17);
		StdOut.println(true);
		StdOut.format("%.6f\n", 1.0/7.0);
	}

}
