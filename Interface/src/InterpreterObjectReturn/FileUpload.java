package InterpreterObjectReturn;

import java.util.List;

import InterpreterInterfaceReturn.ID;

public class FileUpload extends UserInteraction {
	
	private ID id;
	private InteractionType it;
	private List<String> mimeTypes;

	public FileUpload(
			ID id, 
			InteractionType it,
			List<String> mimeTypes){
		this.id = id;
		this.it = it;
		this.mimeTypes = mimeTypes;
	}
	
	@Override
	public ID getStepID() {
		return this.id;
	}

	@Override
	public InteractionType getType() {
		return this.it;
	}

	public List<String> getMimeTypes() {
		return mimeTypes;
	}
}
