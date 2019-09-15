package com.learn.polymorphic;

public class Animal {

    String age = "18";

    private String name;

    Animal(String name){
        this.name = name;
    }

    public void enjoy(){
        System.out.println("叫声........");
    }

    public  String getName(){
        return  name;
    }

}

class Cat extends Animal{

    String age = "28Cat";

    private String eyesColor;

    Cat(String name,String eyesColor) {
        super(name);
        this.eyesColor = eyesColor;
    }

    @Override
    public void enjoy() {
        System.out.println("猫叫声........");
    }

}


class Dog extends Animal{

    private String eyesColor;

    Dog(String name,String eyesColor) {
        super(name);
        this.eyesColor = eyesColor;
    }

    @Override
    public void enjoy() {
        System.out.println("狗叫声........");
    }

    public void watchDoor(){
        System.out.println("狗有看门的能力");
    }

}

class Bird extends Animal{

    private String eyesColor;

    Bird(String name,String eyesColor) {
        super(name);
        this.eyesColor = eyesColor;

//        System.out.println(naem);
//        System.out.println(eyesColor);
}

    @Override
    public void enjoy() {
        System.out.println("鸟叫声........");
    }

}

class Lady {
    private String name;
    private Animal pet;

    Lady(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void myPetEnjoy(){
        System.out.println(pet.getName());
        System.out.println(name);
        pet.enjoy();
    }
}

class Test{
    public static void main(String[] args) {
        Cat cat = new Cat("catname","blue");
        Dog dog = new Dog("dogname","black");
        Bird bird = new Bird("birdname","black");

        Lady lady = new Lady("lady",cat);
        Lady lady2 = new Lady("lady2",dog);
        Lady lady3 = new Lady("lady3",bird);
        lady.myPetEnjoy();
        lady2.myPetEnjoy();
        lady3.myPetEnjoy();

        Animal catAnimal = new Cat("lanmao","red");
        Animal dogAnimal = new Dog("langou","red");

        catAnimal.enjoy();
//        ((Dog) dogAnimal).watchDoor();
   //     dogAnimal.watchDoor();

        Animal animal12 = dog;

        Dog dog2 = (Dog) animal12;
        dog2.watchDoor();

        System.out.println(animal12.getName()+"---->");
        animal12.enjoy();

        Dog dog1= (Dog)animal12;
        dog1.watchDoor();


        Animal  animal3 = new Cat("aaa", "aa");
        System.out.println(animal3.age);

        Cat  animal5 = new Cat("aaa", "aa");
        System.out.println(animal5.age);

    }
}