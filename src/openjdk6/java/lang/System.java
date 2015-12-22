package openjdk6.java.lang;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.jikesrvm.VM;
import org.jikesrvm.classloader.Atom;
import org.jikesrvm.classloader.MemberReference;
import org.jikesrvm.classloader.RVMMethod;
import org.jikesrvm.classloader.TypeReference;
import org.jikesrvm.runtime.Time;
import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;

@ReplaceClass("Ljava.lang.System;")
public class System {
	
//	@ReplaceMember
//	public static PrintStream out;

	static {
//		VM.sysWriteln("Trying to set new Sytem.out");
//		out = new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out), 128), true);
//		VM.sysWriteln("Set new System.out: " + System.out.toString());
		VM.sysWriteln("Trying to invoke initializeSystemClass");
		
		final TypeReference systemRef = TypeReference.findOrCreate(java.lang.System.class);
		final Atom 	initializeMemberName = Atom.findOrCreateAsciiAtom("initializeSystemClass"),
					initializeMemberDescriptor  = Atom.findOrCreateAsciiAtom("()V");
		final RVMMethod initializeMethod = (RVMMethod) MemberReference.findOrCreate(systemRef, initializeMemberName, initializeMemberDescriptor).peekResolvedMember();
		
		if (!initializeMethod.isCompiled())
			initializeMethod.compile();
		
		initializeMethod.getInvoker().invokeInternal(null, null);
	}
	
	@ReplaceMember
	private static void registerNatives() {}

	@ReplaceMember
	public static long currentTimeMillis() {
		return Time.currentTimeMillis();
	}
}