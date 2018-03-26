const fs = require("fs");
const csv = require("csv");
const csvSync = require("csv-parse/lib/sync");

class Iris extends Array{

	constructor(){
		super();
    Object.defineProperty(this, "max", {value:{}, writable: true});
    Object.defineProperty(this, "min", {value:{}, writable: true});
    Object.defineProperty(this, "sum", {value:{}, writable: true});
    Object.defineProperty(this, "count", {value:{}, writable: true});
    Object.defineProperty(this, "average", {value:{}, writable: true});

		const columns = [
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

		let lines = fs.readFileSync("iris.data");
		let objects = csvSync(lines, {columns: columns});
		objects.forEach((x)=>{this.push(x);});

    this.calcMinMaxSumCount();

	}//constructor

  calcMinMaxSumCount(){
    this.forEach((x)=>{
      Object.keys(x).forEach((y)=>{
        this.max[y] =
          typeof this.max[y] === "undefined"
          ? this.max[y] = Number(x[y])
          : Math.max(this.max[y], Number(x[y]));
        this.min[y] = 
          typeof this.min[y] === "undefined"
          ? this.min[y] = Number(x[y])
          : Math.min(this.min[y], Number(x[y]));
        this.sum[y] =
          typeof this.sum[y] === "undefined"
          ? this.sum[y] = Number(x[y])
          : this.sum[y] + Number(x[y]);
        this.count[y] =
          typeof this.count[y] === "undefined"
          ? this.count[y] = 1 : this.count[y]+1;
        this.average[y] = this.sum[y] / this.count[y];
      });// forEach y
    });// forEach x
  }// calcMinMaxSumCount

}//class Iris

if(typeof process !== "undefined") {
	const x = process.argv[1].split("/");  
	const y = x[x.length-1];
	if(y === "Iris.js") test();
}

function test(){
	var iris = new Iris();
  console.log("min");
  console.log(iris.min);
  console.log("max");
  console.log(iris.max);
  console.log("sum");
  console.log(iris.sum);
  console.log("count");
  console.log(iris.count);
  console.log("average");
  console.log(iris.average);

}

if(typeof exports === "undefined") exports = {};
exports.Iris = Iris;

