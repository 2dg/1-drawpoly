import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class DrawPoly extends JPanel {
	private static final int[] lbracketH = { 50, 0, 50 };
	private static final int[] rbracketH = { 0, 50, 0 };
	private static final int[] bracketV = { 0, 50, 100 };

	private static final int[] solidusH = { 0, 50 };
	private static final int[] solidusV = { 100, 0 };

	private static final Arc2D cLetter = new Arc2D.Double(0, 0, 100, 100, 45, 270, 0);

	private static final Arc2D oLetter = new Arc2D.Double(0, 0, 100, 100, 0, 360, 0);

	private static final int[] dLetterH = { 25, 0, 0, 25 };
	private static final int[] dLetterV = { 0, 0, 100, 100 };
	private static final Arc2D dArc = new Arc2D.Double(-20, 0, 100, 100, 90, -180, 0);

	private static final int[] eLetterH = { 80, 0, 0, 80 };
	private static final int[] eLetterV = { 0, 0, 100, 100 };
	private static final int[] eLetterXH = { 0, 60 };
	private static final int[] eLetterXV = { 50, 50 };

	@Override
	public void paint(Graphics gg) {
		super.paint(gg);
		Graphics2D g = (Graphics2D)(gg);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		Offset offset = new Offset(0, 0);

		Diad<Integer, Integer, Void> translate = (Integer x, Integer y) -> {
			offset.x += x;
			offset.y += y;
			g.translate(x, y);
			return null;
		};

		g.setColor(Color.decode("#212739"));
		g.fill(g.getClip());

		g.setColor(Color.decode("#1bce7c"));
		g.setStroke(new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		translate.apply(50, 50);

		g.drawLine(0, 140, 765, 140);
		g.setFont(new Font("Open Sans", Font.PLAIN, 10));
		g.drawString("<CODE /> with lines and arcs", 0, 170);

		g.drawPolyline(lbracketH, bracketV, 3);

		translate.apply(90, 0);
		g.draw(cLetter);

		translate.apply(120, 0);
		g.draw(oLetter);

		translate.apply(140, 0);
		g.drawPolyline(dLetterH, dLetterV, 4);
		g.draw(dArc);

		translate.apply(120, 0);
		g.drawPolyline(eLetterH, eLetterV, 4);
		g.drawPolyline(eLetterXH, eLetterXV, 2);

		translate.apply(150, 0);
		g.drawPolyline(solidusH, solidusV, 2);

		translate.apply(90, 0);
		g.drawPolyline(rbracketH, bracketV, 3);

		g.translate(-offset.x, -offset.y);
	}
}