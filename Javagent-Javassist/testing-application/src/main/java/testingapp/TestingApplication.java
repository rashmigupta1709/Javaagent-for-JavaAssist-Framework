package testingapp;

public class TestingApplication {

	public static void main(String... args)
	{
		TestingApplication t = new TestingApplication();
        System.out.println("Sum of two numbers : " + t.add(15, 20) );
    }
	
	public int add(int a, int b){
        return a+b;
    }
}

