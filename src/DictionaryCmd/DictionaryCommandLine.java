/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DictionaryCmd;

import java.io.IOException;

/**
 *
 * @author Hung Vi Manh
 */
public class DictionaryCommandLine extends DictionaryManagement {

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        insertFromFile();
        showAllWords();
        String outPut = null;
        while (!"".equals(outPut)) {
            outPut = dictionaryLookup();
            if(outPut.equals("return")) continue;
            System.out.println(outPut);
        }
    }

    public void dictionaryStable() throws IOException {
        insertFromFile();
        showAllWords();
        System.out.println("Các thao tác:");
        System.out.println("1. Hiển thị tất cả các từ");
        System.out.println("2. Tra từ");
        System.out.println("3. Thêm từ");
        System.out.println("4. Sửa từ");
        System.out.println("5. Xoá từ");
        System.out.println("6. Ghi ra file");
        System.out.println("Default: Thoát");

        int choose;
        do {
            System.out.println("\nChọn thao tác:\t");
            choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    showAllWords();
                    break;
                }
                case 2: {
                    dictionarySearcher();
                    break;
                }
                case 3: {
                    Push();
                    break;
                }
                case 4: {
                    Change();
                    break;
                }
                case 5: {
                    Pop();
                    break;
                }
                case 6: {
                    dictionaryExportToFile();
                    break;
                }
                default:
                    break;
            }
        } while (choose != 0 && choose < 7);

    }

    public void insertFromCommandline() {
        System.out.println("Nhập số lượng từ vựng:\t");
        int numOf = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numOf; i++) {
            System.out.println("Nhập từ:\t");
            String word_taget = sc.next();
            sc.nextLine();
            System.out.println("Nhập giải thích:\t");
            String word_explain = sc.nextLine();
            Word w = new Word(word_taget, word_explain);
            words.add(w);
        }
        sc.close();
    }

    public void showAllWords() {
        System.out.println("No\t English\t| \tVietnamese");
        for (int i = 0; i < words.size(); i++) {
            System.out.println(i+1 + "\t" + words.get(i).getWord_taget() + "\t" + "|" + "\t" + words.get(i).getWord_explain());
        }
    }

    public String dictionaryLookup() {
        System.out.println("Nhập từ cần tra:(Nhập 0 để kết thúc!)\t");
        String w = sc.next();
        if (w.equals("0")) {
            return "";
        } else {
            int index = BinarySearch(w);
            if (index == -1) {
                System.out.println("Không tìm thấy từ " + w);
                return "return";
            }
            return words.get(index).getWord_explain();
        }
    }

    public void dictionarySearcher() {
        int count=0;
        System.out.println("Nhập vào:\t");
        String s = sc.next();
        for (int i = 0; i < words.size(); i++) {
            if ((words.get(i).getWord_taget()).startsWith(s)) {
                count++;
                System.out.println(count + "\t" + words.get(i).getWord_taget() + "\t" + "|" + "\t" + words.get(i).getWord_explain());
            }
        }
    }

    
}
