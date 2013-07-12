package cc.adjusting.piece;

import cc.moveable_type.rectangular_area.RectangularArea;

/**
 * 組合注音模組。一直佮注音活字擲入來，會排做一排。注音之間會一格一格照位排，但是中央的隔較開咧。
 * 
 * @author Ihc
 */
class 注音間隔模組 extends 注音排齊模組
{
	/** 注音符號之間隔偌遠 */
	protected double 間隔寬度;

	/**
	 * 建立一个模組。
	 * 
	 * @param 間隔寬度
	 *            注音符號之間隔偌遠
	 */
	public 注音間隔模組(double 間隔寬度)
	{
		if (間隔寬度 >= 0.0)
			this.間隔寬度 = 1.0 + 間隔寬度;
		else
			this.間隔寬度 = 1.0;
	}

	@Override
	void 加新的活字(RectangularArea 新活字)
	{
		double 頂一个中心懸度 = 上尾活字.getBounds2D().getCenterY();
		double 頂一个活字大細 = Math.max(上尾活字.getBounds2D().getWidth(), 上尾活字
				.getBounds2D().getHeight());
		累積活字.add(上尾活字);
		上尾活字 = 新活字;
		double 活字大細 = Math.max(上尾活字.getBounds2D().getWidth(), 上尾活字
				.getBounds2D().getHeight());
		上尾活字.moveBy(累積活字.getBounds2D().getCenterX()
				- 上尾活字.getBounds2D().getCenterX(), 頂一个中心懸度
				- 上尾活字.getBounds2D().getCenterY() + Math.max(頂一个活字大細, 活字大細)
				* 間隔寬度);// TODO 人工參數
		if (上尾活字會當提來對齊無())
			對齊活字 = 上尾活字;
	}
}
