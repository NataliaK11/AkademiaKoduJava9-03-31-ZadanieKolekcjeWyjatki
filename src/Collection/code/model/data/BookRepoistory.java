package Collection.code.model.data;

import Collection.code.model.Book;
import exception.IdiotBookNameException;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BookRepoistory {

    private List<Book> bookRepoistory = new LinkedList<>();
    private static BookRepoistory repoistoryInstance = null;

    private BookRepoistory() {
        try {
            this.bookRepoistory.add(new Book("Pan Tadeusz", 422, 40));
            this.bookRepoistory.add(new Book("Nad Niemnem", 400, 30));
            this.bookRepoistory.add(new Book("Calineczka", 20, 10));
            this.bookRepoistory.add(new Book("Kubuś Puchatek", 45, 20));
            this.bookRepoistory.add(new Book("Thinking In Java", 1300, 100));
            this.bookRepoistory.add(new Book("Java w 21 dni", 250, 22.50));
        } catch (IdiotBookNameException e) {
            System.out.println(e.getMessage());
        }
    }


    public void addBook(Book book) {
            this.bookRepoistory.add(book);
    }

    public void printBooks() {
        System.out.println(this.bookRepoistory);
    }

    public static BookRepoistory getBookRepositoryInstance() {   //SINGLETON
        if (BookRepoistory.repoistoryInstance == null) {
            BookRepoistory.repoistoryInstance = new BookRepoistory();
        }
        return BookRepoistory.repoistoryInstance;
    }

    public void sortByPages() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                if (!(o2 instanceof Book)) {
                    return -1;
                }

                return ((Book) o1).getPages() - ((Book) o2).getPages();
            }
        };
        this.bookRepoistory.sort(c);

    }

    public void sordByPrice() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                if (!(o2 instanceof Book)) {
                    return -1;
                }
                return (int) ((((Book) o1).getPrice() - ((Book) o2).getPrice()) * 100);

            }
        };
        this.bookRepoistory.sort(c);
    }

    public void sordByTittle() {
        Comparator c = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof Book)) {
                    return -1;
                }
                if (!(o2 instanceof Book)) {
                    return -1;
                }

                return ((Book) o1).getTitle().compareTo(((Book) o2).getTitle());
            }

        };
        this.bookRepoistory.sort(c);
    }
}
