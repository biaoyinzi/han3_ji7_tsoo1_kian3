package cc.moveable_type.rectangular_area;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.security.InvalidParameterException;

/**
 * 活字型態。把<code>AreaTool</code>和預設位置大小整合起來，使用時比較方便。把<code>Area</code>
 * 的預計大小，改由繼承的方式重新撰寫<code>RectangularArea</code>，並將物件活字取名為<code>Piece-</code>。
 * 修改Area相關工具，使得Piece-也有相對應工具，並在逐步模組化。
 * 
 * @author Ihc
 */
public class 平面幾何 extends Area implements 活字單元
{
	/**
	 * 活字預計位置及大小
	 */
	private Rectangle2D.Double territory;

	/**
	 * 建立一個空的活字。
	 */
	public 平面幾何()
	{
		territory = new Rectangle2D.Double();
	}

	/**
	 * 建立一個空的活字，並用<code>Rectangle2D</code>指定活字預計位置及大小
	 * 
	 * @param territory
	 *            預計位置及大小
	 */
	@Deprecated
	public 平面幾何(Rectangle2D territory)
	{
		super();
		setTerritory(territory);
	}

	/**
	 * 用<code>Shape</code>建立一個相同形狀的活字。
	 * 
	 * @param s
	 *            字塊的形狀
	 */
	public 平面幾何(Shape s)
	{
		super(s);
		setTerritory(getBounds2D());
	}

	/**
	 * 建立一個和<code>RectangularArea</code>相同的活字。
	 * 
	 * @param rectangularArea
	 *            參考的活字
	 */
	public 平面幾何(平面幾何 rectangularArea)
	{
		super(rectangularArea);
		setTerritory(rectangularArea.getTerritory());
	}

	public 平面幾何(活字單元 rectangularArea)
	{
		this((平面幾何) rectangularArea);
	}

	/**
	 * 用<code>Shape</code>建立一個相同形狀的活字， 並用<code>Rectangle2D</code>指定目標位置及大小。
	 * 
	 * @param rectangularArea
	 *            參考的活字
	 * @param territory
	 *            預計位置及大小
	 */
	public 平面幾何(平面幾何 rectangularArea, Rectangle2D territory)
	{
		super(rectangularArea);
		setTerritory(territory);
	}

	/**
	 * 把活字座標移回原點
	 */
	public void moveToOrigin()
	{
		Rectangle2D rectangle2d = this.getBounds2D();
		moveBy(-rectangle2d.getX(), -rectangle2d.getY());
		return;
	}

	/**
	 * 把活字座標移動指定距離
	 * 
	 * @param x
	 *            要移動的水平距離
	 * @param y
	 *            要移動的垂直距離
	 */

	public void moveBy(double x, double y)
	{
		AffineTransform affineTransform = new AffineTransform();
		affineTransform.setTransform(1, 0, 0, 1, x, y);
		this.transform(affineTransform);
		return;
	}

	/**
	 * 設定活字預計位置及大小
	 * 
	 * @param territory
	 *            預計位置及大小
	 */

	public void setTerritory(Rectangle2D territory)
	{
		this.territory = new Rectangle2D.Double(territory.getX(),
				territory.getY(), territory.getWidth(), territory.getHeight());
		return;
	}

	/**
	 * 設定活字預計位置
	 * 
	 * @param x
	 *            水平位置
	 * @param y
	 *            垂直位置
	 */

	public void setTerritoryPosition(double x, double y)
	{
		territory.setRect(x, y, territory.getWidth(), territory.getHeight());
		return;
	}

	/**
	 * 設定活字預計大小
	 * 
	 * @param width
	 *            寬度
	 * @param height
	 *            高度
	 */

	public void setTerritoryDimension(double width, double height)
	{
		territory.setRect(territory.getX(), territory.getY(), width, height);
		return;
	}

	/**
	 * 取得活字預計位置及大小
	 * 
	 * @return 圖形預計位置及大小
	 */
	public Rectangle2D.Double getTerritory()
	{
		return territory;
	}

	/**
	 * 將物件重設，並將底下活字物件組合起來
	 * 
	 * @param 活字物件
	 *            合體活字底下的活字物件
	 */
	public void 重設並組合活字(平面幾何[] 活字物件)
	{
		reset();
		for (活字單元 活字物件單元 : 活字物件)
		{
			add(活字物件單元);
		}
		return;
	}

	@Override
	public void 重設並組合活字(活字單元[] 活字物件)
	{
		if (活字物件 instanceof 平面幾何[])
			重設並組合活字((平面幾何[]) 活字物件);
		else
			throw new InvalidParameterException();
	}

	@Override
	public void add(活字單元 活字物件)
	{
		if (活字物件 instanceof 平面幾何)
			add((Area) 活字物件);
		else
			throw new InvalidParameterException();
	}

	@Override
	public void subtract(活字單元 活字物件)
	{
		if (活字物件 instanceof 平面幾何)
			subtract((Area) 活字物件);
		else
			throw new InvalidParameterException();
	}
}
