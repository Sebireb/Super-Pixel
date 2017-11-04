package blocks;

import java.awt.Color;

public class EventBlock extends Block{

	public EventBlock(int px, int py, Color pc){
		super(px, py, pc);
		name = "?-Block";
	}

	@Override
	void action() {
		//Wird ausgeführt, wenn Mario gegen den Block springt.
	}

}
