int array[int][string];

array[1] << 5;
array[1] << 10;
array[1] << 20;

foreach v,i in array[1]{
	trace( array[1][i], i);
}