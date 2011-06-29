int array[];


foreach outer in [1:2]{
foreach inner in [1:10]{
	array += inner;
}
}

foreach outer in [1:2]{
foreach inner, index  in [1:10]{
	trace (index);
}
}
