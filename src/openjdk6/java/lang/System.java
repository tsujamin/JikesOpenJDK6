package openjdk6.java.lang;

import org.jikesrvm.runtime.Time;
import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;

@ReplaceClass("Ljava.lang.System;")
public class System {
	@ReplaceMember
	private static void registerNatives() {}

	@ReplaceMember
	public static long currentTimeMillis() {
		return Time.currentTimeMillis();
	}
}