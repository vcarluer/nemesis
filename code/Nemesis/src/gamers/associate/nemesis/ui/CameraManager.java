package gamers.associate.nemesis.ui;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class CameraManager implements ApplicationListener {

   
    public	OrthographicCamera  cam;
    private float               rotationSpeed;

    
    
    public CameraManager() {
        rotationSpeed = 0.5f;
        float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
        cam = new OrthographicCamera(w / 32f, h / 32f);        
        cam.position.set(w / 2, h / 2, 0);
        cam.translate(w / 64f, h / 64f);
        cam.update();

    }

    @Override
    public void render() {
        handleInput();
        //GL10 gl = Gdx.graphics.getGL10();

        // Camera --------------------- /
        //gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        //gl.glViewport((int) glViewport.x, (int) glViewport.y,
        //        (int) glViewport.width, (int) glViewport.height);

        cam.update();
        //cam.apply(gl);
        
        // Texturing --------------------- /
        //gl.glActiveTexture(GL10.GL_TEXTURE0);
        //gl.glEnable(GL10.GL_TEXTURE_2D);
        //texture.bind();

        //mesh.render(GL10.GL_TRIANGLES);

    }

    private void handleInput() {
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            cam.zoom += 0.02;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
            cam.zoom -= 0.02;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (cam.position.x > 0)
                cam.translate(-3, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (cam.position.x < 1024)
                cam.translate(3, 0, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (cam.position.y > 0)
                cam.translate(0, -3, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (cam.position.y < 1024)
                cam.translate(0, 3, 0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            cam.rotate(-rotationSpeed, 0, 0, 1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.E)) {
            cam.rotate(rotationSpeed, 0, 0, 1);
        }
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
}
