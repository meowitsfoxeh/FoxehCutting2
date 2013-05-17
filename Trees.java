package FoxehCutting2;

import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.TilePath;

public enum Trees {

	MAPLE(1517, Constants.SEERS_MAPLE_PATH, new Tile(2726,3500,0), new Tile(2725, 3492, 0), 51843),
    WILLOW(1519, Constants.DRAYNOR_WILLOW_PATH, new Tile (3089, 3231, 0), new Tile(3092, 3243, 0), 38627, 38616, 58006),
	YEW(1515, Constants.SEERS_YEW_PATH, new Tile (2708,3463,0), new Tile(2724, 3489, 0), 38755),
	MAGIC(1513, Constants.SEERS_MAGIC_PATH, new Tile (2696, 3424, 0), new Tile (2722, 3491, 0), 63176);
	
	private int logID;
	private Tile [] path;
	private int[] treeID;
	private Tile treeTile;
	private Tile bankTile;
	Trees(int logID, Tile[] path, Tile treeTile, Tile bankTile, int... treeIds) {
		this.logID=logID;
		this.path=path;
		this.treeTile=treeTile;
		this.bankTile=bankTile;
		this.treeID=treeIds;


	}
	public int getLogID() {
		return logID;
	}
	public int [] getTreeID ()  {
		return treeID;
	}
	public TilePath getbankPath () {
		return new TilePath (path);
	}
	public Tile getTreeTile () {
		return treeTile;
	}
	public Tile getbankTile () {
		return bankTile;
	}

	public TilePath gettreePath () {
		return new TilePath (path).reverse();
	}
}
