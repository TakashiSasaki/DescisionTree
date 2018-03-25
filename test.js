var fs = require("fs");
var csv = require("csv");
var assert = require("myassert");


function X(objects){
  this.objects = objects;
  this.min = {};
  this.max = {};
  this.histogram = {};

  for(let i=0; i<objects.length; ++i) {
    const o = objects[i];
    if(o === undefined) continue;
    const keys = Object.keys(o);
    if(keys.length <= 1) continue;
    for(let j=0; j<keys.length; ++j) {
      const k = keys[j];
      this.min[k] = this.min[k] === undefined ? o[k] : Math.min(this.min[k] , o[k]);
      this.max[k] = this.max[k] === undefined ? o[k] : Math.max(this.max[k] , o[k]);
      this.histogram[k] = this.histogram[k] === undefined ? 1 : (this.histogram[k] + 1); 
    }// for j
  }//for i

}

var x = new X(objects);
console.log(x);


