package Lab02.AimsProject.src.Aims;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart(); //Creating an object Cart.
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Alier", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		anOrder.removeDigitalVideoDisc(dvd1); //Test for the remove code method.
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
	}
}
