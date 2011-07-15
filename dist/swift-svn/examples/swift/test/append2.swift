int array[string];

foreach v in [0:2]{
	array << v;
}

foreach v,i in array{
	trace (v,i, array[i]);
}