package config;

import java.util.function.Predicate;
import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;

class File {


    public static void main(String[] args) {
        int a = 10;
        int b = 4;
        int max = (a > b) ? a : b;
        System.out.println("Maximum value is: "+max);

        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        System.out.println(isEven.test(4));

        Predicate<String> isNull = (s) -> s == null;
        System.out.println(isNull.test(null));
        String s = "This is a valid string";

        String reversed = Arrays.stream(s.trim().split("\\s+"))
                          .map(word -> new StringBuilder(word).reverse().toString())
                          .reduce((w1, w2) -> w1 + " " + w2)
                          .orElse("");
        String splitted[] = s.split(" ");

        String myReverse = Arrays.stream(s.split(" "))
                            .map(word -> new StringBuilder().append(word).reverse().toString())
                            .peek(System.out::println)
                            .reduce((w1, w2) -> w1 + " " + w2)
                            .orElse("");
        System.out.println("My reversed words: " + myReverse);
        System.out.println("Splitted words: " + Arrays.toString(splitted));
        System.out.println("Reversed words: " + reversed);

        Person p = new Person();
        p.setName("John Doe");

        Person p2 = new Person();
        p2.setName("Jane Doe");

        Person p3 = new Person();
        p3.setName("John Doe2");

        Person[] persons = {p, p2, p3};
        String[] names = Arrays.stream(persons)
                        .map(Person::getName)
                        .toArray(String[]::new);

        String[] mynames = Arrays.stream(persons)
                        .map(
                            person -> {
                            String res = person.getName().startsWith("J") ? person.getName() : "";
                            return res;
                        })
                        .toArray(String[]::new);
        System.out.println("Names: " + Arrays.toString(names));
        // calculating all the prduct in the range (2,8)
        int i = 1;
        while(i <= 9)
        {
            System.out.println("Factorial of "+i+" is: "+factorial(i));
            i++;
        }
        System.out.println(palindrome("ueeu"));
        System.out.println(palindrome("ueieu"));
        System.out.println(palindrome("ueyuieu"));

        Mystack stack = new File().new Mystack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println("Stack elements are: ");
        stack.display();
        stack.peek();
        stack.pop();
        stack.display();
        
     
    }
    static int factorial(int num)
    {   
        if(num < 1){return -1;}
        int product = IntStream.range(1,num+1)
        .reduce((m,n) -> m*n)
        .orElse(1);
        System.out.println("Product: " + product);
        return product;
    }
   static boolean palindrome(String string)
   {
    return string.equals(new StringBuilder(string).reverse().toString());
   }

   class Mystack
   {
        int top =-1;
        int[]stack = new int[10];

        void peek()
        {
            if(top == -1)
            {
                System.out.println("Stack is empty");
            }
            else
            {
                System.out.println("Top element is: "+stack[top]);
            }
        }
        void push(int data)
        {
            if(top == stack.length-1)
            {
                System.out.println("Stack is full");
            }
            else
            {
                stack[++top] = data;
            }
        }
        void pop()
        {
            if (top == -1)
            {
                System.out.println("Stack is empty");
            }
            else
            {
                System.out.println("Popped element is: "+stack[top--]);
            }
        }
        void display()
        {
            if (top == -1)
            {
                System.out.println("Stack is empty");
            }
            else
            {
                for(int i = top; i >= 0; i--)
                {
                    System.out.println(stack[i]);
                }
                
            }
        }


   }
}