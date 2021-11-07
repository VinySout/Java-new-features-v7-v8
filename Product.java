package java8newfeature;

public class Product {
	private String nome = "";
	private int price = 0;
	public Product(String nome, int price) {
		setNome(nome);
		setPrice(price);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
