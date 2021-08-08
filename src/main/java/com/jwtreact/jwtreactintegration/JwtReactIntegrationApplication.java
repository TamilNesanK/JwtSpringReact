package com.jwtreact.jwtreactintegration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jwtreact.jwtreactintegration.lambaexample.MethodReference;
import com.jwtreact.jwtreactintegration.lambaexample.Movie;

@SpringBootApplication
public class JwtReactIntegrationApplication {

	public static void main(String[] args) {// create a list of integers
		// List<Integer> number = Arrays.asList(2, 3, 4, 5);
		//
		// // demonstration of map method
		// List<Integer> square = number.stream().map(x -> x *
		// x).collect(Collectors.toList());
		// System.out.println(square);
		// // create a list of String
		// List<String> names = Arrays.asList("Reflection", "Collection",
		// "Stream");
		//
		// // demonstration of filter method
		// List<String> result = names.stream().filter(s ->
		// s.startsWith("S")).collect(Collectors.toList());
		// System.out.println(result);
		// // demonstration of sorted method
		// List<String> show =
		// names.stream().sorted().collect(Collectors.toList());
		// System.out.println(show);
		//
		// // create a list of integers
		// List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);
		//
		// // collect method returns a set
		// Set<Integer> squareSet = numbers.stream().map(x -> x *
		// x).collect(Collectors.toSet());
		// System.out.println(squareSet);
		//
		// // demonstration of forEach method
		// number.stream().map(x -> x * x).forEach(y -> System.out.println(y));
		//
		// // demonstration of reduce method
		// int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i)
		// -> ans + i);
		//
		// System.out.println(even);


		// =============Predicate Functional Interface===================

		SpringApplication.run(JwtReactIntegrationApplication.class, args);
		List<Movie> movieList = new ArrayList<>();
		Movie movie1 = new Movie();
		movie1.setActorName("Vijay");
		movie1.setMovieName("Master");
		movie1.setReleaseYear(2019);

		Movie movie2 = new Movie();
		movie2.setActorName("Ajith");
		movie2.setMovieName("Viswasam");
		movie2.setReleaseYear(2019);
		movieList.add(movie1);
		movieList.add(movie2);
		
		getMoviesByActor(movieList, m -> m.getActorName() == "Vijay");

		// Method Reference
		BiFunction<Integer, Integer, Double> methodrefAdd = MethodReference::addNumber;
		// System.err.println(methodrefAdd.apply(2, 3));
		List<String> str = Arrays.asList("Ajith", "Tamil", "Mathi");
		str.sort(String::compareToIgnoreCase);
		// System.out.println(str);

		// Java Streams

		List<Movie> moviesList = Arrays.asList(new Movie("Vickam", "cobra", 2019), new Movie("India", "aaya", 2022),
				new Movie("Pask", "thatha", 2019));
		//
		// moviesList.stream()
		// .filter(m -> m.getReleaseYear() == 2022)
		// .map(m -> m.getActorName())
		// .forEach(System.out::println);
		//
		//Collect 
		// List<String> movieNames = moviesList.stream().map(m ->
		// m.getActorName())
		// .collect(Collectors.toList());
		// movieNames.forEach(System.out::println);
		// Map<Integer, List<Movie>> list = moviesList.stream()
		// .collect(Collectors.groupingBy(Movie::getReleaseYear));
		// list.forEach((k, v) -> System.out.println("key" + k + " " + "value" +
		// v.toString()));
		//
		Map<Boolean, List<Movie>> list = moviesList.stream()
				.collect(Collectors.groupingBy(m -> m.getReleaseYear() >= 2020));
		list.forEach((k, v) -> System.out.println("key" + k + "  " + "value" + v.toString()));

	}

	private static void getMoviesByActor(List<Movie> movieList, Predicate<Movie> moviePredicate) {
		for (Movie m : movieList) {
			if (moviePredicate.test(m)) {
				// System.err.println(m.getMovieName());
			}
		}
	
		
	}

}
