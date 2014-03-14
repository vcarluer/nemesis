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
import com.badlogic.gdx.math.Vector2;

public class Map {
	public static float TILE_SIZE = 32f;
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private TiledMapTileSet tileSet;
	private TiledMapTileLayer layerFloor;
	private TiledMapTileLayer layerItems;
	private TiledMapTileLayer layerTrigger;
	private Texture textureTiles;
	private TextureRegion textureRegionCeil;
	private TextureRegion textureRegionWall;
	private boolean[][] walls;
	private Vector2 playerStart;
	private Vector2 playerTarget;
	
	private static Map levelMap;
	
	public static Map get() {
		if (levelMap == null) {
			levelMap = new Map();			
		}
		
		return levelMap;
	}
	
	protected Map()
	{					
		build();		
		parse();
		renderer = new OrthogonalTiledMapRenderer(map, 1 / TILE_SIZE);
				
	}
	
	public void renderFloor(OrthographicCamera camera) {
		int[] backgroundLayers = { 0, 1, 2 };
		renderer.setView(camera);
		renderer.render(backgroundLayers);		
	}
	
	public void renderFront() {
		int[] foregroundLayers = { 3 };
		renderer.render(foregroundLayers);		
	}
	
	private void build() {
		map = new TmxMapLoader().load("data/map0.tmx");
	}
	
	private void parse() {
		layerFloor = (TiledMapTileLayer)map.getLayers().get(0);
		layerItems = (TiledMapTileLayer)map.getLayers().get(2);
		layerTrigger = (TiledMapTileLayer)map.getLayers().get(4);
		
		int columns = layerFloor.getWidth();
		int rows = layerFloor.getHeight();
		setWalls(new boolean[rows][columns]);
		
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				TiledMapTileLayer.Cell cell = layerFloor.getCell(x, y);
				if (cell != null) {
					TiledMapTile tile = cell.getTile();
					if (tile.getProperties().containsKey("wall")) {
						getWalls()[x][y] = true;
						Wall wall = new Wall(x, y);
						World.get().addWall(wall);
					}
				}				
			}
		}		
		
		parsePlayerStart();
		parseItems();
	}
	
	private void parsePlayerStart()	{
		int columns = layerTrigger.getWidth();
		int rows = layerTrigger.getHeight();
		
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				TiledMapTileLayer.Cell cell = layerTrigger.getCell(x, y);
				if (cell != null) {
					TiledMapTile tile = cell.getTile();
					if (tile.getProperties().containsKey("PlayerStart")) {
						playerStart = new Vector2(x, y);
						return;
					}
				}				
			}
		}
	}
	
	private void parseItems() {
		int columns = layerItems.getWidth();
		int rows = layerItems.getHeight();
		
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				TiledMapTileLayer.Cell cell = layerItems.getCell(x, y);
				if (cell != null) {
					TiledMapTile tile = cell.getTile();
					if (tile.getProperties().containsKey("sniper")) {
						playerTarget = new Vector2(x, y);
						return;
					}
				}				
			}
		}
	}	

	public boolean[][] getWalls() {
		return walls;
	}

	public void setWalls(boolean[][] walls) {
		this.walls = walls;
	}

	public Vector2 getPlayerStart() {
		return playerStart;
	}

	public Vector2 getPlayerTarget() {
		return playerTarget;
	}
}
