import java.util.*;
class StreamCreation {

    public static void main(String[] args) {
        System.out.println("Stream creation methods!\n");

        int[] nums = new int[] {1,23,4,69,5,6,67,78,9,6,5};
        List<String> names = new ArrayList<>( List.of("vignesh" , "bunga" , "unga" , "chodu") );

        System.out.println("1. Using Arrays.stream() \n output : ");
        Arrays.stream(nums).forEach(i -> System.out.print( i + " / "));

        System.out.println("\n2. Using Collection.Stream()");
        names.stream().map(String::toUpperCase).forEach(n -> System.out.print(n + " / "));
    }

}