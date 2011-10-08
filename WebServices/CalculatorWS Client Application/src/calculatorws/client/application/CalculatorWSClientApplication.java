package calculatorws.client.application;

public class CalculatorWSClientApplication {

    public static void main(String[] args) {
	System.out.println(add(20,3));
    }

    private static int add(int i, int j) {
	org.me.calculator.CalculatorWS_Service service = new org.me.calculator.CalculatorWS_Service();
	org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
	return port.add(i, j);
    }
}
