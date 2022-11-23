package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
//
//      CarService carService = context.getBean(CarService.class);
//
//      carService.add(new Car("Mercedes", 600));
//      carService.add(new Car("BMW", 750));
//      carService.add(new Car("VAZ", 2109));
//      carService.add(new Car("Mosckvitch", 412));
//
//      List<Car> cars = carService.carList();
//      for (Car car : cars) {
//         System.out.println("Id =" + car.getId());
//         System.out.println("model =" + car.getModel());
//         System.out.println("series =" + car.getSeries());
//         System.out.println();
//
//
//      }
      User user1 = new User("Vasya", "Pupkin","VasyaPupkin@ya.ru");
      User user2 = new User("Dima", "Zalupkin", "DimaZalupkin@gmail.com");
      User user3 = new User("Sasha", "Krendel", "SashaKrendel@mail.ru");
      User user4 = new User("Yura", "Pendel", "YuraPendel@rambler.ru");

      Car car1 = new Car("Mercedes", 600);
      Car car2 = new Car("BMW", 750);
      Car car3 = new Car("VAZ", 2109);
      Car car4 = new Car("Mosckvitch", 412);



      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
         System.out.println("1. _____________________________________________");
      }


      System.out.println(userService.getUserByCar("Mercedes", 600));
      System.out.println("2. _____________________________________________");


      try {
         User notFoundUser = userService.getUserByCar("Broom", 90);
      } catch (NoResultException e) {
         System.out.println("User not found");
         System.out.println("3. _____________________________________________");
      }



      context.close();
   }
}
