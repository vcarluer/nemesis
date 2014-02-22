package gamers.associate.nemesis.ia;

import gamers.associate.nemesis.map.Map;

import java.util.EnumSet;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public class ActionMove extends ActionSustained {
	private List<Node> path;
	private Vector2 target;
	private Vector2 partialTarget;
	private Vector2 currentPosition;
	
	public ActionMove(Npc npc, Action parentAction, Vector2 target) {
		super(npc, parentAction);
		this.target = target;
		partialTarget = new Vector2();
		currentPosition = new Vector2();
		setId("Move");
	}
	
	@Override
	public void step(float delta) {		
		super.step(delta);
		if (path == null) {
			Node moveTarget = new Node((int) target.x, (int) target.y);
			Node moveStart = new Node((int) npc.getX(), (int) npc.getY());
			path = Pathfinder.generate(moveStart, moveTarget, Map.get().getWalls());
		}
		
		if (path != null && path.size() > 0) {
			Node nextNode = path.get(0);
			partialTarget.x = nextNode.x;
			partialTarget.y = nextNode.y;
			currentPosition.x = npc.getX();
			currentPosition.y = npc.getY();
			Vector2 moveVector = partialTarget.cpy().sub(currentPosition);			
			
			Vector2 direction = moveVector.cpy().nor();			
			float dx = direction.x * delta * npc.getMoveSpeed();
			float dy = direction.y * delta * npc.getMoveSpeed();
			if (Math.abs(dx) > Math.abs(moveVector.x)) {
				dx = moveVector.x;
			}
			
			if (Math.abs(dy) > Math.abs(moveVector.y)) {
				dy = moveVector.y;
			}
			
			npc.setX(npc.getX() + dx);
			npc.setY(npc.getY() + dy);
			
			if (npc.getX() == nextNode.x && npc.getY() == nextNode.y) {
				path.remove(0);
			}
		} else {
			notifyEndToParent();
		}
	}

	@Override
	protected float getSpeed() {
		return npc.getMoveSpeed();
	}

	@Override
	protected void action() {
			
	}

	@Override
	protected EnumSet<BodyConstraint> createBodyConstraints() {
		return EnumSet.of(BodyConstraint.Position);
	}

}
