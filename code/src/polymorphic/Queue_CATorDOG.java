package polymorphic;

import java.util.Queue;

/**
 * 设计一个可以装Cat和Dog的队列
 *
 * @author Ryan
 * @data 2020/02/27 - 周四
 */
public class Queue_CATorDOG {
  public class Pet {
    private String type;

    public Pet(String type) {
      this.type = type;
    }

    public String getPetType() {
      return type;
    }
  }

  public class Cat extends Pet {

    public Cat() {
      super("CAT");
    }
  }

  public class Dog extends Pet {

    public Dog() {
      super("DOG");
    }
  }

  private int size;
  private Queue<Pet> queue;

  public Queue_CATorDOG() {

    size = 0;
  }

//  public Queue_CATorDOG(int capacity) {
//    queue = new Pet[capacity];
//    this.capacity = capacity;
//    size = 0;
//  }

  public void add(Pet p) {
    char a = 'a';
    System.out.println((int) a);
  }
}
