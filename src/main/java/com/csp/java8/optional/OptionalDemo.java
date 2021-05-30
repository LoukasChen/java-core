package com.csp.java8.optional;

import com.csp.java8.object.Car;
import com.csp.java8.object.Insurance;
import com.csp.java8.object.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.function.Function;

/**
 * @description: Optional api
 * @author: csp52872
 * @date: 2021/02/10
 */
public class OptionalDemo {
    public static void main(String[] args) throws Throwable {
        System.out.println(Optional.ofNullable(null).filter(o -> false));
        List<Optional<Person>> UserList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserList.add(Optional.of(new Person("optional" + i, i)));
        }

//        Optional<User> User = Optional.of(null);
        Person person = new Person("optional", 8);
        Car car = new Car();
        Insurance insurance = new Insurance();
        insurance.setName("insurance");
        car.setInsurance(insurance);
        person.setCar(car);
        Optional<Person> optionalOf = Optional.of(person);
        optionalOf.ifPresent(p -> p.setAge(10));
        System.out.println(optionalOf.get().getAge());
        Optional<String> optional = optionalOf.map(Person::getName);
        System.out.println(optional.get());
        optionalOf.flatMap(Person::getCar);

        Optional<Object> optionalEmpty = Optional.empty();
//        System.out.println(optionalEmpty.get());

        Optional<Person> optionalOfNull = Optional.ofNullable(null);
        if (optionalOfNull.isPresent()) {
            System.out.println(optionalOfNull.get());
        }

        Optional<List<Optional<Person>>> optionalOfNullable = Optional.ofNullable(UserList);
        System.out.println(optionalOfNullable.get());

        optionalOfNullable.ifPresent(list -> list.add(Optional.of(new Person("ifPresentAdd", 10))));
        System.out.println(optionalOfNullable.get());

        optionalOf.filter(p -> p.getAge() > 10).ifPresent(p -> System.out.println("age:" + p.getAge()));

        String carInsuranceName = getCarInsuranceName(optionalOf);
        System.out.println(carInsuranceName);

        String carInsuranceNameAge = getCarInsuranceName(optionalOf, 5);
        System.out.println(carInsuranceNameAge);

        Object ofElse = Optional.ofNullable(null).orElse("ofElse");
        System.out.println(ofElse);

        Object orElseGet = Optional.ofNullable(null).orElseGet(() -> optionalOf.get().getName());
        System.out.println(orElseGet);

        Optional.ofNullable("null").orElseThrow(() -> new RuntimeException("error"));

        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
        props.forEach((k, v) -> System.out.println("key:" + k + " value:" + readDuration(props, (String) k)));
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("nullName");
    }

    public static String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("nullName");
    }


    public static int readDuration(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name))
                .flatMap(OptionalDemo::stringToInt)
                .filter(value -> value > 0)
                .orElse(0);
    }

    public static Optional<Integer> stringToInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }


}
