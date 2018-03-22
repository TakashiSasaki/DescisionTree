var fs = require("fs");
var csv = require("csv");

var columns = [
  "sepal length",
  "sepal width",
  "petal length",
  "petal width",
  "class",
];

const parser = csv.parse({columns: columns});

parser.on('readable', () => {
  var data;
  while(data = parser.read()){
    asyncObjects[data];
  }
});

var asyncObjects = [];

parser.on("end", ()=>{
});

const readableStream = fs.createReadStream("iris.data");
readableStream.pipe(parser);

var csvSync = require("csv-parse/lib/sync");
let lines = fs.readFileSync("iris.data");
let objects = csvSync(lines, {columns: columns});

function X(objects){
  this.objects = objects;
  this.min = {};
  this.max = {};
  this.count = {};

  for(let i=0; i<objects.length; ++i) {
    const o = objects[i];
    if(o === undefined) continue;
    const keys = Object.keys(o);
    if(keys.length <= 1) continue;
    for(let j=0; j<keys.length; ++j) {
      const k = keys[j];
      this.min[k] = this.min[k] === undefined ? o[k] : Math.min(this.min[k] , o[k]);
      this.max[k] = this.max[k] === undefined ? o[k] : Math.max(this.max[k] , o[k]);
      this.count[k] = this.count[k] === undefined ? 1 : (this.count[k] + 1); 
    }// for j
  }//for i

  this.entoropy = function(){
    var sum = Object.values(this.count).reduce((p,c)=>{return p+c});
    var ent = Object.values(this.count).reduce((p,c)=>{return p-Math.log2(c/sum);});
    return ent;
  }
}

var x = new X(objects);
console.log(x);

