package flags.global;

public interface Help {
	final String SHORT_HELP = """
	        \u001B[1mjSkiff - High-Performance Java 25 Build Orchestrator\u001B[0m
	        
	        \u001B[36mUSAGE:\u001B[0m
	          skiff <command> [flags]
	          skiff [-h | --help] [-v | --version]
	        
	        \u001B[36mCORE COMMANDS:\u001B[0m
	          \u001B[1minit\u001B[0m               Scaffold a strict project hierarchy (/src, /lib, /bin)
	                             and auto-inject IntelliJ (.idea) and Eclipse (.classpath) files.
	          \u001B[1mbuild\u001B[0m              Scan local source trees, verify cryptographic SHA-256
	                             hashes, and run fast in-memory compilation.
	          \u001B[1mrun\u001B[0m                Orchestrate an incremental build and launch the application.
	          \u001B[1mfree\u001B[0m               Release and clean compiled output artifacts from /bin.
	          \u001B[1mman\u001B[0m                Display the complete UNIX-style technical reference manual.
	        
	        \u001B[36mGLOBAL FLAGS:\u001B[0m
			\u001B[32m-h, --help\u001B[0m         Show this help message and exit.
			\u001B[32m-v, --version\u001B[0m      Print the current jSkiff version and exit.
        
			\u001B[36mCOMMAND FLAGS:\u001B[0m
			\u001B[32m-w, --watch\u001B[0m        Engage kernel-level hot-reload watching (build/run only).
			\u001B[32m-d, --directory\u001B[0m    \u001B[33m<path>\u001B[0m  Target a specific workspace project directory (init only).
			\u001B[32m-n, --name\u001B[0m         \u001B[33m<name>\u001B[0m  Provide an explicit project string identity.
	        
	        \u001B[36mEXIT STATUS CODES:\u001B[0m
	          \u001B[1m0\u001B[0m  = Absolute Success
	          \u001B[1m1\u001B[0m  = Compilation Failure / Dependency Graph Conflict
	          \u001B[1m2\u001B[0m  = CLI Token Syntax Error
	        
	        Documentation & Brand Integrity: GPLv3 (C) 2026 Achyuta Shrimate
	        """;
	
	static void displayShortHelpMenu() {
		System.out.println(SHORT_HELP);
	}
}
