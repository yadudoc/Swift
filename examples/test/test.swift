int a[int][string][string];

a[5]["a"] << 10;
a[5]["a"] << 20;

foreach v,index in a[5]["a"]{
	trace (v,index);
	trace (a[5]["a"][index]);
}