package flags.global;

import flags.Flags;

@FunctionalInterface
public interface FlagsGlobal extends Flags{
	@Override
	public Boolean run();
}
