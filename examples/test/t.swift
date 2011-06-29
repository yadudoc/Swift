int array[][];	
foreach dummy in [1:2] {
	array["key"] += 1;
	array["key"] += 2;
	foreach v in array["key"]{
	trace (v);
	}
}