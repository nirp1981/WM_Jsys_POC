package editor.deployables.classes;

import java.io.Serializable;

public class OStepProperties implements Serializable{

	private static final long serialVersionUID = 1551484676581196104L;
	private int leftOffset;
	private int topOffset;
	
	public OStepProperties() {
		super();
	}
	
	public int getLeftOffset() {
		return leftOffset;
	}
	public void setLeftOffset(int leftOffset) {
		this.leftOffset = leftOffset;
	}
	public int getTopOffset() {
		return topOffset;
	}
	public void setTopOffset(int topOffset) {
		this.topOffset = topOffset;
	}
}
