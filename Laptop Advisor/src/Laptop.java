
/*
 * This is a template class that defines a laptop object.  It includes a list of fields that define the laptop (i.e. 
 * one for each column in the spreadsheet - except the ratings).  Then an array that holds all the ratings 
 * (both objective and subjective).  And finally the overall score for the laptop.
 *
 * Author - Allen Lu
 */

public class Laptop {

	private String brand;
	private String series;
	private String model;
	private String OS;
	private double price;
	private double screenSize;
	private String resolution;
	private String dimensions;
	private double weight;
	private String gpu;
	private int battery;
	private boolean touchscreen;
	private String cpu;
	private int processorCores;
	private double processorSpeed;
	private int ram;
	private boolean hdd;
	private int storageSize;
	private boolean opticalDrive;
	private String ports; 
	private boolean bluetooth;
	private String colour;
	private String link;

	public int[] ratings = new int[14];
	// Objective:
	// [0] - resolution
	// [1] - gpu
	// [2] - battery
	// [3] - RAM
	// [4] - storageType
	// [5] - storageSize
	// [6] - cpu
	// [7] - opticalDrive
	// [8] - bluetooth
	// Subjective:
	// [9] - touchscreen
	// [10] - price
	// [11] - screenSize
	// [12] - os
	// [13] - brand
	
	private int score;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public boolean isTouchscreen() {
		return touchscreen;
	}

	public void setTouchscreen(boolean touchscreen) {
		this.touchscreen = touchscreen;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getProcessorCores() {
		return processorCores;
	}

	public void setProcessorCores(int processorCores) {
		this.processorCores = processorCores;
	}

	public double getProcessorSpeed() {
		return processorSpeed;
	}

	public void setProcessorSpeed(double processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public boolean isHdd() {
		return hdd;
	}

	public void setHdd(boolean hdd) {
		this.hdd = hdd;
	}

	public int getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public boolean isOpticalDrive() {
		return opticalDrive;
	}

	public void setOpticalDrive(boolean opticalDrive) {
		this.opticalDrive = opticalDrive;
	}

	public String getPorts() {
		return ports;
	}

	public void setPorts(String ports) {
		this.ports = ports;
	}

	public boolean isBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int[] getRatings() {
		return ratings;
	}

	public void setRatings(int[] ratings) {
		this.ratings = ratings;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String toString() {
		return "Brand = " + brand + "\nSeries = " + series + "\nModel = " + model + "\nOS = " + OS + "\nPrice (before tax) = " + price
				+ "\nScreen Size (inches) = " + screenSize + "\nResolution = " + resolution + "\nDimensions (D x W x T) = " + dimensions
				+ "\nWeight (kg) = " + weight + "\nGpu = " + gpu + "\nBattery (Wh) = " + battery + "\nTouchscreen = " + touchscreen
				+ "\nCpu = " + cpu + "\nProcessorCores = " + processorCores + "\nProcessorSpeed (GHz) = " + processorSpeed
				+ "\nRam (GB) = " + ram + "\nHdd (true for HDD, false for SSD) = " + hdd + "\nStorage Size (GB) = " + storageSize + "\nOpticalDrive = " + opticalDrive
				+ "\nPorts = " + ports + "\nBluetooth = " + bluetooth + "\nColour = " + colour + "";
	}

	

}