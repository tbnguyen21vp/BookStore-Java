package bookstorre.Repository;

public class BookDAO {

    private String name;

   public BookDAO() {
        this.name = "Java Programming";
    }

   public BookDAO(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Book Name: " + name;
    }

}
