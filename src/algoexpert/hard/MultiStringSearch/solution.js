function multiStringSearch(bigString, smallStrings) {
    // Write your code here.
    const answer = [];
    const set = {};
    const trie = new Trie();
    for(let i=0;i<bigString.length();i++) dfs(i,bigString,trie,set);
    for(const s in smallString) if(s in set) answer.push(true);
  }
function dfs(index, bigString, trie, set){
    if('*' in trie.root) set.add(trie.word);
    if(!(bigString[i] in trie.root)) return;
    dfs(index+1,bigString,trie.root[bigString[i]],set);
    return;
}
class Trie{
    constructor(){
        this.root = {};
        this.word = "";
    }
    add(word){
        trieNode = this.root;
        for(let i=0;i<word.length;i++){
            const c = word[i];
            if(!(c in trieNode.root)) trieNode.root[c] = new Trie();
            trieNode = trieNode.root[c];
        }
        trieNode.root['*'] = null;
        trieNode.word = word;
    }
}
  
  // Do not edit the line below.
  exports.multiStringSearch = multiStringSearch;
  