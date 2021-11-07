package java8newfeature;

public class Yamaha implements Vehicle {

	@Override
	public int getSpeed() {
		return 120;
	}

	@Override
	public void applyBreak() {
		System.out.println("Breaks applied 2");
	}

}

class Teste2 {

	public static void main(String[] args) {
		Vehicle vehicle = new Yamaha();
		vehicle.autoPilot();
	}
}