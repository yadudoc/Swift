int a[][];

a["hi"]["!"] = 10;
a["hi"]["!"] = 20;
a["hi"]["!"] = 30;

foreach value, index in a["hi"] {
	trace(value);	     
}
