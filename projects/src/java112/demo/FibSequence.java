import java.io.*;
import java.util.*; 
import java.lang.IllegalArgumentException;   
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class FibSequence {


	public static void main (String [] args)  {
	        List<Integer> result = new ArrayList<Integer>();
		FibSequence fibSequence = new FibSequence();
		result = fibSequence.fibonacci(4);
		System.out.println(result.toString());
		
		Result results = JUnitCore.runClasses(FibSequence.class);
		for (Failure failure : results.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(results.wasSuccessful());
	
	}
	
	public static List<Integer> fibonacci(int n) {
	    if (n < 0) {
	        throw new IllegalArgumentException(
	                "n must not be less than zero");
	    }
	    
	    if (n == 0) {
	        return new ArrayList<>();
	    }
	
	    if (n == 1) {
	        return Arrays.asList(0);
	    }
	
	    if (n == 2) {
	        return Arrays.asList(0, 1);
	
	    }
	    final List<Integer> seq = new ArrayList<>(n);
	    seq.add(0);    
	    seq.add(1);
	    
	    int looper = 3; // minimum n at this point
	    while (looper <= n) {
	        int a = seq.get(seq.size() - 1);
	        int b = seq.get(seq.size() - 2);
	        seq.add(a + b);
	        looper++;
	    }
	    return seq;
	}
	
	@Test 
	public void fibonacciTest () {
	
		assertEquals(0, fibonacci(0).size());
		assertEquals(Arrays.asList(0), fibonacci(1));
	    	assertEquals(Arrays.asList(0, 1), fibonacci(2));
	    	assertEquals(Arrays.asList(0, 1, 1), fibonacci(3));
	    	assertEquals(Arrays.asList(0, 1, 1, 2), fibonacci(4));
	    	assertEquals(Arrays.asList(0, 1, 1, 2, 3), fibonacci(5));
	    	assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5), fibonacci(6));
	    	assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8), fibonacci(7));
	    	assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13), fibonacci(8));
		
	
		try {
			fibonacci(-1);
			fail("Negative number test Failed");
		} catch (IllegalArgumentException ill) {
			//Nothing to do. Test passed		
		
		}
	
	}

}
