package gamers.associate.nemesis.map;

import gamers.associate.nemesis.ia.Node;

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
	private TiledMapTileLayer layerFloor;
	private TiledMapTileLayer layerFront;
	private TiledMapTileLayer layerItems;
	private TiledMapTileLayer layerTrigger;
	private Texture textureTiles;
	private TextureRegion textureRegionCeil;
	private TextureRegion textureRegionWall;
	private boolean[][] walls;
	private Node playerStart;
	
	public Map(OrthographicCamera camera)
	{					
		build();		
		parse();
		renderer = new OrthogonalTiledMapRenderer(map);
		renderer.setView(camera);		
	}
	
	public void renderFloor() {
		int[] backgroundLayers = { 0, 2 };
		renderer.render(backgroundLayers);		
	}
	
	public void renderFront() {
		int[] foregroundLayers = { 1 };
		renderer.render(foregroundLayers);		
	}
	
	private void build() {
		map = new TmxMapLoader().load("data/map0.tmx");
	}
	
	private void parse() {
		layerFloor = (TiledMapTileLayer)map.getLayers().get(0);
		layerFront = (TiledMapTileLayer)map.getLayers().get(1);
		layerItems = (TiledMapTileLayer)map.getLayers().get(2);
		layerTrigger = (TiledMapTileLayer)map.getLayers().get(3);
		
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
					}
				}				
			}
		}		
		
		parsePlayerStart();
	}
	
	private void parsePlayerStart()
	{
		int columns = layerItems.getWidth();
		int rows = layerItems.getHeight();
		
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				TiledMapTileLayer.Cell cell = layerTrigger.getCell(x, y);
				if (cell != null) {
					TiledMapTile tile = cell.getTile();
					if (tile.getProperties().containsKey("PlayerStart")) {
						setPlayerStart(new Node(x, y));
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

	public Node getPlayerStart() {
		return playerStart;
	}

	public void setPlayerStart(Node playerStart) {
		this.playerStart = playerStart;
	}
}
