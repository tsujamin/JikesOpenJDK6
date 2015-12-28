package openjdk6.java.lang;

import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;
import org.jikesrvm.VM;
import org.jikesrvm.objectmodel.ObjectModel;
import org.jikesrvm.runtime.ArchEntrypoints;

@ReplaceClass("Ljava.lang.Object;")
public class Object {

	@ReplaceMember
	private static void registerNatives() {}

	@ReplaceMember
	public int hashCode() {
		return ObjectModel.getObjectHashCode(this);
	}
	
	@ReplaceMember("getClass")
	public java.lang.Class<?> getClassReplacement() {
		VM.sysWriteln("Called getClass");
		return null;
	}
}
