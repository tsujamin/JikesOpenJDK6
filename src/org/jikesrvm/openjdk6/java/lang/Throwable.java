package org.jikesrvm.openjdk6.java.lang;

import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;

@ReplaceClass("Ljava.lang.Throwable;")
public class Throwable {

	@ReplaceMember
	public synchronized java.lang.Throwable fillInStackTrace() {
		//TODO
		return null;
	}
}