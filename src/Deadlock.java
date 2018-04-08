import org.junit.Test;

public class Deadlock {
 
    String str1 = "Java";
    String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
            	System.out.println(str1 +" is going 4 sync @ 1");
                synchronized(str1){                	
                	System.out.println(str2 +" is going 4 sync @ 1 ");
                    synchronized(str2){
                        System.out.println(str1 + str2);
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
            	System.out.println(str2 +" is going 4 sync @ 2");
                synchronized(str2){
                	System.out.println(str1 +" is going 4 sync @ 2");
                    synchronized(str1){
                        System.out.println(str2 + str1);
                    }
                }
            }
        }
    };
     @Test
    public  void main(){
        Deadlock mdl = new Deadlock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}