package org.xtext.metadoodle.interpreter.Implementation;

import java.util.List;

import org.xtext.metadoodle.interpreter.Interface.ID;

public class FileUpload extends UserInteraction {

	private List<String> mimeTypes;

	public FileUpload(ID id, String comment, InteractionType it, List<String> mimeTypes) {
		super(id, comment, it);
		this.mimeTypes = mimeTypes;
	}

	public List<String> getMimeTypes() {
		return mimeTypes;
	}

	@Override
	protected String more() {
		// TODO Auto-generated method stub
		return null;
	}
}
