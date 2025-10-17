import java.util.Objects;

public class Movie extends LibraryItem {
    private String director;
    private int minutes;

    public Movie(String title, String director, int minutes) {
        super(title);
        this.director = director;
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return minutes == movie.minutes && Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), director, minutes);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", minutes=" + minutes +
                '}';
    }
}
