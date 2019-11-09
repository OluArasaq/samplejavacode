package javapractise;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class sampleforstat {


    public static void main(String[] args){

     //wrapperHelper();
       // trimString();
       // LambdaExp();
       // personlist();
       // timeZone();
        //groupTimeZone();
        //partitionTimeZone();
       // filterListToCollection();
        //useDistint();
      // useLimit();
       // sumArrayInt();
        sortedInStream();

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

    public static void timeZone(){

        List<String> zones = Arrays.asList(TimeZone.getAvailableIDs());
        zones.stream().forEach(z -> System.out.println(z));
    }


    //Filters out any zones that don't have a forward slash in them
    //Groups the zones by their group (e.g. Europe, Africa)
    //Counts how many zones are in each group

    public static void groupTimeZone(){

        Map<String, Long> result = Arrays.asList(TimeZone.getAvailableIDs())
                .stream()
                .filter(s -> s.indexOf("/")>0)
                .collect(Collectors.groupingBy((String s)-> s.substring(0, s.indexOf("/")),
                       Collectors.counting()));
                System.out.println(result);
    }


    //use partitioning

    public static void partitionTimeZone(){

        List<String> zones = Arrays.asList(TimeZone.getAvailableIDs());

        Map<Boolean, List<String>> compareZone = zones.stream()
                .collect(Collectors.partitioningBy(s -> s.indexOf("/")>0));

        System.out.println(compareZone);
    }


    public static void filterListToCollection(){
        List<Person> people =   Arrays.asList( new Person("Carol", "Mandella ", 56),
                new Person("Johnson", "Mohn", 67),
                new Person("Tayo", "Smith", 34),
                new Person("Stewart", "Smith", 45),
                new Person("Simon", "Joks", 25));

      List<Person> filterList =  people.stream()
              .filter(person -> person.getLastName().equalsIgnoreCase("Smith"))
              .collect(Collectors.toList());

      System.out.println(filterList);
    }

    //It removes duplicate line in the text file
    public static void useDistint() {
        // int[] intArray = new int[] {4, 5, 6,9, 5, 67, 67, 90};
        // String[] stringArray = new String[] {"Olu", "Tayo", "Latif", "Rahidat"};

        Path path = Paths.get("src/main/java/util/testdata.txt");
        try {
            Files.lines(path).distinct()
                    .forEach(s -> System.out.println(s));
        } catch (IOException ex) {
            Logger.getLogger(sampleforstat.class.getName())
                    .log(Level.SEVERE, "IO Error", ex);
        }

    }
    public static void useLimit() {
            Path path = Paths.get("src/main/java/util/testdata2.txt");
            try {
                Files.lines(path).limit(20)
                        .forEach(s -> System.out.println(s));
            } catch (IOException ex) {
                Logger.getLogger(sampleforstat.class.getName())
                        .log(Level.SEVERE, "IO Error", ex);
            }
        }

    public static void sumArrayInt(){
        int[] intArray = new int[] {4, 5, 6,9, 5, 67, 67, 90};

        int result = Arrays.stream(intArray).sum();
        System.out.println(result);

    }

    public static void sortedInStream(){
        List<String> sortElement = Arrays.asList("Charlse", "Bimbo", "Abida", "kaite", "tayo");

       List<String> sortedElement =  sortElement.stream().sorted().collect(Collectors.toList());
       sortedElement.stream().forEach(s -> System.out.println(s));
    }

    public static void sortdescendingOrder(){

        List<String> sortElement = Arrays.asList("Charlse", "Bimbo", "Abida", "kaite", "tayo");
        List<String> sortedElement =  sortElement.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        sortedElement.stream().forEach(s -> System.out.println(s));
    }
}
