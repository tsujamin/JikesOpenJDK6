package openjdk6.java.lang;

import java.util.Properties;

import org.jikesrvm.CommandLineArgs;
import org.jikesrvm.VM;
import org.jikesrvm.classloader.Atom;
import org.jikesrvm.classloader.BootstrapClassLoader;
import org.jikesrvm.classloader.MemberReference;
import org.jikesrvm.classloader.RVMMethod;
import org.jikesrvm.classloader.TypeReference;
import org.jikesrvm.runtime.Time;
import org.vmmagic.pragma.ReplaceClass;
import org.vmmagic.pragma.ReplaceMember;

@ReplaceClass("Ljava.lang.System;")
public class System {
	
	@ReplaceMember
	private static Properties props;
	
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
	
	/**
	 * Initialise the VM System properties
	 * Derived from {@link VMSystemProperties} in GNU classpath
	 * @param props
	 * @return
	 */
	@ReplaceMember
    private static Properties initProperties(Properties props) {
		props.put("java.version", "1.6.0"); 
		props.put("java.vendor", "Jikes RVM Project");
	    props.put("java.vendor.url", "http://jikesrvm.org");	    
	    props.put("java.class.version", "50.0");
	    
	    props.put("file.separator", "/");
	    props.put("path.separator", ":");
	    props.put("line.separator", "\n");
	    
	    props.put("java.class.path", ((BootstrapClassLoader) System.class.getClassLoader()).getRepositories());
		
	    final String[] commandLineArgs = {"os.name", "os.arch", "os.version", "user.name", "user.home", "user.dir", "java.home"};
	    for(String clArg : commandLineArgs) {
	    	final String clArgVal = CommandLineArgs.getEnvironmentArg(clArg);
	    	if (clArgVal != null)
	    		props.put(clArg, clArgVal);
	    }
	    
		return props;
	}
}
