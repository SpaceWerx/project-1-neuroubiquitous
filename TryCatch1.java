public class TryCatch1 {

public static void main(String[] args) {
    System.out.println(riskyAction());
    }
public static String riskyAction(){
    try{
       System.out.println("Started executing try block");
       return "returning from try block";
    }catch(Exception e){
        return "returning from catch block";
    }finally{
        System.out.println("print statement from finally");
    }
    }
}

//Started executing try block
//print statement from finally
//returning from try block

