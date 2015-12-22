package openjdk6.sun.reflect;

import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;

@ReplaceClass("Lsun/reflect/Reflection;")
public class Reflection {
	
	@ReplaceMember
	public static Class getCallerClass(int depth) {
		//TODO
		return null;
	}

}
