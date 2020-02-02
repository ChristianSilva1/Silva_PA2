import java.util.Scanner;

/*
 * Create a BMI calculator that reads the user’s weight and height 
 * (providing an option for the user to select which formula to use) 
 * calculates and displays the user’s body mass index.
 *  display the BMI categories and their values from the National Heart Lung and Blood Institute:
 */

//BMICalculator is a public class declared
public class BMICalculator {
Scanner userInput = new Scanner(System.in);
	
	public int choice;
	public double weight;
	public double heightinFeet;
	public double heightinInches;
	public double totalheight;
	public double BMI;
	public String BMICategory;
	//private instance method called readUnitType (Provides option for user to select which formula to use)
	private void readUnitType() {
		choice = 0;
		while(choice == 0) {
			System.out.println("Which units of measurements would you like to use:\n1. Imperial\n2. Metric");
			choice = userInput.nextInt();
			if(choice < 0) {
				System.out.println("Enter a valid option...");
				choice = 0;
			}
			if(choice > 3) {
				System.out.println("Enter a valid option...");
				choice = 0;
			}
		}
	}
	//private instance method called readMeasurementData that calls either readMetricData or readImperialData, depending on the unit type
	private void readMeasurementData() {
		if(this.choice == 1) {
			readImperialData();
		}
		if(this.choice == 2) {
			readMetricData();
		}
	}
	//private instance method called readMetricData
	private void readMetricData() {
		setHeight();
		setWeight();
	}
	//private instance method called readImperialData 
	private void readImperialData() {
		setHeight();
		setWeight();
	}
	
	public void readUserData() {
		readUnitType();
		readMeasurementData();
	    //public instance method called readUserData that makes use of both readUnitType and readMeasurementData methods	
	}
	//public instance method called calculateBmi that calculates the user's BMI and BMI category
	public void calculateBmi() {
		if(this.choice == 1) {
			BMI = (703 * (double)getWeight()) / (getHeight() * getHeight());
		}
		if(this.choice == 2) {
			BMI = getWeight()/(getHeight() * getHeight());
		}
		calculateBmiCategory();
	}
	//private instance method called calculateBmiCategory that determines the user's BMI category
	private void calculateBmiCategory() {
		if(this.BMI <= 18.5)
			BMICategory = "Underweight";
		else if (this.BMI <= 24.9)
			BMICategory = "Normal Weight";
		else if (this.BMI <= 29.9)
			BMICategory = "Overweight";
		else
			BMICategory = "Obesity";
	}
	//public instance method called getWeight
	public double getWeight() {
		return weight;
	}
	//private instance method called setWeight that reads weight
	private void setWeight() {
		if (this.choice == 1) {
			System.out.println("Enter your weight in pounds (lbs) : ");
				weight = userInput.nextDouble();
			if(this.weight < 0) {
				System.exit(0);  //The program exit if the user enters a negative weight
			}

		}
		else if(this.choice == 2) {
			System.out.println("Enter your weight in kilograms: ");
				weight = userInput.nextDouble();
			if(this.weight < 0) {
				System.exit(0);   //The program exit if the user enters a negative weight
			}
		}
	}
	//public instance method called getHeight
	public double getHeight() {
		return this.totalheight;
	}
	//private instance method called setHeight that reads weight
	private void setHeight() {
		if (this.choice == 1) {
			System.out.println("Enter your height in feet: ");
			heightinFeet = userInput.nextDouble() * 12;
			if(heightinFeet < 0) {
				System.exit(0);   //The program exit if the user enters a negative height
			}

			System.out.println("Enter your height in inches: ");
			heightinInches = userInput.nextDouble();
			if(heightinInches < 0) {
				System.exit(0);    //The program exit if the user enters a negative height
			}
			
			totalheight = heightinFeet + heightinInches;
			if(totalheight < 0) {
				System.exit(0);   //The program exit if the user enters a negative height
			}

		}
		else if(choice == 2) {
			System.out.println("Enter your height in meters: ");
			totalheight = userInput.nextDouble();
			if(totalheight < 0) {
				System.exit(0);    //The program exit if the user enters a negative height
			}

		}
	}
	
	//public instance method called displayBmi that prints the BMI value and category to standard output
	public void displayBmi() {
		System.out.printf("\n\nYour Body Mass Index(BMI) is %.1f", getBmi());
		System.out.print("\nYour Body Mass Index(BMI) category is : " + getBmiCategory());
	}
	//public instance method called getBmi
	public double getBmi() {
		return this.BMI;
	}
	//public instance method called getBmiCategory
	public String getBmiCategory() {
		return this.BMICategory;
	}

	public static void main(String[] args) {
		BMICalculator app = new BMICalculator();
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();

	}
}
