package wt1.javaFundamentals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Book implements Cloneable, Comparable<Book>{
    protected String title;
    protected String author;
    protected int price;
    protected static int edition;
    protected String isbn;

    private static boolean checkIsbn(String isbn){
        for (char digit : isbn.toCharArray()){
            if (!Character.isDigit(digit)){
                return false;
            }
        }
        return true;
    }

    public Book(String title, String author, int price, String isbn){
        if (price <= 0) throw new RuntimeException("Price cannot be non-positive!");
        if (isbn.length() != 13 || !checkIsbn(isbn)) throw new RuntimeException("ISBN number is supposed to be 13 digits!");
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    @Override
    public int compareTo(Book obj){
        return isbn.compareTo(obj.isbn);
    }

    @Override
    public Book clone(){
        try {
            Book result = (Book) super.clone();
            result.title = new String(title);
            result.author = new String(author);
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 37 * result + title.hashCode();
        result = 37 * result + author.hashCode();
        result = 37 * result + price;
        result = 37 * result + edition;
        return result;
    }

    @Override
    public boolean equals(Object o)  {
        return o instanceof Book &&
                title.equals(((Book)(o)).title) &&
                author.equals(((Book)(o)).author) &&
                price == ((Book)(o)).price &&
                isbn.equals(((Book)(o)).isbn);
    }

    @Override
    public String toString(){
        return "\nBook title: " + title +
                "\nAuthor: " + author +
                "\nPrice: " + price +
                "\nEdition: " + edition;
    }

    public static int getEdition() {
        return edition;
    }

    public static void setEdition(int edition) {
        if (edition <= 0)
            throw new RuntimeException("Edition cannot be non-positive!");

        Book.edition = edition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getIsbn() { return isbn; }
}

class ProgrammerBook extends Book{
    private String language;
    private int level;

    @Override
    public ProgrammerBook clone(){
        Object cloneBook = super.clone();
        ProgrammerBook cloneProgrammerBook = (ProgrammerBook) cloneBook;
        cloneProgrammerBook.language = new String(language);
        return cloneProgrammerBook;
    }

    @Override
    public int hashCode(){
        int result = super.hashCode();
        result = 37 * result + language.hashCode();
        result = 37 * result + level;
        return result;
    }

    @Override
    public boolean equals(Object o)  {
        return super.equals(o) &&
                o instanceof ProgrammerBook &&
                language.equals(((ProgrammerBook)(o)).language) &&
                level == ((ProgrammerBook)(o)).level;
    }

    @Override
    public String toString(){
        return super.toString() +
                "\nLanguage: " + language +
                "\nLevel: " + level;
    }

    public ProgrammerBook(String title, String author, int price,
                          String language, int level, String isbn){
        super(title, author, price, isbn);
        this.language = language;
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

class SortByName implements Comparator<Book> {
    @Override
    public int compare(Book lhs, Book rhs){
        return lhs.getTitle().compareTo(rhs.getTitle());
    }
}

class SortByNameAuthor implements Comparator<Book>{
    @Override
    public int compare(Book lhs, Book rhs){
        int compare =  lhs.getTitle().compareTo(rhs.getTitle());
        if (compare == 0){
            return lhs.getAuthor().compareTo(rhs.getAuthor());
        }
        return compare;
    }
}

class SortByAuthorName implements Comparator<Book>{
    @Override
    public int compare(Book lhs, Book rhs){
        int compare =  lhs.getAuthor().compareTo(rhs.getAuthor());
        if (compare == 0){
            return lhs.getTitle().compareTo(rhs.getTitle());
        }
        return compare;
    }
}

class SortByAuthorNamePrice implements Comparator<Book>{
    @Override
    public int compare(Book lhs, Book rhs){
        int compare =  lhs.getAuthor().compareTo(rhs.getAuthor());
        if (compare == 0){
            compare = lhs.getTitle().compareTo(rhs.getTitle());
            if (compare == 0){
                return Integer.compare(lhs.getPrice(), rhs.getPrice());
            }
            return compare;
        }
        return compare;
    }
}

public class Task12 {

    public static void main(String[] args){
        Book.setEdition(15);
        Book b = new Book("The World as Will and Representation", "A. Shopenhauer", 2500, "9847501664276");
        System.out.println(b);
        System.out.println("Hash code = " + b.hashCode());
        Book other = new Book("Beyond Good and Evil", "F. Nietzsche", 3940, "1234567899876");
        System.out.println(other);
        System.out.println("Hash code = " + other.hashCode());
        System.out.println("b.equals(other): " + b.equals(other));

        b.setTitle("Beyond Good and Evil");
        b.setAuthor("F. Nietzsche");
        b.setPrice(3940);
        System.out.println("b.equals(other): " + b.equals(other));

        ProgrammerBook pascal = new ProgrammerBook("Pascal Guide", "N. Virt", 3990, "English", 500, "8650737543219");
        System.out.println(pascal);
        System.out.println("Hash code = " + pascal.hashCode());
        System.out.println("b.equals(pascal): " + b.equals(pascal));
        System.out.println("other.equals(pascal): " + other.equals(pascal));
        ProgrammerBook pascal2 = new ProgrammerBook("Pascal Guide", "N. Virt", 3990, "English", 500, "9485665323567");
        System.out.println("pascal.equals(pascal2): " + pascal.equals(pascal2));

        ProgrammerBook pascal3 = pascal2.clone();
        System.out.println("pascal2 == pascal3: " + (pascal2 == pascal3));
        System.out.println("pascal2.equals(pascal3): " + pascal2.equals(pascal3));

        b.setTitle("Crime and Punishment"); b.setAuthor("F. Dostoevsky");
        other.setTitle("Possessed"); other.setAuthor("F. Dostoevsky");
        pascal.setTitle("Les Miserables"); pascal.setAuthor("Victor Hugo");
        pascal2.setTitle("War and Peace"); pascal2.setAuthor("Leo Tolstoy");

        TreeSet<Book> mySet = new TreeSet<Book>();
        mySet.add(b);
        mySet.add(other);
        mySet.add(pascal);
        mySet.add(pascal2);
        mySet.add(pascal3);

        Iterator<Book> it = mySet.iterator();
        while(it.hasNext()){
            Book book = it.next();
            System.out.println(book.getIsbn() + " - " + book.getTitle());
        }

        ArrayList<Book> arr = new ArrayList<>();
        arr.addAll(mySet);


        arr.sort(new SortByName());
        System.out.println(arr);
        arr.sort(new SortByNameAuthor());
        System.out.println(arr);
        arr.sort(new SortByAuthorName());
        System.out.println(arr);
        arr.sort(new SortByAuthorNamePrice());
        System.out.println(arr);
    }
}