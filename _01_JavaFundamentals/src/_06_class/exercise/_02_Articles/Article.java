package _06_class.exercise._02_Articles;

public class Article {

	private String title;
	private String content;
	private String author;

	public Article() {

	}

	public Article(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void edit(String content) {
		this.setContent(content);
	}

	public void changeAuthor(String author) {
		this.setAuthor(author);
	}

	public void rename(String title) {
		this.setTitle(title);
	}

	@Override
	public String toString() {
		return String.format("%s - %s:%s%n", title, content, author);
	}

}
