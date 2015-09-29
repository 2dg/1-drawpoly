import javax.swing.*;
import java.awt.*;

public class Sieve extends JPanel {
	private int layers = 1;
	private int iterations = 1;
	private int scale = 1;
	public Sieve(int layers, int iterations, int scale) {
		this.layers = layers;
		this.iterations = iterations;
		this.scale = scale;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.translate(0, 200);
		g.setColor(Color.black);
		for (int radius = 1; radius <= layers; radius++) {
			int realRadius = radius * scale;
			int realDiameter = realRadius * 2;
			int modulus = iterations / radius;
			for (int offset = 0; offset < modulus; offset++) {
				g.drawOval(offset * realDiameter, -realRadius, realDiameter, realDiameter);
			}
		}
	}
}