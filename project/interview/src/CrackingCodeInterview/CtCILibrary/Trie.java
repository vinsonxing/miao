package CrackingCodeInterview.CtCILibrary;

/**
 * Created with IntelliJ IDEA.
 * User: qlu
 * Date: 7/27/14
 * Time: 11:06 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
public class Trie {
  // The root of this trie.
  private TrieNode root;

  /* Takes a list of strings as an argument, and constructs a trie that stores these strings. */
  public Trie(ArrayList<String> list)
  {
    root = new TrieNode();
    for (String word : list) {
      root.addWord(word);
    }
  }


  /* Takes a list of strings as an argument, and constructs a trie that stores these strings. */
  public Trie(String[] list)
  {
    root = new TrieNode();
    for (String word : list) {
      root.addWord(word);
    }
  }

  /* Checks whether this trie contains a string with the prefix passed
   * in as argument.
   */
  public boolean contains(String prefix, boolean exact)
  {
    TrieNode lastNode = root;
    int i = 0;
    for (i = 0; i < prefix.length(); i++) {
      lastNode = lastNode.getChild(prefix.charAt(i));
      if (lastNode == null) {
        return false;
      }
    }
    return !exact || lastNode.terminates();
  }

  public boolean contains(String prefix) {
    return contains(prefix, false);
  }
}
