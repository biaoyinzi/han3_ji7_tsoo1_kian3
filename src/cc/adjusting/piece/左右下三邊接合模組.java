package cc.adjusting.piece;

/**
 * 適用於外部部件有左右下三邊的活字接合，如「⿴凵乂」為「凶」。在接合時，都固定外部活字，並將內部活字固定在中上縮放。
 * 
 * @author Ihc
 */
public class 左右下三邊接合模組 extends 縮放接合模組
{
	/**
	 * 建立左右下三邊接合模組
	 * 
	 * @param 調整工具
	 *            使用此模組的調整工具，並使用其自身合併相關函式
	 */
	public 左右下三邊接合模組(MergePieceAdjuster 調整工具)
	{
		super(調整工具);
	}

	@Override
	public void 變形處理(double middleValue)
	{
		super.變形處理(middleValue);
		temporaryPiece.moveBy(outsidePiece.getBounds2D().getCenterX()
				- temporaryPiece.getBounds2D().getCenterX(), outsidePiece
				.getBounds2D().getMinY()
				- temporaryPiece.getBounds2D().getMinY());
		return;
	}
}
