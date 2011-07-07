package org.griphyn.vdl.type;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Collection;

public abstract class Types {

	//TODO: check namespace references in type definitions
	private static Map<String, Type> types = 
	    new HashMap<String, Type>();

	public synchronized static Type getType(String name) throws NoSuchTypeException {
		Type type = (Type) types.get(name);		
		
		if (type == null) {		    
		    // if this matches, we have the default subscript type of int
			if(name.endsWith("[]")) {
				String base = name.substring(0, name.length() - 2);
				Type baseType = getType(base);
				Type arrayType = baseType.arrayType();
				addType(arrayType);
				return arrayType;
										
			} else {
			    			    
			    // Try to match subscript to existing types.
			    // Which means that any type used as array subscript must be
			    // defined in advance. (makes sense in the c-style) 
			    Iterator itr = types.keySet().iterator();			    
			    int flag = 0 ;			    			    
			    String it;
			    while ( itr.hasNext() ){
			            it = itr.next().toString();
			            String end = "[" + it + "]" ;
			            if (name.endsWith(end)){
			                String base = name.substring(0, name.length() - end.length() );
			                Type baseType = getType(base);
			                Type arrayType = baseType.arrayType();
			                addType(arrayType);
			                return arrayType;
			            }
			    }			    			    			       
			    throw new NoSuchTypeException(name);
			}
		} else {
			return type;
		}
	}
	
	public static boolean isPrimitive(String name) {
	    try {
	        Type t = getType(name);
	        return t.isPrimitive();
	    }
	    catch (NoSuchTypeException e) {
	        return false;
	    }
	}

	//TODO: check duplicate type?
	public synchronized static void addType(Type type) {
		types.put(type.getName(), type);
	}

	private static Type addPrimitiveType(String name) {
		Type type = Type.Factory.createType(name, true);
		addType(type);
		return type;
	}

	public static final Type INT, STRING, FLOAT, BOOLEAN, ANY, EXTERNAL;

	// add built-in primitive types
	static {
		STRING = addPrimitiveType("string");
		INT = addPrimitiveType("int");
		FLOAT = addPrimitiveType("float");
		BOOLEAN = addPrimitiveType("boolean");
		ANY = addPrimitiveType("any");
		EXTERNAL = addPrimitiveType("external");
	}

	public synchronized static void resolveTypes() throws NoSuchTypeException {
		Map<String, Type> typesCopy = 
		    new HashMap<String, Type>(types);
		for (Map.Entry<String, Type> e : typesCopy.entrySet()) {
			Type type = (Type) e.getValue();
			for (Field field : type.getFields()) {
				Type resolved = getType(field.getType().getName());
				field.setType(resolved);
			}
		}
	}
}
