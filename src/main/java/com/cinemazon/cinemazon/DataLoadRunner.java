package com.cinemazon.cinemazon;

import com.cinemazon.cinemazon.entities.Auditorium;
import com.cinemazon.cinemazon.entities.Movie;
import com.cinemazon.cinemazon.entities.MovieShow;
import com.cinemazon.cinemazon.entities.enums.Rating;
import com.cinemazon.cinemazon.services.AuditoriumService;
import com.cinemazon.cinemazon.services.MovieService;
import com.cinemazon.cinemazon.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@CrossOrigin
public class DataLoadRunner implements CommandLineRunner {
    @Autowired
    private AuditoriumService auditoriumService;
    @Autowired
    private ShowService showService;
    @Autowired
    private MovieService movieService;

    @Override
    public void run(String... args) throws Exception {

        List<String> seat = new ArrayList<String>();
        List<String>  rows = new ArrayList<>(List.of("A", "B", "C", "D", "E"));
        List<String>  seats = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));

        for (String row : rows) {
            for (String seatNum : seats) {
                seat.add(row + seatNum);
            }
        }

        Auditorium a1 = new Auditorium("Sala1", 50, seat);
        Auditorium a2 = new Auditorium("Sala2", 50, seat);
        Auditorium a3 = new Auditorium("Sala3", 50, seat);


        auditoriumService.createAuditorium(a1);
        auditoriumService.createAuditorium(a2);
        auditoriumService.createAuditorium(a3);

        Movie m1 = new Movie("Everything Everywhere all at once", "Daniels", 140, "Evelyn Wang, un'immigrata cinese sulla cinquantina, attualmente impegnata in una lezione noiosa e condiscendente, si ritrova in un ripostiglio delle scope con una versione di suo marito proveniente da un universo alternativo.", false, false, false, true, "https://tinyurl.com/2k98tpkj", Rating.PERTUTTI);
        Movie m2 = new Movie("Cena con delitto - Knives out", "Rian Johnson", 130, "Un investigatore e un soldato si recano in una lussureggiante tenuta per interrogare gli eccentrici parenti di un patriarca morto durante le celebrazioni del suo ottantacinquesimo compleanno.", false, true, true, true, "https://tinyurl.com/46x92y32", Rating.PERTUTTI);
        Movie m3 = new Movie("La città incantata", "Hayao Miyazaki", 125, "La giovane ragazza Chihiro si ritrova intrappolata in un mondo spirituale e deve affrontare diverse sfide per trovare una via d'uscita e salvare i suoi genitori.", false, false, true, true, "https://pad.mymovies.it/filmclub/2003/04/021/locandina.jpg", Rating.PERTUTTI);
        Movie m4 = new Movie("Shining - Remastered", "Stanley Kubrick", 144, "Jack Torrance, aspirante scrittore, accetta l'incarico di guardiano invernale di un albergo in un luogo isolato sulle montagne del Colorado. Ma suo figlio Danny inizia a sperimentare delle visioni riguardo i terribili eventi accaduti nella struttura.", false, true, true, true, "https://tinyurl.com/yrvf3n7x", Rating.VM14);
        Movie m5 = new Movie("Bastardi senza gloria", "Quentin Tarantino", 160, "In una Francia occupata dai nazisti durante la seconda guerra mondiale, un gruppo di americani-ebrei conosciuto come i \"Bastardi\" sono scelti per portare paura nel terzo Reich tagliando lo scalpo e uccidendo i nazisti.", false, false, true, true, "https://pad.mymovies.it/filmclub/2008/10/105/locandina.jpg", Rating.PERTUTTI);
        Movie m6 = new Movie ("Inception", "Christopher Nolan", 142, "Leonardo DiCaprio è Dom Cobb, il ladro più abile nel riuscire ad estrarre segreti preziosi dal profondo del subconscio umano.", false, true, true, true, "https://pad.mymovies.it/filmclub/2009/03/027/locandina.jpg", Rating.PERTUTTI);
        Movie m7 = new Movie ("Oceania", "John Musker, Ron Clements, Don Hall (II), Chris Williams", 103, "Vaiana intraprende un'avventura per dimostrarsi esperta navigatrice e portare a termine la missione dei suoi antenati. Durante il viaggio incontra Maui, una volta potente semidio, e insieme traversano l'oceano.", true, true, true, true, "https://pad.mymovies.it/filmclub/2013/12/171/locandina.jpg", Rating.PERTUTTI);
        Movie m8 = new Movie("Se mi lasci ti cancello", "Michel Gondry", 108, "Clemetine, stanca del rapporto con Joel, si fa asportare dalla mente la parte relativa alla loro storia. Quando lui lo scopre, fa lo stesso, ma durante il procedimento cambia idea.", false, false, false, true, "https://pad.mymovies.it/filmclub/2004/10/012/locandina.jpg", Rating.PERTUTTI);
        Movie m9 = new Movie("Joker", "Todd Phillips", 122, "Arthur Fleck, attore comico fallito ed ignorato dalla società, vaga per le strade di Gotham City iniziando una lenta e progressiva discesa negli abissi della follia, sino a divenire una delle peggiori menti criminali della storia.", false, true, true, true, "https://pad.mymovies.it/filmclub/2018/06/066/locandina.jpg", Rating.VM14);
        Movie m10 = new Movie("La bottega dei suicidi", "Patrice Leconte", 85, "Un negozio specializzato nella vendita di strumenti per il suicidio rischia il fallimento quando un nuovo arrivo in famiglia si rivela essere troppo allegro.", false, false, false, true, "https://pad.mymovies.it/filmclub/2012/09/002/locandina.jpg", Rating.VM18);
        Movie m11 = new Movie("Boys don't cry", "Kimberly Peirce", 118, "La vera, tragica, storia di Brandon, cresciuto in un corpo femminile ma sempre sentitosi maschio. Un uomo alla ricerca di se stesso e dell'amore, sino alla terribile morte a causa della transfobia.", false, false, true, true, "https://pad.mymovies.it/filmclub/2002/08/271/locandina.jpg", Rating.VM18);

        movieService.createMovie(m1);
        movieService.createMovie(m2);
        movieService.createMovie(m3);
        movieService.createMovie(m4);
        movieService.createMovie(m5);
        movieService.createMovie(m6);
        movieService.createMovie(m7);
        movieService.createMovie(m8);
        movieService.createMovie(m9);
        movieService.createMovie(m10);
        movieService.createMovie(m11);

        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 9), LocalTime.of(19, 30), m1, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 9), LocalTime.of(22, 10), m2, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 9), LocalTime.of(20, 20), m3, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 9), LocalTime.of(22, 50), m1, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 9), LocalTime.of(20, 10), m2, a3));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 9), LocalTime.of(22, 50), m3, a3));

        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 10), LocalTime.of(19, 50), m4, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 10), LocalTime.of(22, 40), m1, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 10), LocalTime.of(20, 10), m5, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 10), LocalTime.of(22, 45), m2, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 10), LocalTime.of(20, 15), m6, a3));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 10), LocalTime.of(22, 50), m4, a3));

        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 11), LocalTime.of(20, 10), m5, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 11), LocalTime.of(22, 50), m3, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 11), LocalTime.of(20, 15), m7, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 11), LocalTime.of(22, 45), m6, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 11), LocalTime.of(22, 20), m8, a3));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 11), LocalTime.of(20, 10), m11, a3));

        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 12), LocalTime.of(20, 10), m8, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 12), LocalTime.of(22, 20), m3, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 12), LocalTime.of(20, 20), m10, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 12), LocalTime.of(22, 50), m7, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 12), LocalTime.of(19, 45), m1, a3));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 12), LocalTime.of(22, 20), m4, a3));

        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 13), LocalTime.of(19, 50), m9, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 13), LocalTime.of(22, 40), m9, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 13), LocalTime.of(20, 00), m1, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 13), LocalTime.of(22, 45), m10, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 13), LocalTime.of(19, 30), m11, a3));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 13), LocalTime.of(22, 10), m11, a3));

        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 14), LocalTime.of(20, 15), m9, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 14), LocalTime.of(22, 40), m2, a1));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 14), LocalTime.of(20, 05), m10, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 14), LocalTime.of(22, 35), m1, a2));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 14), LocalTime.of(20, 10), m2, a3));
        showService.createShow(new MovieShow(LocalDate.of(2023, 03, 14), LocalTime.of(22, 40), m3, a3));


        System.out.println("Application started");

    }
}
