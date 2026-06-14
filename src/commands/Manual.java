package commands;

import flags.Flags;

public class Manual implements Commands{
	final String UNIX_MAN_PAGE = """
	        \u001B[1mJSKIFF(1)\u001B[0m                    User Commands Reference                   \u001B[1mJSKIFF(1)\u001B[0m
	        
	        \u001B[36mNAME\u001B[0m
	               \u001B[1mskiff\u001B[0m - Convention-over-configuration build tool companion for Java 25.
	        
	        \u001B[36mSYNOPSIS\u001B[0m
	               \u001B[1mskiff init\u001B[0m   [\u001B[32m-d\u001B[0m \u001B[33m<path>\u001B[0m] [\u001B[32m-n\u001B[0m \u001B[33m<name>\u001B[0m]
	               \u001B[1mskiff build\u001B[0m  [\u001B[32m-w\u001B[0m] [\u001B[32m-n\u001B[0m \u001B[33m<name>\u001B[0m]
	               \u001B[1mskiff run\u001B[0m    [\u001B[32m-w\u001B[0m] [\u001B[32m-n\u001B[0m \u001B[33m<name>\u001B[0m]
	               \u001B[1mskiff free\u001B[0m   [\u001B[32m-n\u001B[0m \u001B[33m<name>\u001B[0m]
	               \u001B[1mskiff man\u001B[0m
	               \u001B[1mskiff\u001B[0m [\u001B[32m-h\u001B[0m | \u001B[32m--help\u001B[0m]
	               \u001B[1mskiff\u001B[0m [\u001B[32m-v\u001B[0m | \u001B[32m--version\u001B[0m]
	        
	        \u001B[36mDESCRIPTION\u001B[0m
	               jSkiff eliminates heavy XML/Groovy build configurations by enforcing an
	               immutable directory setup. It maps local relationships via the -sourcepath
	               compiler flag and dynamically separates third-party artifacts into Classpath
	               and Module-path locations using an ultra-fast inline manifest inspector.
	        
	        \u001B[36mCOMMANDS\u001B[0m
	               \u001B[1minit\u001B[0m   Scaffold a strict project hierarchy (/src, /lib, /bin) and
	                      auto-inject IntelliJ (.idea) and Eclipse (.classpath) config files.
	        
	               \u001B[1mbuild\u001B[0m  Scan local source trees, verify cryptographic SHA-256 hashes,
	                      and run fast in-memory compilation via ToolProvider interfaces.
	        
	               \u001B[1mrun\u001B[0m    Orchestrate an incremental build and launch the application entry point.
	        
	               \u001B[1mfree\u001B[0m   Release and clean compiled output artifacts residing under /bin.
	        
	               \u001B[1mman\u001B[0m    Display this complete UNIX-style technical reference manual.
	                      Does not accept any optional flags.
	        
	        \u001B[36mOPTIONS\u001B[0m
	               \u001B[32m-h\u001B[0m, \u001B[32m--help\u001B[0m
	                      Print the short-form help summary and exit. No command required.
	        
	               \u001B[32m-v\u001B[0m, \u001B[32m--version\u001B[0m
	                      Print the current jSkiff version string and exit. No command required.
	        
	               \u001B[32m-n\u001B[0m, \u001B[32m--name\u001B[0m \u001B[33m<name>\u001B[0m
	                      Provide an explicit project string identity during initialization.
	                      Requires a command and a name value argument.
	        
	               \u001B[32m-w\u001B[0m, \u001B[32m--watch\u001B[0m
	                      Hooks a WatchService lifecycle directly to operating system file
	                      states to provide instant hot-reloading execution environments.
	                      Requires a command (build or run).
	        
	               \u001B[32m-d\u001B[0m, \u001B[32m--directory\u001B[0m \u001B[33m<path>\u001B[0m
	                      Overrides the default terminal context folder path to isolate an
	                      alternate project target workspace directory. Requires a command
	                      and a path value argument.
	        
	        \u001B[36mEXIT STATUS\u001B[0m
	               \u001B[1m0\u001B[0m      Absolute Success.
	               \u001B[1m1\u001B[0m      Compilation Failure or Dependency Graph Conflict.
	               \u001B[1m2\u001B[0m      CLI Token Syntax Error.
	        
	        \u001B[36mAUTHORS\u001B[0m
	               jSkiff was conceptualized, designed, and architected exclusively by
	               Achyuta Shrimate under the strict legal terms of the GPLv3 license.
	        
	        \u001B[2mJSKIFF v0.1.0                       June 2026                          JSKIFF(1)\u001B[0m
	        """;
	
	@Override
	public boolean run(Flags...flags) {
		try{
			System.out.println(UNIX_MAN_PAGE);
			return true;
		} catch (Exception e) {
			System.out.println("There is some unexpected problem in Manual Command Class");
			return false;
		}
	}
}
