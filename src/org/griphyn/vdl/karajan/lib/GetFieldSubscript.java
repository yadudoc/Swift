package org.griphyn.vdl.karajan.lib;

import java.util.Collection;

import org.globus.cog.karajan.arguments.Arg;
import org.globus.cog.karajan.stack.VariableStack;
import org.globus.cog.karajan.workflow.ExecutionException;
import org.griphyn.vdl.mapping.DSHandle;
import org.griphyn.vdl.mapping.HandleOpenException;
import org.griphyn.vdl.mapping.InvalidPathException;
import org.griphyn.vdl.mapping.Path;

public class GetFieldSubscript extends VDLFunction {

	public static final SwiftArg PA_SUBSCRIPT = new SwiftArg.Positional("subscript");

	static {
		setArguments(GetFieldSubscript.class, new Arg[] { PA_VAR, PA_SUBSCRIPT });
	}

	public Object function(VariableStack stack) throws ExecutionException {
		Object var1 = PA_VAR.getValue(stack);
		if(!(var1 instanceof DSHandle)) {
			throw new ExecutionException("was expecting a dshandle, got: "+var1.getClass());
		}
		DSHandle var = (DSHandle) var1;

		Object index = PA_SUBSCRIPT.getValue(stack);

		try {
			Path path;
			if ("*".equals(index)) {
			    path = Path.CHILDREN;
			}
			else {
				path = Path.EMPTY_PATH.addFirst((Comparable<?>) index, true);
			}
			Collection<DSHandle> fields = var.getFields(path);
			if (fields.size() == 1) {
				return fields.iterator().next();
			}
			else {
				return fields;
			}
		}
		catch (InvalidPathException e) {
			throw new ExecutionException(e);
		}
		catch (HandleOpenException e) {
			throw new ExecutionException(e);
		}
	}


}
