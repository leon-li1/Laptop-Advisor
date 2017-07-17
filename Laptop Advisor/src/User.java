/* 
* This is a template class that defines a user.  It includes the user's name and a list (array) of the 
* user's weightings (0 to 10) corresponding to each of the laptop's ratings.
*
* author - Allen Lu
*/

public class User {

	public static String userName;
	public  int [] weightings = new int[14];
	// [0] - resolution
	// [1] - gpu
	// [2] - battery
	// [3] - RAM
	// [4] - storageType
	// [5] - storageSize
	// [6] - cpu
	// [7] - opticalDrive
	// [8] - bluetooth
	// [9] - touchscreen
	// [10] - price
	// [11] - screenSize
	// [12] - os
	// [13] - brand

	public static String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int[] getWeightings() {
		return weightings;
	}

	public void setWeightings(int weighting , int index) {
		this.weightings[index] = weighting;
	}	
}
