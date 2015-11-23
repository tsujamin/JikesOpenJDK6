

import org.jikesrvm.scheduler.MainThread;
import org.jikesrvm.classloader.OpenJDKContainerClassLoader;

public class ContainerDemo {
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            OpenJDKContainerClassLoader cl = new OpenJDKContainerClassLoader();
            MainThread main = new MainThread(args, cl);
            main.start();
        }
    }
}