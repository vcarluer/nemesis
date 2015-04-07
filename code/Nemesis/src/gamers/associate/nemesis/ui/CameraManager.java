package gamers.associate.nemesis.ui;

import gamers.associate.nemesis.common.GameItem;
import gamers.associate.nemesis.map.Map;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class CameraManager {

   
    public	OrthographicCamera  cam;    
    private Rectangle glViewport;
    private float xShift;
    private float yShift;
    private float width;
    private float height;
    private GameItem follow;
    
    public CameraManager(float x, float y, float w, float h) {
    	width = w;
    	height = h;     
		
        cam = new OrthographicCamera(width / Map.TILE_SIZE, height / Map.TILE_SIZE);   
        setGlViewport(new Rectangle(x, y, width, height));
        xShift = width / (2 * Map.TILE_SIZE);
        yShift = height / (2 * Map.TILE_SIZE);
        cam.translate(xShift, yShift);
        cam.update();
    }
    
    public float getX() {
    	return this.cam.position.x - xShift;
    }
    
    public float getY() {
    	return this.cam.position.y - yShift;
    }
   
    public void render() {
    	if (follow != null) {
    		cam.position.x = follow.getX();
    		cam.position.y = follow.getY();
    	}
    	
        GL10 gl = Gdx.graphics.getGL10();

        gl.glViewport((int) getGlViewport().x, (int) getGlViewport().y,
                (int) getGlViewport().width, (int) getGlViewport().height);

        cam.update();
    }

	public GameItem getFollow() {
		return follow;
	}

	public void setFollow(GameItem f) {
		follow = f;
	}

	public Rectangle getGlViewport() {
		return glViewport;
	}

	public void setGlViewport(Rectangle glViewport) {
		this.glViewport = glViewport;
	}   
}
