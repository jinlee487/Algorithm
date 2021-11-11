// Do not edit the class below except for the
// populateSuffixTrieFrom and contains methods.
// Feel free to add new properties and methods
// to the class.
class SuffixTrie {
    constructor(string) {
      this.root = {};
      this.endSymbol = '*';
      this.populateSuffixTrieFrom(string);
    }
  
    populateSuffixTrieFrom(string) {
      // Write your code here.
          for(let i=0;i<string.length;i++){
              let currentNode = this.root;
              for(let j=i;j<string.length;j++){
                  const letter = string[j];
                  if(!(letter in currentNode)) currentNode[letter] = {};
                  currentNode = currentNode[letter];
              }
              currentNode[this.endSymbol] = true;
          }
    }
  
    contains(string) {
      // Write your code here.
          let currentNode = this.root;
          for(let i=0;i<string.length;i++){
              const letter = string[i];
              if(!(letter in currentNode)) return false;
              currentNode = currentNode[letter];
          }
          return currentNode[this.endSymbol] === true;
    }
  }
  
  // Do not edit the line below.
  exports.SuffixTrie = SuffixTrie;
  