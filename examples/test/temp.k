include("sys.k")
set(x, 3)

3 + 3

echo("{x}")
echo("hi")

element(f, [x, y, z]
  echo("{x} {y} {z}")
)

element(g, []
  x=7
  y=5
  z=3
)

element(h, []
  9, 0, 1
)

f(z=1,4,6)
f(g())
f(h())


/*
list (
     parallel (
     	      echo("value1")
	      echo("value2")
	      )
     )	      
*/