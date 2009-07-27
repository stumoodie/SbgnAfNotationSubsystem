package org.pathwayeditor.notations.sbgnaf.services;

import java.util.Collections;
import java.util.Set;

import org.pathwayeditor.businessobjects.drawingprimitives.ICanvas;
import org.pathwayeditor.businessobjects.drawingprimitives.attributes.Version;
import org.pathwayeditor.businessobjects.notationsubsystem.INotation;
import org.pathwayeditor.businessobjects.notationsubsystem.INotationAutolayoutService;
import org.pathwayeditor.businessobjects.notationsubsystem.INotationConversionService;
import org.pathwayeditor.businessobjects.notationsubsystem.INotationExportService;
import org.pathwayeditor.businessobjects.notationsubsystem.INotationImportService;
import org.pathwayeditor.businessobjects.notationsubsystem.INotationPluginService;
import org.pathwayeditor.businessobjects.notationsubsystem.INotationSubsystem;
import org.pathwayeditor.businessobjects.notationsubsystem.INotationValidationService;
import org.pathwayeditor.notationsubsystem.toolkit.definition.GeneralNotation;

public class SbgnAfNotationSubsystem implements INotationSubsystem {
	private static final String GLOBAL_ID = "org.pathwayeditor.notations.sbgnaf";
	private static final String DESCRIPTION = "SBGN Activity Flow Diagram Notation";
	private static final String NAME = "SBGN-AF";
	private static final Version VERSION = new Version(0, 9, 0);
	private SbgnAfNotationSyntaxService syntaxService;
	private SbgnAfValidationService validationService;
	private INotation context;

	public SbgnAfNotationSubsystem() {
		this.context = new GeneralNotation(GLOBAL_ID, NAME, DESCRIPTION, VERSION);
		this.syntaxService = new SbgnAfNotationSyntaxService(this);
		this.validationService=new SbgnAfValidationService(this);
	}
	

	public INotation getNotation() {
		return this.context;
	}

	public Set<INotationExportService> getExportServices() {
		return Collections.emptySet();
	}

	public Set<INotationImportService> getImportServices() {
		return Collections.emptySet();
	}

	public Set<INotationPluginService> getPluginServices() {
		return Collections.emptySet();
	}

	public SbgnAfNotationSyntaxService getSyntaxService() {
		return this.syntaxService;
	}

	public INotationValidationService getValidationService() {
		return validationService;
	}

	public Set<INotationConversionService> getConversionServices() {
		return Collections.emptySet();
	}

	public INotationAutolayoutService getAutolayoutService() {
		return new DefaultAutolayoutService();
	}


	private class DefaultAutolayoutService implements INotationAutolayoutService {

		public INotation getContext() {
			return context;
		}

		public boolean isImplemented() {
			return false;
		}
		public INotationSubsystem getServiceProvider() {
			return SbgnAfNotationSubsystem.this;
		}

        public void layout(ICanvas canvas) {
            throw new UnsupportedOperationException("Notation subsystem does not support this operation");
        }

        public INotation getNotation() {
            return SbgnAfNotationSubsystem.this.getNotation();
        }

        public INotationSubsystem getNotationSubsystem() {
            return SbgnAfNotationSubsystem.this;
        }
		
	}

    public boolean isFallback() {
        return false;
    }


	public void registerCanvas(ICanvas canvasToRegister) {
		// TODO Auto-generated method stub
		
	}


	public void unregisterCanvas(ICanvas canvasToRegister) {
		// TODO Auto-generated method stub
		
	}
}
