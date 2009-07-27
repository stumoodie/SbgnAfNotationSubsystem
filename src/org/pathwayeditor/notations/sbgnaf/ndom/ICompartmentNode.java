package org.pathwayeditor.notations.sbgnaf.ndom;

import java.util.Iterator;

public interface ICompartmentNode {
	
	String getName();
	
	Iterator<IBasicActivityNode> nodeIterator();
}
