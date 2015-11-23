package org.jikesrvm.openjdk6.java.lang;

import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;
import org.jikesrvm.objectmodel.ObjectModel;

@ReplaceClass("Ljava.lang.Object;")
public class Object {
	@ReplaceMember
	private static void registerNatives() {}

	@ReplaceMember
	public int hashCode() {
		return ObjectModel.getObjectHashCode(this);
	}
}