
import org.jikesrvm.VM;

public class HashcodeDemo {
	public static void main(String[] args) {
		VM.sysWriteln("Hashcode: ");
		VM.sysWriteln((new Object()).hashCode());
	}
}