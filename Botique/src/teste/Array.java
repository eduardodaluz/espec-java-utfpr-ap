package teste;

public class Array {
    
    public static void main(String[] args) {
	String[] teste = {"teste1", "teste2"};
	for(String t : teste) {
	    System.out.println(t);
	}
	System.out.println("Segundo....");
	char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e',
			    'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));
    }
    
}
