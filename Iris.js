const fs = require("fs");
const csv = require("csv");
const csvSync = require("csv-parse/lib/sync");

class Iris extends Array{

	constructor(){
		super();

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
	}//constructor

}//class Iris

if(typeof process !== "undefined") {
	const x = process.argv[1].split("/");  
	const y = x[x.length-1];
	if(y === "Iris.js") test();
}

function test(){
	console.log(new Iris);
}

