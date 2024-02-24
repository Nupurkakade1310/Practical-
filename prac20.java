import java.util.Random;

class HandleError {

public static void main(String args[]) {

int a=0, b=0, c=0;

Random r = new Random();

for(int i=0; i<32; i++) {

try {

b = r.nextInt();

c = r.nextInt();

a = 12345 / (b/c);

} catch (ArithmeticException e)
 {
     System.out.println("Division by zero.");
      a = 0; // set a to zero and continue

}

System.out.println("a: 11" + a);

}

}

}