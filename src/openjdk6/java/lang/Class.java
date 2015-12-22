package openjdk6.java.lang;

import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;

@ReplaceClass("Ljava.lang.Class;")
public class Class {
	@ReplaceMember
	private void registerNatives() {}

}
