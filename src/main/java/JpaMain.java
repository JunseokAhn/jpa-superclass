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

        EM.persist(movie);


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
