package DictionaryApp.Feature;

import java.util.*;

public class Trie {
    private HashMap<Character, Trie> child;
    private String content;
    private boolean end = false;

    public Trie() {
        this("");
    }

    public Trie(String content) {
        this.content = content;
        this.child = new HashMap<Character, Trie>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEnd() {
        return end;
    }

    public void setChild(HashMap<Character, Trie> child) {
        this.child = child;
    }

    public HashMap<Character, Trie> getChild() {
        return child;
    }

    public void add(char character) {
        Trie trie = new Trie(content + character);
        child.put(character, trie);
    }

    public void insertWord(String word) {
        if (word == null) throw new IllegalArgumentException();
        Trie tmp = this;
        for (Character c : word.toCharArray()) {
            if (!tmp.child.containsKey(c)) tmp.add(c);
            tmp = tmp.child.get(c);
        }
        tmp.end = true;
    }

    public void deleteWord(String word) {
        delete(this, word, 0);
    }

    private boolean delete(Trie current, String word, int index) {
        if (index == word.length()) {
            if (!current.end) {
                return false;
            }
            setContent(null);
            current.end = false;
            return current.child.isEmpty();
        }
        char ch = word.charAt(index);
        Trie node = current.child.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.end;

        if (shouldDeleteCurrentNode) {
            current.child.remove(ch);
            return current.child.isEmpty();
        }
        return false;
    }

    private ArrayList<String> findAllByKeyWord() throws NullPointerException {
        ArrayList<String> tmp = new ArrayList<String>();
        if (this.isEnd()) tmp.add(this.getContent());
        for (HashMap.Entry<Character, Trie> entry : child.entrySet()) {
            Trie child = entry.getValue();
            Collection<String> childPrefixes = child.findAllByKeyWord();
            tmp.addAll(childPrefixes);
        }
        return tmp;
    }

    public ArrayList<String> predictedWords(String keyWord) throws NullPointerException {
        Trie tmp = this;
        for (char c : keyWord.toCharArray()) {
            if (tmp.child.containsKey(c)) {
                tmp = tmp.child.get(c);
            } else {
                return null;
            }
        }
        return tmp.findAllByKeyWord();
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insertWord("a cat");
        trie.insertWord("a dog");
        trie.insertWord("butterfly");
        trie.insertWord("tiger");
        trie.insertWord("addition");
        ArrayList<String> arrayList = new ArrayList<>(trie.predictedWords("c"));
        for(String s: arrayList){
            System.out.println(s);
        }
    }
}
