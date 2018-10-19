/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DictionaryCmd;

/**
 *
 * @author Hung Vi Manh
 */
public class Word{
    private String word_taget;
    private String word_pronun;
    private String word_explain;
    private String word_listen;

    public Word(String word_taget, String word_explain) {
        this.word_taget = word_taget;
        this.word_explain = word_explain;
    }
    
    public Word(String word_taget, String word_pronun, String word_explain, String word_listen) {
        this.word_taget = word_taget;
        this.word_pronun = word_pronun;
        this.word_explain = word_explain;
        this.word_listen = word_listen;
    }
    
    public String getWord_taget() {
        return word_taget;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_taget(String word_taget) {
        this.word_taget = word_taget;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }   

    public String getWord_pronun() {
        return word_pronun;
    }

    public void setWord_pronun(String word_pronun) {
        this.word_pronun = word_pronun;
    }

    public String getWord_listen() {
        return word_listen;
    }

    public void setWord_listen(String word_listen) {
        this.word_listen = word_listen;
    }
}
