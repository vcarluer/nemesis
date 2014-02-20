package gamers.associate.nemesis.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

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
		parse();
		renderer = new OrthogonalTiledMapRenderer(map);
		renderer.setView(camera);		
	}
	
	public void render() {
		renderer.render();
	}
	
	private void build() {
		map = new TmxMapLoader().load("data/map0.tmx");
	}
	
	private void parse() {
		TiledMapTileLayer layer = (TiledMapTileLayer)map.getLayers().get(0);
		TiledMapTile tile1 = layer.getCell(0, 0).getTile();
		boolean isWall1 = tile1.getProperties().containsKey("wall");
		boolean isWall2 = layer.getCell(1, 1).getTile().getProperties().containsKey("wall");		
	}
}
