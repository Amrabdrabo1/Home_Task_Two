package Problem;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Car {
	int Id;
	int Year_Of_Manufacture;
	int Registration_number;
	double Price;
	String Make;
	String Model;
	String Color;

	public Car(int Id, String Make, String Model, int Year_Of_Manufacture, String Color, double Price,
			int Registration_number) {
		this.Id = Id;
		this.Make = Make;
		this.Model = Model;
		this.Year_Of_Manufacture = Year_Of_Manufacture;
		this.Color = Color;
		this.Price = Price;
		this.Registration_number = Registration_number;
	}
	
	@Override
    public String toString() {
        return "Car{" +
                "id=" + Id +
                ", make='" + Make + '\'' +
                ", model='" + Model + '\'' +
                ", yearOfManufacture=" + Year_Of_Manufacture +
                ", color='" + Color + '\'' +
                ", price=" + Price +
                ", registrationNumber=" + Registration_number +
                '}';
    }

	public static void main(String[] args) throws IOException{
		ArrayList<Car> Cars = new ArrayList<>();
		Cars.add(new Car(1, "BMW", "X6", 2022, "Black",125400,1259));
		Cars.add(new Car(2, "VW", "Polo", 2016, "White",70500,1254));
		Cars.add(new Car(3, "Marcedes", "GLE", 2020, "Gray",155000,1219));
		Cars.add(new Car(4, "Toyota", "Camry", 2019, "Red",50000,1214));
		Cars.add(new Car(5, "Toyota", "Corolla", 2014, "Black",45000,1210));
		Cars.add(new Car(6, "Kia", "Forte", 2018, "Orange",60000,1212));
		
		Scanner sc =  new Scanner(System.in);
		
		// Save a list of cars of a given brand to a file
		System.out.println("Enter your desired Brand: ");
		String Brand = sc.nextLine();
		
		
		FileWriter fileWriter = new FileWriter("File_a.txt");
	    for (Car car : Cars) {
	        if (car.Make.equalsIgnoreCase(Brand)) {
	            fileWriter.write(car.toString() + "\n");
	        }
	    }
	    fileWriter.close();
	    
	    
	    
	 // Save a list of cars of a given model that have been in use for more than n years to a file
		System.out.println("Enter your desired Model: ");
		String model = sc.nextLine();
		
		System.out.println("Enter your desired age: ");
		int age = sc.nextInt();
		
	    
	    FileWriter fileWriter_1 = new FileWriter("File_b.txt");
	    for (Car car : Cars) {
	        if (car.Model.equalsIgnoreCase(model) && (2023 - car.Year_Of_Manufacture) > age) {
	            fileWriter_1.write(car.toString() + "\n");
	        }
	    }
	    fileWriter_1.close();
	    
	    
	    
	    
	 // Save a list of cars of a given year of manufacture, the price of which is higher than the specified one to a file
		System.out.println("Enter your desired year of manufacture: ");
		int YOM = sc.nextInt();
		
		System.out.println("Enter your desired price: ");
		double price = sc.nextDouble();
		
		
		FileWriter fileWriter_2 = new FileWriter("File_c.txt");
		for (Car car : Cars) {
			if (car.Year_Of_Manufacture == YOM && car.Price > price) {
				fileWriter_2.write(car.toString() + "\n");
		    }
		}
		    fileWriter_2.close();
	    


	}
}
