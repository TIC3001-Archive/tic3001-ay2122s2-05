package com.company;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
    private ArrayList<String> kwicList = new ArrayList<String>();
    private ArrayList<String> lineTxt = new ArrayList<String>();
    static ArrayList<String> moviesAdd = new ArrayList<String>();
    static ArrayList<String> courseAdd = new ArrayList<String>();
    private BufferedReader inputFile;
    public static String line ="____________________________________________________________\n";
    String[] fileNames = new String[]{"C:\\test\\testing1\\CourseTitles.txt", "C:\\test\\testing1\\MovieTitles.txt"};
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Main kwic = new Main();
        kwic.greet();
        kwic.input();
        kwic.shift();
        kwic.output();
    }

    /** Prints greeting message. */
    public static void greet() {
        String start = "Welcome to KWIC!\n";
        String end = "Please input the word to be search:\n";
        System.out.println(line + start + end);
    }

    /** Prints exit message. */
    public static void Echo(){
        System.out.println(line + "execution ends\n" + line);
    }

    private void input() {
        for(String fileName: fileNames ) {
            try {
                inputFile = new BufferedReader(new FileReader(fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            String line;
            try {
                lineTxt.add(fileName.substring(17));
                while ((line = inputFile.readLine()) != null) {
                    lineTxt.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void alphabetizer() {
        Collections.sort(this.courseAdd, new AlphabetizerComparator());
    }

    private void alphabetizerFinal() {
        Collections.sort(courseAdd, new SortCaseInSensitive());

    }

    /**
     * sort the character but ignore case sensitive.
     */
    private class SortCaseInSensitive implements Comparator {
        public final int compare(Object a, Object b) {
            String a1 = a.toString().toLowerCase();
            String b1 = b.toString().toLowerCase();
            return a1.compareTo(b1);
        }
    }
    /**
     * return the comparison value of two characters.
     * @return comparison value of two characters.
     * @throws NullPointerException  If both strings are null.
     */
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

    private void shift() {
        Iterator<String> it = lineTxt.iterator();
        while (it.hasNext()) {
            StringTokenizer token = new StringTokenizer(it.next());
            ArrayList<String> tokens = new ArrayList<String>();
            int i = 0;
            int count = token.countTokens();
            while (i < count) {
                tokens.add(token.nextToken());
                i++;
            }

            for (i=0; i < count; i++) {
                StringBuffer lineBuffer = new StringBuffer();
                int index = i;
                for (int f=0; f < count; f++) {
                    if (index >= count)
                        index = 0;

                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    index++;
                }
                String tmp = lineBuffer.toString();
                kwicList.add(tmp);
            }
        }
    }

    public static void printFirstOutput() {
        if (!courseAdd.isEmpty()){
            System.out.println("CourseTitles.txt");
            for (int i = 0; i < courseAdd.size(); i++) {
                System.out.println( courseAdd.get(i) + "\n");
            }
        }

    }
    public static void printSecondOutput() {
        if (!moviesAdd.isEmpty()) {
            System.out.println("MovieTitles.txt");
            for (int i = 0; i < moviesAdd.size(); i++) {
                System.out.println(moviesAdd.get(i) + "\n");
            }
        }
    }

    private void output() {
        int count = 0;
        Boolean stop = false;
        while (!stop) {
            String input = in.nextLine();
            if (input.equals("q")) {
                Echo();
                stop = true;
            } else {
                for (int i = 0; i < kwicList.size(); i++) {
                    String first = "CourseTitles.txt" ;
                    String second = "MovieTitles.txt";
                    String tmp = kwicList.get(i).toString();
                    //System.out.println(tmp + "\n");
                    String arr[] = tmp.split(" ", 2);
                    String firstWord = arr[0];
                    if (firstWord.toLowerCase().equals(first.toLowerCase())) {
                        count = 0;
                    }else if (firstWord.toLowerCase().equals(input.toLowerCase()) && (count == 0)){
                        courseAdd.add(tmp);
                        alphabetizer();
                        alphabetizerFinal();
                    }else if (firstWord.toLowerCase().equals(second.toLowerCase())) {
                        count = 1;
                    }else if (firstWord.toLowerCase().equals(input.toLowerCase()) && (count == 1)){
                        moviesAdd.add(tmp);
                        alphabetizer();
                        alphabetizerFinal();
                    } else {
                        continue;
                    }
                }
                printFirstOutput();
                printSecondOutput();
                System.out.println(line);
            }
        }

    }
}


