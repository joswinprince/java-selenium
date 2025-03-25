package com.automation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
 interface calc {
    int add(int a, int b);
}
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Tom");
        List<String> lowerCase = names.stream()
                                    .map(s -> 
                                    {
                                        if(s.startsWith("J"))
                                        {

                                            return s.toLowerCase();
                                        }
                                        return s;                                       
                                    })

                                    .collect(Collectors.toList());
        System.out.println(lowerCase);
    }
    
}
