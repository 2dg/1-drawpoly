import javax.swing.*;

public class Index {
	public static void main(String[] args) {
		JFrame f = new JFrame("DrawPoly");
		f.add(new DrawPoly());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(865, 290);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}