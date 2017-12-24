package input;

public class PerformanceTest {

	private static long startTime = 0;
	
	public static void startCheck() {
		startTime = System.currentTimeMillis();
	}
	
	public static void endCheck() {
		System.out.println("Time: "+ (System.currentTimeMillis()-startTime)/1000 +"sec");
		System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/(1024*1024) +" MB");
	}
}
