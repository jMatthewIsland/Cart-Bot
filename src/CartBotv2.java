import java.awt.*;
import java.awt.event.KeyEvent;

public class CartBotv2 {
	
	
	public static void main (String [] args) {
		
		Point mousePos = new Point(9,9);
		Point origin = new Point(0,0);
		
		while (!mousePos.equals(origin)) {
			mousePos = MouseInfo.getPointerInfo().getLocation();
			try {
				Robot r = new Robot();
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				Color testSpot;
				Color leftColor;
				Color rightColor;
				int leftColorRed, leftColorBlue, leftColorGreen;
				int rightColorRed, rightColorBlue, rightColorGreen;
				testSpot = r.getPixelColor((int) (49 * screenSize.getWidth()/100), (int) (43 * screenSize.getHeight()/100));
				int testSpotRed = testSpot.getRed();
				int testSpotBlue = testSpot.getBlue();
				int testSpotGreen = testSpot.getGreen();
				
				
				
				
				if (testSpotRed + testSpotBlue + testSpotGreen >= 100) {
					leftColor = r.getPixelColor( ( (int) ( (screenSize.getWidth()/2) - (screenSize.getWidth() / 128) ) ) , (int) (43 * screenSize.getHeight()/100)  ); 
					rightColor = r.getPixelColor( ( (int) ( (screenSize.getWidth()/2) + (screenSize.getWidth() / 128)  ) ) , (int) (43 * screenSize.getHeight()/100)  );
					leftColorRed = leftColor.getRed();
					leftColorBlue = leftColor.getBlue();
					leftColorGreen = leftColor.getGreen();
					rightColorRed = rightColor.getRed();
					rightColorBlue = rightColor.getBlue();
					rightColorGreen = rightColor.getGreen();
					
					turn((leftColorRed + leftColorBlue + leftColorGreen), (rightColorRed + rightColorBlue + rightColorGreen), (testSpotRed + testSpotBlue + testSpotGreen), r);
					trick(r);
					
					
					
					wait(1, r);
				}
				
			}catch (AWTException e) {
				System.err.println(e);
			}
		}
			
	}
	
	
	
	public static void wait(int seconds, Robot r) {
		Boolean out = false;
		Point origin = new Point(0,0);
		Point mousePos = MouseInfo.getPointerInfo().getLocation();
		for (int i = 0; (i < seconds * 2) && out == false; i ++) {
			r.delay((seconds * 1000) / 2);
			mousePos = MouseInfo.getPointerInfo().getLocation();
			if (!mousePos.equals(origin)) {
				out = true;
			}
			
		}
	}
	
	public static void trick(Robot r) {
		
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(200);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.delay(200);
	
	}
	
	
	
	public static void turn (int leftTotal, int rightTotal, int centerTotal, Robot r) {
		try {
			r = new Robot();
			System.out.println("Left Total: " + leftTotal + " Right Total: " + rightTotal);
			if (leftTotal > rightTotal) {
				//BufferedImage capture = new Robot().createScreenCapture(screenRect);
				//ImageIO.write(capture, "bmp", new File("screen" + runs));
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				r.delay(50);
				r.keyPress(KeyEvent.VK_LEFT);
				r.delay(800);
				r.keyRelease(KeyEvent.VK_LEFT);
				System.out.println("left");
			}
			else if (rightTotal > leftTotal) {
				//BufferedImage capture = new Robot().createScreenCapture(screenRect);
				//ImageIO.write(capture, "bmp", new File("screen" + runs));
				r.keyPress(KeyEvent.VK_DOWN);
				r.keyRelease(KeyEvent.VK_DOWN);
				r.delay(50);
				r.keyPress(KeyEvent.VK_RIGHT);
				r.delay(800);
				r.keyRelease(KeyEvent.VK_RIGHT);
				System.out.println("right");
			}
			
			
		}
		catch (AWTException er) {
			System.err.println(er);
		}
		//catch (IOException e) {
			//System.err.println(e);
		//}
	}
}
