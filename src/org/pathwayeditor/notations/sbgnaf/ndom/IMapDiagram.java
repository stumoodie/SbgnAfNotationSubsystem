package org.pathwayeditor.notations.sbgnaf.ndom;

import java.util.Iterator;

public interface IMapDiagram {
	String getName();
	
	Iterator<IBasicActivityNode> getBasicActivityNodes();
}
