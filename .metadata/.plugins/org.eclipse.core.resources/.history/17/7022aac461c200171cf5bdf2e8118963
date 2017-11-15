package rickyAndGarrett;

import caveExplorer.CaveExplorer;
import caveExplorer.NPC;
import caveExplorer.NPCRoom;

public class GarrettRoom extends NPCRoom {
	
	private NPC presentNPC;

	public GarrettRoom(String description) {
		super(description);
		presentNPC = null;
	}
	
	public void performAction(int direction) {
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				interact();
			}else {
				CaveExplorer.print("There is nothing to interact with");
			}
		}else {
			CaveExplorer.print("That key does nothing.");
		}
	}

	public void interact() {
		// TODO Auto-generated method stub
		
	}
	

}
