import Join_Stratege.Book;
import Join_Stratege.Item;
import Join_Stratege.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory EMF = Persistence.createEntityManagerFactory("hello");
        EntityManager EM = EMF.createEntityManager();
        EntityTransaction ET = EM.getTransaction();

        ET.begin();
        Movie movie = new Movie();
        movie.setDirector("Junseok");
        movie.setActor("Junsoku");
        movie.setName("this is a movie");
        movie.setPrice(15000);
        movie.setCreatedBy("준석");
        
        Book book = new Book();
        book.setAuthor("Junseok");
        book.setIsbn("1234");
        book.setLastModifiedBy("준석");

        Item item = new Item();
        item.setName("Junseok");
        item.setPrice(10000);

        EM.persist(item);
        EM.persist(movie);
        EM.persist(book);


        EM.flush();
        EM.clear();
//      join으로 무비를 조회해옴
        Movie movie2 = EM.find(Movie.class, 1l);
        System.out.println(movie2);
        ET.commit();
        EM.close();
        EMF.close();
    }
}
