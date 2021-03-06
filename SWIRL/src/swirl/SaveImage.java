package swirl;

import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
/**
 * Saves images generated by graphics
 * @author Amir Rasouli
 *
 */
public class SaveImage implements Runnable{

	/**
	 * Buffer image
	 */
	private final BufferedImage img ; 
	/**
	 * Frame ID
	 */
	private int frameIdx;
	/**
	 * Container
	 */
	private Container content;
	/**
	 * Path to save the file
	 */
	private String path;	
	/**
	 * Copy of graphics
	 */
	private final Graphics2D g2D; 
	/**
	 * Constructor
	 * @param contain container
	 * @param path path to save file
	 */
	SaveImage( Container contain, String path)
	{
		frameIdx = 0;
		content = contain;
		img = new BufferedImage(SwirlController.FRAME_BOUNDX, SwirlController.FRAME_BOUNDY, BufferedImage.TYPE_INT_RGB);
		g2D = img.createGraphics();
		this.path = path;

	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		while (true)
		{
			this.frameIdx++;
			this.content.printAll(g2D);
			try
			{
				ImageIO.write(img,"png", new File(this.path +this.frameIdx+".png"));
			}
			catch(Exception exception)
			{
				exception.getMessage();
			}
		}
	}
}
