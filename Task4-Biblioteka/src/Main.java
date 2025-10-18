public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addItem(new Book("Gra o tron", "George R.R. Martin", 1000));
        library.addItem(new Book("Zdazyc przed Panem Bogiem", "Hanna Krall", 170));
        library.addItem(new Movie("Incepcja", "Christopher Nolan", 148));
        library.addItem(new Movie("Rocky", "John G.Avildsen", 119));
        UserInteface ui = new UserInteface(library);
        ui.menu();
    }
}
