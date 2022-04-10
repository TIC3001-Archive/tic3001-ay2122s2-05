import java.io.IOException;
import java.util.*;

public class Alphabetizer extends Filter{
    private ArrayList<String> kwicList = new ArrayList<>();
    public Alphabetizer(Pipe input, Pipe output){
        super(input, output);
    }

    @Override
    protected void transform() throws IOException {
        while (input.hashNextLine()) {
            kwicList.add(input.readerLine());
        }
        Collections.sort(this.kwicList, new AlphabetizerComparator());
        Collections.sort(kwicList, new SortCaseInSensitive());

        for (String line:kwicList){
            output.writerLine(line);
        }
        input.closeReader();
        output.closeWriter();
    }

    private class SortCaseInSensitive implements Comparator {
        public final int compare(Object a, Object b) {
            String a1 = a.toString().toLowerCase();
            String b1 = b.toString().toLowerCase();
            return a1.compareTo(b1);
        }
    }
    private class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            char o1c = o1.toLowerCase().charAt(0);
            char o2c = o2.toLowerCase().charAt(0);
            compareValue = o1c - o2c;
            return compareValue;
        }
    }
}
