import java.io.*; 
import javax.imageio.ImageIO; 
import java.awt.image.BufferedImage; 
import java. awt.Color;

public class Main {
  static void imageTemperatureAdjustment() {
    System.out.println("Hello World!");
  }

  public static void main(String[] args) {
  	String inputFile = args[0];
  	String outputFile = args[1];
  	int modifier = Integer.parseInt(args[2]);

  	if (!inputFile.substring(inputFile.lastIndexOf(".") + 1).equals("jpg")) {
  		System.out.println("Invalid Input File/Image Type"); 
			System.exit(0);
  	}

  	if (!outputFile.substring(outputFile.lastIndexOf(".") + 1).equals("jpg")) {
  		System.out.println("Invalid Output File/Image Type"); 
			System.exit(0);
  	}

  	if (modifier > 255 || modifier < -255) {
  		System.out.println("Invalid Adjustment Value, should in range [-255 to 255]"); 
			System.exit(0);
  	}

    try {
	    File imageFile = new File(inputFile); 
	    BufferedImage bi = ImageIO.read(imageFile);

			if(!(imageFile.exists())){ 
				System.out.println("File does not exist"); 
				System.exit(0);
			}

			int width = bi.getWidth(); 
			int height = bi.getHeight(); 

			int countloop=0;  
     	for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
					int pixel = bi.getRGB(col, row);        	

          Color color = new Color(pixel, true);
          int red = color.getRed();
          int green = color.getGreen();
          int blue = color.getBlue();

          red += modifier;
          blue -= modifier;

          if (red < 0) red = 0;
          if (red > 255) red = 255;
          if (blue < 0) blue = 0;
          if (blue > 255) blue = 255;

          color = new Color(red, green, blue);
          bi.setRGB(col, row, color.getRGB());
        }
      }

      // save the modified image
	    imageFile = new File(outputFile);
	    ImageIO.write(bi, "jpg", imageFile);
	    System.out.println("Done...");

	  } catch (Exception ex) {
	  	System.out.println("Failed to load image"); 
	  	System.out.println(ex); 
	  }
  }
}
