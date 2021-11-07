package java8newfeature;

public class Honda implements Vehicle {

	@Override
	public int getSpeed() {
		return 100;
	}

	@Override
	public void applyBreak() {
		System.out.println("Breaks applied");
	}

	@Override
	public void autoPilot() {
		System.out.println("outro texto qualquer");
	}

}

class Teste {

	public static void main(String[] args) {
		Vehicle vehicle = new Honda();
		vehicle.autoPilot();
		Vehicle.airBarg();
	}
}