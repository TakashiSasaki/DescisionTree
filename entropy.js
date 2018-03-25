require("myassert");

function entropy(histogram){
	assert.isArray(histogram);
	const sum = histogram.reduce((c,p)=>{assert.isInteger(c); assert.isInteger(p); return c + p;});
	const probabilities = histogram.map((x)=>{return x/sum;});
	const entropies = probabilities.map((x)=>{return x===0 ? 0 : -x * Math.log2(x);});
  return entropies.reduce((a,b)=>{return a+b;});
}//entropy



