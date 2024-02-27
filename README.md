# image-temperature-adjustment

Image Temperature Adjustment

The program is in Java. you can run via terminal / console.

1. Open console, and execute the script using : 
	> java imageTemperature.java %1 %2 %3
2. Parameter "%1" is input file name, for example : "inputFile.jpg"
3. Parameter "%2" is output file name, for example : "outputFile.jpg"
4. Parameter "%2" is adjustment value in integer, between -255 to 255
	Use positive value to get higher temperature (warmer) or negative value to get lower temperature (cooler)

For example, the full command to execute:
> java imageTemperature.java inputFile.jpg outputFile.jpg 50

The adjusted outputFile.jpg will be created automatically.
