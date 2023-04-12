package com.example.cinema_back_end;

import com.example.cinema_back_end.entities.*;
import com.example.cinema_back_end.repositories.*;
import com.example.cinema_back_end.security.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class CinemaBackEndApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Autowired
    private IUserService userService;

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private IBranchRepository branchRepository;

    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private IScheduleRepository scheduleRepository;

    @Autowired
    private ISeatRepository seatRepository;

    @PostConstruct
    public void init() {
   }

    public Movie addNewMovie(
            String name,
            String smallImageURl,
            String shortDescription,
            String longDescription,
            String largeImageURL,
            String director,
            String actors,
            String categories,
            LocalDate releaseDate,
            int duration,
            String trailerURL,
            String language,
            String rated,
            int isShowing) {
        Movie movie = new Movie();
        movie.setName(name);
        movie.setSmallImageURl(smallImageURl);
        movie.setShortDescription(shortDescription);
        movie.setLongDescription(longDescription);
        movie.setLargeImageURL(largeImageURL);
        movie.setDirector(director);
        movie.setActors(actors);
        movie.setCategories(categories);
        movie.setReleaseDate(releaseDate);
        movie.setDuration(duration);
        movie.setTrailerURL(trailerURL);
        movie.setLanguage(language);
        movie.setRated(rated);
        movie.setIsShowing(isShowing);
        movie = movieRepository.save(movie);
        return movie;
    }

    public static void main(String[] args) {
        SpringApplication.run(CinemaBackEndApplication.class, args);
    }

}
