package desafios.diarios;

public class Book {

	protected String title;
	protected String author;
	
	public Book() {
		this.title = "";
		this.author = "";
	}

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

}
