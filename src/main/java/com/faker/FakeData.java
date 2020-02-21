package com.faker;

import com.github.javafaker.Faker;

public class FakeData {

    private static Faker faker = new Faker();

    public static String randomJobTitle(){
        return faker.job().title();
    }

    public static String randomCountry(){
        return faker.country().name();
    }

    public static String randomText(){
        return faker.lorem().sentence();
    }

    public static String randomEmail(){
        return faker.internet().emailAddress();
    }

    public static String randomSkill(){
        return faker.job().keySkills();
    }

    public static String randomStage(){
        return faker.job().field();
    }

    public static int randomNumbers(int min, int max){
        return faker.random().nextInt(min,max);
    }

    public static String randomCurrency(){
        return faker.currency().code();
    }

    public static String randomName(){
        return faker.name().fullName();
    }


    public static void main(String[] args) {
        System.out.println(randomNumbers(100000,200000));
    }
}
