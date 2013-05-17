package FoxehCutting2;

import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.TilePath;

public enum Trees {

	MAPLE(1517, new Tile[]{new Tile(2723, 3501, 0), new Tile(2718, 3498, 0), new Tile(2716, 3493, 0), 
			new Tile(2716, 3489, 0), new Tile(2719, 3485, 0), new Tile(2724, 3484, 0), 
			new Tile(2726, 3489, 0), new Tile(2725, 3492, 0)}, new Tile(2726,3500,0), new Tile(2725, 3492, 0), 51843),
			WILLOW(1519, new Tile[]{ new Tile(3084, 3237, 0), new Tile(3085, 3242, 0), new Tile(3086, 3247, 0), 
					new Tile(3090, 3247, 0), new Tile(3092, 3247, 0)}, new Tile (3087,3234,0), new Tile(3092, 3247, 0), 38627, 38616, 58006),
					YEW(1515, new Tile[]{new Tile(2718, 3457, 0), new Tile(2722, 3460, 0), new Tile(2725, 3464, 0), 
							new Tile(2726, 3469, 0), new Tile(2726, 3474, 0), new Tile(2726, 3479, 0), 
							new Tile(2725, 3484, 0), new Tile(2724, 3489, 0)}, new Tile (2709,3460,0), new Tile(2724, 3489, 0), 38755);
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