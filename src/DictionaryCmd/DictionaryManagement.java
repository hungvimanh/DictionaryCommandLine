/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DictionaryCmd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Hung Vi Manh
 */
public class DictionaryManagement {

    Scanner sc = new Scanner(System.in);
    public ArrayList<Word> words = new ArrayList<>();

    public void insertFromFile() throws IOException {
        try {
            FileReader fileReader = new FileReader("data/dictionaries.txt");
            try (BufferedReader reader = new BufferedReader(fileReader)) {
                char c = (char) reader.read();
                String s;
                while ((s = reader.readLine()) != null) {
                    try {
                        String[] str = s.split("\t", 2);
                        Word w = new Word(str[0], str[1]);
                        words.add(w);
                    } catch (Exception e) {
                        //skip
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            Collections.sort(words, new ComparatorImpl());
        }
    }

    public void dictionaryExportToFile() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("data/dictionaries.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0; i < words.size(); i++) {
                printWriter.println(words.get(i).getWord_taget() + "\t" + words.get(i).getWord_explain());
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void Push() {
        System.out.println("Nhập từ cần thêm vào:\t");
        String push_taget = sc.next();
        sc.nextLine();
        System.out.println("Nhập giải thích:\t");
        String push_explain = sc.nextLine();

        Word push_word = new Word(push_taget, push_explain);
        words.add(push_word);
        Collections.sort(words, new ComparatorImpl());
    }

    public void Pop() {
        System.out.println("Nhập từ cần xoá:\t");
        String pop_word = sc.next();
        sc.nextLine();
        int index = BinarySearch(pop_word);
        if (index != -1) {
            words.remove(index);
        } else {
            System.out.println("Không tồn tại từ " + pop_word);
        }
    }

    public void Change() {
        System.out.println("Nhập từ cần sửa:\t");
        String change_word = sc.next();
        sc.nextLine();
        int index = BinarySearch(change_word);
        if (index != -1) {
            System.out.println("Nhập từ mới:\t");
            String change_taget = sc.next();
            sc.nextLine();
            System.out.println("Nhập giải thích:\t");
            String change_explain = sc.nextLine();
            Word new_word = new Word(change_taget, change_explain);
            words.set(index, new_word);
        } else {
            System.out.println("Không tồn tại từ " + change_word);
        }
    }

    public int BinarySearch(String text) {
        int low = 0;
        int high = words.size() - 1;
        int mid;
        
        while (low < high) {
            mid = (low + high) / 2;
            if (words.get(mid).getWord_taget().equals(text)) {
                return mid;
            } else if (words.get(mid).getWord_taget().compareTo(text) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (words.get(low).getWord_taget().equals(text)) {
            return low;
        }
        return -1;
    }

    private static class ComparatorImpl implements Comparator<Word> {

        public ComparatorImpl() {
        }

        @Override
        public int compare(Word w1, Word w2) {
            return w1.getWord_taget().compareTo(w2.getWord_taget());
        }
    }
}
