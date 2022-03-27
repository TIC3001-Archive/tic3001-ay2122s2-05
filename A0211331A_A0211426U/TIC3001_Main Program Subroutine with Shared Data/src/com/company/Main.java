package com.company;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
    private ArrayList<String> kwicList = new ArrayList<String>();
    private ArrayList<String> lineTxt = new ArrayList<String>();
    private ArrayList<String> ignoreTxt = new ArrayList<String>();
    private ArrayList<String> requiredTxt = new ArrayList<String>();
    private BufferedReader inputFile;
    private BufferedWriter outputFile;

    public static void main(String[] args) {
        Main kwic = new Main();
        kwic.input("E:\\test\\Test3\\Titles3.txt");
        kwic.inputIgnore("E:\\test\\Test3\\Ignored3.txt");
        kwic.inputRequired("E:\\test\\Test3\\Required3.txt");
        kwic.shift();
        kwic.ignore();
        kwic.required();
        kwic.alphabetizer();
        kwic.alphabetizerFinal();
        kwic.output("E:\\test\\Test3\\out123.txt");
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

    private void inputIgnore(String fileName) {
        try {
            inputFile = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                ignoreTxt.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void inputRequired(String fileName) {
        try {
            inputFile = new BufferedReader(new FileReader(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String line;
        try {
            while ((line = inputFile.readLine()) != null) {
                requiredTxt.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ignore() {
        for (int i = 0; i < kwicList.size(); i++) {
            String tmp = kwicList.get(i).toString();
            String arr[] = tmp.split(" ", 2);
            String firstWord = arr[0];
            for (int j = 0; j < ignoreTxt.size(); j++) {
                if (Objects.equals(firstWord.toLowerCase(), ignoreTxt.get(j).toLowerCase())) {
                    kwicList.remove(i);
                    i--;
                }
            }
        }
    }

    private void required() {
        int count = 0;
        for (int i = 0; i < kwicList.size(); i++) {
            String tmp = kwicList.get(i).toString();
            String arr[] = tmp.split(" ", 2);
            String firstWord = arr[0];
            for (int j = 0; j < requiredTxt.size(); j++) {
                String tmp2 = requiredTxt.get(j).toLowerCase();
                if(firstWord.toLowerCase().equals(tmp2)) {
                    break;
                }else{
                    count = count + 1;
                }

                if (count > 2){
                    kwicList.remove(i);
                    if (i != 0) {
                        i = i - 1;
                    }else {
                        i = -1;
                    }
                    count = 0;
                }

            }
        }
    }

}
