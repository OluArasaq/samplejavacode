package javapractise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class sampleforstat {


    public static void main(String[] args){

     //wrapperHelper();
       // trimString();
       // LambdaExp();
        personlist();

    }

    public static void wrapperHelper(){

        String[] numb = {"10", "20","30","40"};
        int total = 0;

        for (String numbers : numb){

            total += Integer.parseInt(numbers);

        }
        System.out.println(total);

    }

    public static void trimString(){
        String something = "Hello World";
        System.out.println(something.substring(6).toLowerCase());
    }

    public static void LambdaExp(){
        //int[] value = {1,2,3,4,5,6};
         List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        // for (int i=0; i<=5; i++){
        //     System.out.println(values.get(i));
        // }


        //Iterator<Integer> i = values.iterator();
        //while(i.hasNext()){
          //  System.out.println(i.next());
        //}

        values.forEach(value -> System.out.println(value));
    }


    public static void personlist(){
        //Person pr = new Person();

        List<Person> people =   Arrays.asList( new Person("Carol", "Mandella", 56),
                new Person("Johnson", "Mohn", 67),
                        new Person("Tayo", "Morufu", 34),
                new Person("Stewart", "Smith", 45),
                new Person("Simon", "Joks", 25));

        people.stream().filter(person -> person.getLastName().startsWith("M"))
                .forEach(p -> System.out.println(p.getLastName()));

    }

}
