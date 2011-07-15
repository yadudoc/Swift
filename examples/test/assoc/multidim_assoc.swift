int array1[int][string][int][string];

array1[0]["a"][0]["a"] = 1;
array1[0]["a"][0]["b"] = 1;
array1[0]["a"][1]["a"] = 1;
array1[0]["a"][1]["b"] = 1;

array1[0]["b"][0]["a"] = 1;
array1[0]["b"][0]["b"] = 1;
array1[0]["b"][1]["a"] = 1;
array1[0]["b"][1]["b"] = 1;

array1[1]["a"][0]["a"] = 1;
array1[1]["a"][0]["b"] = 1;
array1[1]["a"][1]["a"] = 1;
array1[1]["a"][1]["b"] = 1;

array1[1]["b"][0]["a"] = 1;
array1[1]["b"][0]["b"] = 1;
array1[1]["b"][1]["a"] = 1;
array1[1]["b"][1]["b"] = 1;

foreach v,i in array1{
	trace(v,i);
}

//foreach v,i in array1[0]{
//	trace(v,i);
//}

//foreach v,i in array1[0]["a"]{
//	trace(v,i);
//}

//foreach v,i in array1[0]["a"][1]{
//	trace(v,i);
//}

//foreach v,i in array1[0]["a"][1]["a"]{
//	trace(v,i);
//}


