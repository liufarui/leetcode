package com.liufr.leetcode._codeleet;

/**
 * @author lfr
 * @date 2020/8/21 11:18
 *
 * 208. 实现 Trie (前缀树)
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 解题思路：
 * 树；
 * 然后有一个ifTail标记是否可以作为结尾.
 */
//class aaa {
//    @Test
//    void test() {
//        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.search("app"));
//    }
//}

public class _208_Trie {
    boolean ifTail = false;
    _208_Trie[] children;

    /**
     * Initialize your data structure here.
     */
    public _208_Trie() {
        children = new _208_Trie[26];
    }

    private _208_Trie insertChar(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new _208_Trie();
        }
        return children[c - 'a'];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        _208_Trie a208Trie = this;
        for (char c : word.toCharArray()) {
            a208Trie = a208Trie.insertChar(c);
        }
        a208Trie.ifTail = true;
    }

    private _208_Trie searchAt(String word) {
        _208_Trie a208Trie = this;
        for (char c : word.toCharArray()) {
            if (a208Trie.children[c - 'a'] == null) {
                return null;
            } else {
                a208Trie = a208Trie.children[c - 'a'];
            }
        }
        return a208Trie;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        _208_Trie tail = searchAt(word);
        if (tail == null) {
            return false;
        }
        return tail.ifTail;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchAt(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
