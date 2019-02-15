import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(3);
        numbers.add(7);

        int sum = 17;

        System.out.println(findSum(sum,numbers));

    }

    public static boolean findSum(int sum, ArrayList<Integer> numbers){
        ArrayList<Integer> numbersToFind = new ArrayList<>();
        for (int number: numbers) {
            if (numbersToFind.contains(number))
                return true;
            else
                numbersToFind.add(sum-number);
        }
        return false;
    }
}
