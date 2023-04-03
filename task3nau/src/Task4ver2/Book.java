package Task4ver2;

public class Book {
    private final String name;
    private final String author;

    // взял год как строку, чтобы в library 21 строка, был общий метод запроса - норм, нет?
    private final String year;

    public Book(String name, String author, String year){
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Book book = (Book) obj;
        return book.name.equals(name) && book.author.equals(author) && book.year.equals(year);
    }

    @Override
    public int hashCode(){
        int res = 17;
        res = 31 * res + (name == null? 0 : name.hashCode());
        res = 31 * res + (author == null? 0 : author.hashCode());
        res = 31 * res + (year == null? 0 : year.hashCode());
        return res;
    }
}
