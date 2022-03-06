package com.company;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
    private ArrayList<String> kwicList = new ArrayList<String>();
    private ArrayList<String> lineTxt = new ArrayList<String>();
    private BufferedReader inputFile;
    private BufferedWriter outputFile;

    public static void main(String[] args) {
        Main kwic = new Main();
        kwic.input("C:\\test\\testcase4\\TitlesInput4.txt");
        kwic.shift();
        kwic.alphabetizer();
        kwic.alphabetizerFinal();
        kwic.output("C:\\test\\testcase4\\out.txt");
    }

    private void output(String filename) {
        Iterator<String> it = kwicList.iterator();
        try {
            outputFile = new BufferedWriter(new FileWriter(filename));
            while (it.hasNext()) {
                outputFile.write(it.next()+"\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (outputFile != null) {
                    outputFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * sort the words based on the comparison value of two characters.
     */
    private void alphabetizer() {
        Collections.sort(this.kwicList, new AlphabetizerComparator());
    }

    private void alphabetizerFinal() {
        Collections.sort(kwicList, new SortCaseInSensitive());
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

    private void input(String fileName) {
        try {
            inputFile = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
