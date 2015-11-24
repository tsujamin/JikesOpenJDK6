import org.jikesrvm.scheduler.MainThread;
import org.jikesrvm.classloader.OpenJDKContainerClassLoader;

public class ContainerDemo {
    public static void main(String[] args) {
    	if(args.length != 2) {
    		System.out.println("ContainerDemo classpath class");
    	} else {
	        for(int i = 0; i < 10; i++) {
	            new MainThread(
	            		new String[] {args[1]}, 
	            		new OpenJDKContainerClassLoader(args[0]))
	            .start();
	        }
    	}
    }
}