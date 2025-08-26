package libraryManagement;

public class Book {
	private int id;
	private String title;
	private String author;
	private int year;
	
	
	//Constructor without id for adding new books ()id gonna be genertaed
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	//Constructor with id for reading book from db
	public Book(int id, String title, String author, int year) {
		this(title, author, year);
        this.id = id;
	}
	
	//Getters
	public int getId() { return id; }
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public int getYear() { return year; }
	
	//Setters
	public void setId(int id) { this.id = id; }
	public void setTitle(String title) { this.title = title; }
	public void setAuthor(String author) { this.author = author; }
	public void setYear(int year) { this.year = year; }
	
	

}

