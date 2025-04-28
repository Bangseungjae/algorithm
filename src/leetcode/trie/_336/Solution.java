package leetcode.trie._336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie trie = new Trie();
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            trie.insert(i, words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            results.addAll(trie.search(i, words[i]));
        }
        return results;
    }

}

class TrieNode {
    int wordId;
    TrieNode[] children;
    List<Integer> palindromeWordIds;

    TrieNode() {
        wordId = - 1;
        children = new TrieNode[26];
        palindromeWordIds = new ArrayList<>();
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public void insert(int index, String word) {
        TrieNode cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (isPalindrome(word, 0, i)) {
                cur.palindromeWordIds.add(index);
            }
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.wordId = index;
    }

    public List<List<Integer>> search(int index, String word) {
        TrieNode cur = root;
        List<List<Integer>> result = new ArrayList<>();

        for (int j = 0; j < word.length(); j++) {
            if (cur.wordId >= 0 && isPalindrome(word, j, word.length() - 1)) {
                result.add(Arrays.asList(index, cur.wordId));
            }

            if (cur.children[word.charAt(j) - 'a'] == null) {
                return result;
            }
            cur = cur.children[word.charAt(j) - 'a'];
        }

        // 끝까지 탐색했을 때 단어 ID가 있는 경우
        if (cur.wordId >= 0 && cur.wordId != index) {
            result.add(Arrays.asList(index, cur.wordId));
        }
        for (int palindromeWordId : cur.palindromeWordIds) {
            result.add(Arrays.asList(index, palindromeWordId));
        }
        return result;
    }
}