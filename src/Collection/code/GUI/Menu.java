package Collection.code.GUI;

import Collection.code.model.Book;
import Collection.code.model.data.BookRepoistory;
import exception.IdiotBookNameException;

import java.util.Scanner;

public class Menu {


    static public void helloMenu() {
        do {
            System.out.println("1. Dodaj książkę, 2. Wyświetl książki, 3. Sortuj po tytule, 4. Sortuj po cenie, 5.Sortuj po ilości stron, 6. Wyjdź");

            Scanner input = new Scanner(System.in);

            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1: {
                    loadBook();
                }
                break;

                case 2: {
                    BookRepoistory.getBookRepositoryInstance().printBooks();
                }
                break;

                case 3: {
                    BookRepoistory.getBookRepositoryInstance().sordByTittle();
                }
                break;
                case 4: {
                    BookRepoistory.getBookRepositoryInstance().sordByPrice();
                }
                break;
                case 5: {
                    BookRepoistory.getBookRepositoryInstance().sortByPages();

                }
                break;
                case 6: {
                    System.exit(0);
                }
                break;
                default:
                    break;
            }


        } while (true);
    }

    public static void loadBook() {
        System.out.println("Podaj tytuł");
        Scanner input = new Scanner(System.in);
        String title = input.nextLine();
        System.out.println("Podaj cenę");
        Double price = Double.parseDouble(input.nextLine());
        System.out.println("Podaj liczbę stron");
        int pages = -1;
        boolean flag = true;
        while (flag) {
            try {
                pages = Integer.parseInt(input.nextLine());
                flag = false;
            } catch (NumberFormatException | NullPointerException e) {
                e.printStackTrace();
            } finally {
                if (pages < 1)
                    pages = 500;
            }

            try {

            BookRepoistory.getBookRepositoryInstance().addBook(new Book(title, pages, price));
        }catch (IdiotBookNameException e){
                e.getMessage();
            }

    }
}

