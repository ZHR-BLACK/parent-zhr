package behavior_pattern.responsibilityChainModel.mode2;

import lombok.Data;

@Data
public abstract class AbstractHandler {
	
	private Handler handler;

}
