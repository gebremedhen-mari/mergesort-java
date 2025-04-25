import java.util.LinkedList;

public class Mergesort {

    public static void main(String[] args) {
        
        LinkedList<Integer> input = new LinkedList<>();
        input.add(3);
        input.add(1);
        input.add(4);
        input.add(2);
        input.add(5);

        LinkedList<Integer> sorted = sort(input);
        System.out.println("Original: " + input);
        System.out.println("Sorted: " + sorted);
    }

    public static LinkedList<Integer> sort(LinkedList<Integer> ll) {
        if (ll.size() <= 1) {
            return new LinkedList<>(ll); 
        }

        int mid = ll.size() / 2;
        LinkedList<Integer> left = makeNewList(ll, 0, mid - 1);
        LinkedList<Integer> right = makeNewList(ll, mid, ll.size() - 1);

        LinkedList<Integer> sortedLeft = sort(left);
        LinkedList<Integer> sortedRight = sort(right);

        return merge(sortedLeft, sortedRight);
    }

    public static LinkedList<Integer> makeNewList(LinkedList<Integer> original, int fromHere, int toHere) {
        LinkedList<Integer> newList = new LinkedList<>();
        for (int i = fromHere; i <= toHere; i++) {
            newList.add(original.get(i));
        }
        return newList;
    }

    public static LinkedList<Integer> merge(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> result = new LinkedList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                result.add(a.get(i));
                i++;
            } else {
                result.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            result.add(a.get(i));
            i++;
        }

        while (j < b.size()) {
            result.add(b.get(j));
            j++;
        }

        return result;
    }
}
