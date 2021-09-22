// Do not edit the class below except
// for the depthFirstSearch method.
// Feel free to add new properties
// and methods to the class.
class Node {
    constructor(name) {
      this.name = name;
      this.children = [];
    }
  
    addChild(name) {
      this.children.push(new Node(name));
      return this;
    }
  
    depthFirstSearch1(array) {
      // Write your code here.
          array.push(this.name);
          for(let i=0;i<this.children.length ;i++){
              this.children[i].depthFirstSearch1(array);
          }
          return array;
    }
    depthFirstSearch2(array) {
        // Write your code here.
            array.push(this.name);
            for(const child of this.children){
                child.depthFirstSearch2(array);
            }
            return array;
      }
  }
  
  // Do not edit the line below.
  exports.Node = Node;
  