
package bookstorre;

public class NewClass {
    private String name;
    private String author;

    public NewClass(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // geter and setter
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "Book Name: " + name + " Author: " + author;
    }

    public static void main(String[] args) {
        NewClass book = new NewClass("Java Programming", "James Gosling");
        System.out.println(book);
    }
}
