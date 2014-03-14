package gamers.associate.nemesis.action;

import java.io.Serializable;

import gamers.associate.nemesis.common.GameItem;

public interface IAction extends Serializable {
	void Do(GameItem target);
}
