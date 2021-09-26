function generateDocument(characters, document) {
    // Write your code here.
    for(const current of document){
        let d=0;
        let c=0;
        for(const character of document){
            if(current === character){
                d++
            }
        }
        for(const character of characters){
            if(current === character){
                c++
            }
        }
        if(c<d){
            return false;
        }
    }
    return true;
}
function generateDocument(characters, document) {
    // Write your code here.
    const set = new Set()
    for(const current of document){
        let d = 0 ; 
        let c = 0;
        if(current in set){
            continue;
        } else {
            set.add(current);
        }
        for(const character of document){
            if(current === character) d++;
        }
        for(const character of characters){
            if(current === character) c++;
        }		
        if(c<d) return false;
    }
    return true;
}

function generateDocument(characters, document) {
    // Write your code here.
    const hash = {};
    for(const character of characters){
        if(character in hash){
            hash[character] += 1;
        } else {
            hash[character] = 1;
        }
    }
    for(const character of document){
        if(!(character in hash) || hash[character] == 0){
            return false;
        } 
        if(character in hash){
            hash[character] -= 1;
        }
    }	
    return true;
}

// Do not edit the line below.
exports.generateDocument = generateDocument;
