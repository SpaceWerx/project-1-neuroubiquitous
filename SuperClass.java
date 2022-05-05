class SuperClass {
   SuperClass get() {
     System.out.println("SuperClass");
     return this;
    }
}

public class Tester extends SuperClass {
   Tester get() {
      System.out.println("SubClass");
      return this;
   }

   public static void main(String[] args) {
      SuperClass tester = new Tester();
      tester.get();
   }
}

//Problem with code that does not spit out "SubClass"