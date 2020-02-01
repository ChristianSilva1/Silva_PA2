import java.util.Scanner;
public class BMICalculator {
Scanner userInput = new Scanner(System.in);
	
	public int choice;
	public double weight;
	public double heightinFeet;
	public double heightinInches;
	public double totalheight;
	public double BMI;
	public String BMICategory;
	
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
	private void readMeasurementData() {
		if(this.choice == 1) {
			readImperialData();
		}
		if(this.choice == 2) {
			readMetricData();
		}
	}
	
	private void readMetricData() {
		setHeight();
		setWeight();
	}
	
	private void readImperialData() {
		setHeight();
		setWeight();
	}
	
	public void readUserData() {
		readUnitType();
		readMeasurementData();
		
	}
	
	public void calculateBmi() {
		if(this.choice == 1) {
			this.BMI = (703 * (double)getWeight()) / (getHeight() * getHeight());
		}
		if(this.choice == 2) {
			this.BMI = getWeight()/(getHeight() * getHeight());
		}
	}
	
	private void calculateBmiCategory() {
		if(this.BMI <= 18.5)
			this.BMICategory = "Underweight";
		else if (this.BMI <= 24.9)
			this.BMICategory = "Normal Weight";
		else if (this.BMI <= 29.9)
			this.BMICategory = "Overweight";
		else
			this.BMICategory = "Obesity";
	}
	
	public double getWeight() {
		return weight;
	}
	
	private void setWeight() {
		if (this.choice == 1) {
			System.out.println("Enter your weight in pounds (lbs) : ");
			this.weight = userInput.nextDouble();
			if(this.weight < 0) {
				System.exit(0);
			}

		}
		else if(this.choice == 2) {
			System.out.println("Enter your weight in kilograms: ");
			this.weight = userInput.nextDouble();
			if(this.weight < 0) {
				System.exit(0);
			}
		}
	}
	
	public double getHeight() {
		return this.totalheight;
	}
	
	private void setHeight() {
		if (this.choice == 1) {
			System.out.println("Enter your height in feet: ");
			this.heightinFeet = userInput.nextDouble() * 12;
			if(this.heightinFeet < 0) {
				System.exit(0);
			}

			System.out.println("Enter your height in inches: ");
			this.heightinInches = userInput.nextDouble();
			if(this.heightinInches < 0) {
				System.exit(0);
			}
			
			this.totalheight = heightinFeet + heightinInches;
			if(this.totalheight < 0) {
				System.exit(0);
			}

		}
		else if(choice == 2) {
			System.out.println("Enter your height in meters: ");
			this.totalheight = userInput.nextDouble();
			if(this.totalheight < 0) {
				System.exit(0);
			}

		}
	}
	
	
	public void displayBmi() {
		System.out.printf("\n\nYour Body Mass Index(BMI) is %.1f", getBmi());
		System.out.print("\nYour Body Mass Index(BMI) category is : " + getBmiCategory());
	}
	
	public double getBmi() {
		return this.BMI;
	}
	
	public String getBmiCategory() {
		calculateBmiCategory();
		return this.BMICategory;
	}

	public static void main(String[] args) {
		BMICalculator app = new BMICalculator();
		app.readUserData();
		app.calculateBmi();
		app.displayBmi();

	}
}
