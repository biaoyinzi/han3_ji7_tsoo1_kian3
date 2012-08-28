package cc.adjusting.piece;

import cc.moveable_type.piece.PieceMovableTypeTzu;
import cc.moveable_type.rectangular_area.RectangularArea;

/**
 * 用於左右上的包圍部件。從左右上三邊包住，像是「冂」、「門」、「鬥」和「『夃』的乃」等等。
 * 
 * @author Ihc
 */
public class 左右上三邊包圍工具 extends 物件活字包圍工具
{
	/**
	 * 建立左右上三邊包圍工具
	 * 
	 * @param 調整工具
	 *            使用此包圍工具的調整工具，並使用其自身合併相關函式
	 */
	public 左右上三邊包圍工具(MergePieceAdjuster 調整工具)
	{
		super(調整工具);
		支援包圍部件.add("冂");
		支援包圍部件.add("門");
		支援包圍部件.add("鬥");
		支援包圍部件.add("乃");
		// TODO　/*冏間鬥盈…*/
	}

	@Override
	public void 組合(PieceMovableTypeTzu 物件活字)
	{
		左右上三邊接合模組 模組 = new 左右上三邊接合模組(調整工具);
		平推包圍調整工具 平推包圍調整工具 = new 平推包圍調整工具(調整工具, 模組);
		RectangularArea[] 調整結果 = 平推包圍調整工具.產生調整後活字(物件活字.取得活字物件());
		物件活字.getPiece().重設並組合活字(調整結果);
		return;
	}
}
