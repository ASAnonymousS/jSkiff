package commands;

import flags.Flags;

@FunctionalInterface
public interface Commands {
	boolean run(Flags...flags);
}
