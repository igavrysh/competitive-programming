package com.company;

public class Main {

  public static void test1() {
    Codec c = new Codec();
    String en1 = c.encode("www.google.com");
    String en2 = c.encode("www.yandex.ru");
    String en3 = c.encode("www.yahoo.ru");
    boolean passed = c.decode(en1) .equals("www.google.com")
        && c.decode(en2) .equals("www.yandex.ru")
        && c.decode(en3) .equals("www.yahoo.ru");
    System.out.println("test1:" + (passed ? "passed" : "failed"));
  }

  public static void test2() {
    Codec c = new Codec();
    String en1 = c.encode("http://www.google.com");
    String en2 = c.encode("https://www.yandex.ru");
    String en3 = c.encode("www.yahoo.ru");
    boolean passed = c.decode(en1) .equals("http://www.google.com")
        && c.decode(en2) .equals("https://www.yandex.ru")
        && c.decode(en3) .equals("www.yahoo.ru");
    System.out.println("test2:" + (passed ? "passed" : "failed"));
  }

  public static void main(String[] args) {
    test1();
    test2();
  }
}
