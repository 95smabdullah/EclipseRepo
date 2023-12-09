package day9.overload;

import java.util.Hashtable;
import java.util.Map;

public class ExampleClass {
		

	    public void print(int a, double b) {
	        System.out.println("Method with int and double: " + a + ", " + b);
//	        Map< m = new Hashtable<K, V>(), V>
	    }

	    public void print(double a, int b) {
	        System.out.println("Method with double and int: " + a + ", " + b);
	    }

	    public static void main(String[] args) {
	        ExampleClass example = new ExampleClass();

	        // Method call with arguments (1, 2)
//	        example.print(1, 2);
	    }
	}

