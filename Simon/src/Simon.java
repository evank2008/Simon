import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Simon extends JPanel implements MouseListener{

	JFrame frame;
	int topLeft=1,topRight=1,bottomLeft=1,bottomRight=1;
	//0 for dark(pressed), 1 for neutral, 2 for lit up
	public static int WIDTH=800,HEIGHT=800;
	int currentClick=0;
	final int tl=1,tr=2,bl=3,br=4;
	public static void main(String[] args) {
		new Simon();
	}
	public Simon() {
		super();
		frame = new JFrame("Simon");
		frame.setSize(WIDTH,HEIGHT);
		setBackground(new Color(36,36,36));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(this);
		frame.setVisible(true);
		frame.repaint();
		
		addMouseListener(this);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(67,67,67));
		g.fillOval(WIDTH/8, HEIGHT/8-20, WIDTH*3/4, HEIGHT*3/4);
		
		//change these all to switch statements that paint a certain color based on their number, 0 for dark 1 for neutral and 2 for bright
		if(topLeft==1) {
			g.setColor(Color.green);
			g.fillArc(125, 125-20, 275*2, 275*2, 90, 90);
		}
		if(topRight==1) {
			g.setColor(Color.red);
			g.fillArc(125, 125-20, 275*2, 275*2, 90, -90);
		}
		if(bottomLeft==1) {
			g.setColor(Color.yellow);
			g.fillArc(125, 125-20, 275*2, 275*2, 180, 90);
		}
		if(bottomRight==1) {
			g.setColor(Color.blue);
			g.fillArc(125, 125-20, 275*2, 275*2, -90, 90);
		}
		
		
		//black bars on end + inner circle
		//maybe add a design to inner circle later
		g.setColor(new Color(67,67,67));
		g.fillRect(125+275-10, 125-20,20, 275*2);
		g.fillRect(125, 125-10+275-20,275*2, 20);
		g.fillOval(275, 275-20, 250, 250);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Color c = (getColorAtPoint(e.getX(),e.getY()));
		//check which of the 4 colors it is, if it is one of them set their respective variable to 0 for pressed and set currentClick to their value
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//if currentClick!=0 then count a click on a certain button
		//set currentclick to 0
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	Color getColorAtPoint(int x, int y) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g2 = image.createGraphics();
		paint(g2);
		Color c = new Color(image.getRGB(x,y),true);
		g2.dispose();
		return c;
	}
	
}
