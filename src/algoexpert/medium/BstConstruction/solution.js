// Do not edit the class below except for
// the insert, contains, and remove methods.
// Feel free to add new properties and methods
// to the class.
class BST {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
  
    insert(value) {
        // Write your code here.
        if(value<this.value) {
            if(this.left === null) {
                this.left = new BST(value);
            } else {
                this.left.insert(value);			
            }
        } else {
            if (this.right === null){
                this.right = new BST(value);
            } else {
                this.right.insert(value);			
            }
        } 		
        // Do not edit the return statement of this method.
        return this;
    }
  
    contains(value) {
        // Write your code here.
        if(value<this.value) {
            if(this.left !== null){
                return this.left.contains(value);			
            } else {
                return false;
            }
        } else if (value > this.value) {
            if(this.right !== null){
                return this.right.contains(value);
            } else {
                return false;
            }
        } else { 
            return true;
        }
    }
  
    remove(value, parent = null) {
        // Write your code here.
        if(value < this.value) {
            if(this.left !== null) {
                this.left.remove(value,this);
            }
        } else if(value > this.value) {
            if(this.right !== null) {
                this.right.remove(value,this);
            }
        } else {
            if(this.left !== null && this.right !== null) {
                this.value = this.right.getMinValue();
                this.right.remove(this.value,this);
            } else if(parent === null) {
                if(this.left !== null) {
                    this.value = this.left.value;
                    this.right = this.left.right;
                    this.left = this.left.left;
                } else if(this.right !== null){
                    this.value = this.right.value;
                    this.right = this.right.right;
                    this.left = this.right.left;
                } else {
                    //single node
                }
            } else if (parent.left === this) {
                parent.left = this.left !== null ? this.left : this.right;
            } else if (parent.right === this) {
                parent.right = this.left !== null ? this.left : this.right;
            }
        }
        // Do not edit the return statement of this method.
        return this;
    }
      
    getMinValue() {
        if(this.left === null) {
            return this.value;
        } else {
            return this.left.getMinValue();
        }
    }
}
  
// Do not edit the line below.
exports.BST = BST;
  