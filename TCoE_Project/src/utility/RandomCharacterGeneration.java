package utility;

import java.util.Random;

public class RandomCharacterGeneration 
{
	
	public static int randomNumber()
	{
		int aNumber = 0;
		aNumber = (int)((Math.random() * 90000000)+10000000);
		return aNumber;
	}
	
	public static int randomNumber(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	
	public static String randomString()
	{
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		String randomString = sb.toString();
		return randomString;
	}

}
