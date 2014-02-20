package gamers.associate.nemesis.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class Map {
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMapTileSet tileSet;
	private TiledMapTileLayer layer;
	private Texture textureTiles;
	private TextureRegion textureRegionCeil;
	private TextureRegion textureRegionWall;
	
	public Map(OrthographicCamera camera)
	{					
		build();		
		renderer = new OrthogonalTiledMapRenderer(map);
		renderer.setView(camera);
	}
	
	public void render() {
		renderer.render();
	}
	
	private void build() {
		map = new TmxMapLoader().load("data/map0.tmx");
	}
}
