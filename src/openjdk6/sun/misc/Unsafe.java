package openjdk6.sun.misc;

import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;

@ReplaceClass("Lsun/misc/Unsafe;")
public class Unsafe {

	@ReplaceMember
	private static void registerNatives() {}
}
